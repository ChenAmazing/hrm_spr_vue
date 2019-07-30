package com.amzc.demo.service;

import com.amzc.demo.domain.AddUser;
import com.amzc.demo.domain.UserList;

import java.util.List;

public interface getUsersService {
    List<UserList> getUser();

    void addUser(AddUser ad);

    void removeUser(int id);

    void editUser(UserList ul);
}
