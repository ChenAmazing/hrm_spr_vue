package com.amzc.demo.controller;

import com.amzc.demo.domain.AddUser;
import com.amzc.demo.domain.ReqBody;
import com.amzc.demo.domain.UserList;
import com.amzc.demo.domain.UserLogin;
import com.amzc.demo.service.getUsersService;
import com.amzc.demo.utils.Result;
import com.amzc.demo.utils.Resultful;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
public class LoginController {
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody UserLogin requestUserLogin) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUserLogin.getUsername();
        username = HtmlUtils.htmlEscape(username);
        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUserLogin.getPassword())) {
            String message = "账号密码错误";
            return new Result(400);
        } else {
            return new Result(200);
        }
    }

    @Resource
    private getUsersService UsersService;
    @CrossOrigin
    @PostMapping(value = "api/user")//此处不能用getMapping，GET的参数是通过Url方式传递的，而不是请求体传递的所以无法通过@RequestBody注解来接收。
    @ResponseBody
    public Resultful showUsers(@RequestBody ReqBody rb){
        PageHelper.startPage(rb.getCurrentPage(), rb.getPagesize());
        List<UserList> ul = UsersService.getUser();
        PageInfo page = new PageInfo<>(ul);//不指定泛型
        int total = (int) page.getTotal();
//        System.out.println("total的总数是: "+total);
//        for(UserList u:ul){
//            System.out.println(u.getName());
//        }
        Object[] ula = ul.toArray();
        return new Resultful(200,ula,total);
    }

    @CrossOrigin
    @PostMapping(value = "api/remove")
    @ResponseBody
    public Result RemoveUser(@RequestBody Object id){
        String s = String.valueOf(id);//后端接收的是json格式，"{id=1}",转换数据时需要把前后多余的东西去掉
        int removeId = Integer.parseInt(s.substring(4, s.length() - 1));
        UsersService.removeUser(removeId);
        return new Result(200);
    }

    @CrossOrigin
    @PostMapping(value = "api/adduser")
    @ResponseBody
    //jackson的反序列化需要无参构造函数，如果实体类中添加了一个为了方便实例化该类用的构造函数，导致JVM不会添加默认的无参构造函数
    public Result addUser(@RequestBody AddUser au){
        UsersService.addUser(au);
        return new Result(200);
    }

    @CrossOrigin
    @PostMapping(value = "api/edituser")
    @ResponseBody
    public Result editUser(@RequestBody UserList ul){
//        System.out.println(ul.toString());
        UsersService.editUser(ul);
        return new Result(200);
    }
}
