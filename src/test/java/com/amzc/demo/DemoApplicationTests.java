package com.amzc.demo;

import com.amzc.demo.domain.UserList;
import com.amzc.demo.service.getUsersService;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Resource
    private getUsersService UsersService;

    @Test
    public void contextLoads() {
        //pagNum参数确定查询第几页的数据，默认从1开始
        //只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select方法）方法会被分页
        PageHelper.startPage(2, 5);
        List<UserList> ul = UsersService.getUser();
        for(UserList u:ul){
            System.out.println(u.getName());
        }
    }

}
