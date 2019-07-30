package com.amzc.demo.service;

import com.amzc.demo.dao.DepartmentDao;
import com.amzc.demo.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentDao departmentDao;
    @Override
    public List<Department> getDepartment() {
        List<Department> departentList = departmentDao.getDepartment();
        return departentList;
    }

    @Override
    public void removeDepartment(int id) {
        departmentDao.removeDepartment(id);
        System.out.println("删除数据成功");
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
        System.out.println("修改数据成功");
    }

    @Override
    public void addDepartment(Department department) {
        departmentDao.addDepartment(department);
        System.out.println("添加数据成功");
    }
}
