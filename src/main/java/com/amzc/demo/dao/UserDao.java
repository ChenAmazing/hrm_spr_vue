package com.amzc.demo.dao;

import com.amzc.demo.domain.AddUser;
import com.amzc.demo.domain.UserList;

import java.util.List;

public interface UserDao {
    public List<UserList> getUser();
    public void addUser(AddUser ad);
    public void removeUser(int id);
    public void editUser(UserList ul);
}
