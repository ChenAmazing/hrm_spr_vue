package com.amzc.demo.service;

import com.amzc.demo.domain.FileBean;
import com.amzc.demo.utils.ChangeSize;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class DownAndUpImpl implements DownAndUp {

    private static final long serialVersionUID = 1L;

    @Override
    public List<FileBean> showItem() throws Exception{
        //定义要遍历的文件路径
        String rootPath = "G:\\DownAndUpTest";
        // 向队列存放File
        File root = new File(rootPath);
        // 创建队列
        Queue<File> queue = new LinkedList<File>();
        // 把根节点入队
        queue.offer(root);
        // 循环的条件，如果队列不为空，一直循环，目的是：将遍历出来的文件名字，和路径放到list，并且放到request域中，在jsp中显示
        List<FileBean> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            // 先获取根节点
            File file = queue.poll();
            // 获取file文件下的所有子节点
            File[] files = file.listFiles();
            // 循环遍历
            for (File f : files) {
                // 拿到每一个File对象，判断当前File是文件还是文件夹
                if (f.isFile()) {
                    ChangeSize cz = new ChangeSize();
                    long size = f.length();
                    String fsize = cz.Change(size);
                    // 如果是一个文件，提供下载。显示到页面上。
                    //自己定义了一个filebean类，封装两个值，文件的绝对路径，另一个是文件名字
                    FileBean bean = new FileBean();
                    //将得到的文件名字封装到FileBean对象里面去
                    bean.setFilepath(f.getCanonicalPath());
                    bean.setFilename(f.getName());
                    bean.setFilesize(fsize);
                    //再讲对象放到集合中
                    list.add(bean);
                    System.out.println("--->" + f.getCanonicalPath() + f.getName() + fsize);
                } else {
                    // 如果是一个文件夹
                    queue.offer(f);
                }
//                //用lambda表达式遍历集合
//                list.forEach(li->System.out.println(li));
            }
        }
        return list;
    }
}
