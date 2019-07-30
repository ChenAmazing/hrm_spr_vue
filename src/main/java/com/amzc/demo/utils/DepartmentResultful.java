package com.amzc.demo.utils;

import com.amzc.demo.domain.Department;

public class DepartmentResultful {
    public  int code;
    public Object[] data;
    public int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object[] getData() {
        return data;
    }

    public DepartmentResultful(int code, Object[] data,int total) {
        this.code = code;
        this.data = data;
        this.total = total;
    }

    public void setData(Object[] data) {
        this.data = data;
    }
}
