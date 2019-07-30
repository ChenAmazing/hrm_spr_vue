package com.amzc.demo.utils;

import com.amzc.demo.domain.FileBean;

import java.util.List;

public class ItemResult {

    private Object[] data;
    private int Code;

    public ItemResult(Object[] data, int code) {
        this.data = data;
        this.Code = code;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }
}
