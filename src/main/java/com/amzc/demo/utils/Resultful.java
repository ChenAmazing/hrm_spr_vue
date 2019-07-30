package com.amzc.demo.utils;

import java.util.List;

public class Resultful {
    //响应码
    public int code;//改为private前端获取不到数据？

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public Object[] data;

    public int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Resultful(int code, Object[] data, int total) {
        this.code = code;
        this.data = data;
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
