package com.amzc.demo.controller;

import com.amzc.demo.domain.DownRequest;
import com.amzc.demo.domain.FileBean;
import com.amzc.demo.service.DownAndUp;
import com.amzc.demo.utils.ItemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Objects;

@Controller
public class DownloadController {
    @Autowired
    DownAndUp downAndUp;

    @CrossOrigin
    @PostMapping(value = "api/showItem")
    @ResponseBody
    public ItemResult showItem() throws Exception {
        List<FileBean> fileBeans = downAndUp.showItem();
        Object[] fileArrays = fileBeans.toArray();
        return new ItemResult(fileArrays,200);
    }

    @CrossOrigin
    @PostMapping(value = "api/download")
//    @ResponseBody
    public void download(@RequestBody DownRequest dq, HttpServletRequest request, HttpServletResponse resp) throws IOException {
        String fileName = dq.getFilename();
        String filePath = dq.getFilepath();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            //            application/octet-stream
            resp.setContentType("application/vnd.ms-excel;charset=utf-8");//设置返回格式为流
            resp.setCharacterEncoding("UTF-8");
            resp.setHeader("Content-Disposition",
                    "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) > 0) {
                resp.getOutputStream().write(b, 0, len);
            }
        }catch (Exception e){

        }finally {
            resp.getOutputStream().flush();
            resp.getOutputStream().close();
            fis.close();
        }
//        return "success";
    }

    @CrossOrigin
    @PostMapping(value = "api/upload")
    @ResponseBody
    public void upload(MultipartFile file){
        if (Objects.isNull(file) || file.isEmpty()) {
            System.out.println("===文件为空===");
        }else{
//            System.out.println(file.getOriginalFilename());
            try {
                byte[] bytes = file.getBytes();
                String path = "G:\\DownAndUpTest"+"\\"+file.getOriginalFilename();
                FileOutputStream fos = new FileOutputStream(new File(path));
                fos.write(bytes);
                fos.close();
                System.out.println("===写入成功===");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
