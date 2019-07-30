package com.amzc.demo.controller;

import com.amzc.demo.domain.Department;
import com.amzc.demo.domain.ReqBody;
import com.amzc.demo.service.DepartmentService;
import com.amzc.demo.utils.DepartmentResultful;
import com.amzc.demo.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping(value = "api/department")
    @CrossOrigin
    @ResponseBody
    public DepartmentResultful getDepartment(@RequestBody ReqBody rb){
        PageHelper.startPage(rb.getCurrentPage(), rb.getPagesize());
        List<Department> departmentList =  departmentService.getDepartment();
        Object[] data = departmentList.toArray();
        PageInfo page = new PageInfo<>(departmentList);//不指定泛型
        int total = (int) page.getTotal();
        return new DepartmentResultful(200,data,total);
    }

    @PostMapping(value = "api/removeDepartment")//post请求的路径不能和user的一样，否则handlemapping会找不到要映射的方法
    @CrossOrigin
    @ResponseBody
    public Result removeDepartment(@RequestBody Object id){
        String s = String.valueOf(id);//后端接收的是json格式，"{id=1}",转换数据时需要把前后多余的东西去掉
        int removeId = Integer.parseInt(s.substring(4, s.length() - 1));
        departmentService.removeDepartment(removeId);
        return new Result(200);
    }

    @CrossOrigin
    @PostMapping(value = "api/addDepartment")
    @ResponseBody
    //jackson的反序列化需要无参构造函数，如果实体类中添加了一个为了方便实例化该类用的构造函数，导致JVM不会添加默认的无参构造函数
    public Result addDepartment(@RequestBody Department department){//后端数据接口写一个类就行，其他设空或者默认值
        departmentService.addDepartment(department);
        return new Result(200);
    }

    @CrossOrigin
    @PostMapping(value = "api/updateDepartment")
    @ResponseBody
    public Result editDepartment(@RequestBody Department department){
        departmentService.updateDepartment(department);
        return new Result(200);
    }
}
