package com.amzc.demo.utils;

public class ChangeSize {
    public String Change(long size){
        double s = (double)size;
        int flag = 1;
        while(s>=1024){
            flag++;
            s = s/1024;
        }
        String n = String.valueOf(s);
        String m = n.substring(0, n.indexOf(".") + 2);//保留小数点一位
        String fsize = null;
        if(flag==1){
            fsize = m+"b";
        }else if(flag==2){
            fsize = m+"Kb";
        }else if(flag==3){
            fsize = m+"Mb";
        }else if(flag==4){
            fsize = m+"Gb";
        }
        return fsize;
    }
}
