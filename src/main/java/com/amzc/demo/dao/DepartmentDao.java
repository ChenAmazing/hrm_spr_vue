package com.amzc.demo.dao;

import com.amzc.demo.domain.Department;

import java.util.List;

public interface DepartmentDao {
    public List<Department> getDepartment();
    public void removeDepartment(int id);
    public void updateDepartment(Department department);
    public void addDepartment(Department department);
}
