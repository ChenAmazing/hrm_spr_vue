package com.amzc.demo.domain;

public class FileBean {
    private String filepath;//文件路径
    private String filename;//文件名字

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    private String filesize;

    public String getFilepath() {
        return filepath;
    }
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public FileBean(String filepath, String filename,String filesize) {
        super();
        this.filepath = filepath;
        this.filename = filename;
        this.filesize = filesize;
    }
    public FileBean() {
        super();
    }
    @Override
    public String toString() {
        return "FileBean [filepath=" + filepath + ", filename=" + filename + "]";
    }


}
