package com.amzc.demo.service;

import com.amzc.demo.dao.UserDao;
import com.amzc.demo.domain.AddUser;
import com.amzc.demo.domain.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class getUsersServiceImpl implements getUsersService {
    @Autowired
    UserDao userdao;
    @Override
    public List<UserList> getUser() {
        return userdao.getUser();
    }

    @Override
    public void addUser(AddUser au) {
       userdao.addUser(au);
        System.out.println("添加数据成功");
    }

    @Override
    public void removeUser(int id) {
        userdao.removeUser(id);
        System.out.println("删除数据成功");
    }

    public void editUser(UserList ul){
        userdao.editUser(ul);
        System.out.println("修改数据成功");
    }
}
