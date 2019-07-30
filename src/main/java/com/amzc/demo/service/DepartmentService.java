package com.amzc.demo.service;

import com.amzc.demo.domain.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getDepartment();
    public void removeDepartment(int id);
    public void updateDepartment(Department department);
    public void addDepartment(Department department);
}
