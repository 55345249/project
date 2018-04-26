package com.primeton.domain;

import java.io.Serializable;

public class SystemDO implements Serializable {

    private static final long serialVersionUID = 1L;

    // ava的运行环境版本
    private String javaVersion;

    //Java的运行环境供应商
    private String javaVendor;

    //Java供应商的URL
    private String javaVendorUrl;

    //Java的虚拟机规范名称
    private String javaHome;

    //java的类路径
    private String javaClassPath;

    //加载库时搜索的路径列表
    private String javaLibraryPath;

    //默认的临时文件路径
    private String javaIoTmpdir;

    //一个或多个扩展目录的路径
    private String javaExtDirs;

    //操作系统的名称
    private String osName;

    //操作系统的构架
    private String osArch;

    //操作系统的版本
    private String osVersion;

    //用户的账户名称
    private String userName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getJavaVendor() {
        return javaVendor;
    }

    public void setJavaVendor(String javaVendor) {
        this.javaVendor = javaVendor;
    }

    public String getJavaVendorUrl() {
        return javaVendorUrl;
    }

    public void setJavaVendorUrl(String javaVendorUrl) {
        this.javaVendorUrl = javaVendorUrl;
    }

    public String getJavaHome() {
        return javaHome;
    }

    public void setJavaHome(String javaHome) {
        this.javaHome = javaHome;
    }

    public String getJavaClassPath() {
        return javaClassPath;
    }

    public void setJavaClassPath(String javaClassPath) {
        this.javaClassPath = javaClassPath;
    }

    public String getJavaLibraryPath() {
        return javaLibraryPath;
    }

    public void setJavaLibraryPath(String javaLibraryPath) {
        this.javaLibraryPath = javaLibraryPath;
    }

    public String getJavaIoTmpdir() {
        return javaIoTmpdir;
    }

    public void setJavaIoTmpdir(String javaIoTmpdir) {
        this.javaIoTmpdir = javaIoTmpdir;
    }

    public String getJavaExtDirs() {
        return javaExtDirs;
    }

    public void setJavaExtDirs(String javaExtDirs) {
        this.javaExtDirs = javaExtDirs;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsArch() {
        return osArch;
    }

    public void setOsArch(String osArch) {
        this.osArch = osArch;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHome() {
        return userHome;
    }

    public void setUserHome(String userHome) {
        this.userHome = userHome;
    }

    public String getUserDir() {
        return userDir;
    }

    public void setUserDir(String userDir) {
        this.userDir = userDir;
    }

    //用户的主目录
    private String userHome;

    //用户的当前工作目录
    private String userDir;

}
