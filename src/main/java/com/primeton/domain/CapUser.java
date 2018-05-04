package com.primeton.domain;

public class CapUser {

    String operatorId;

    String tenantId;

    String userId;

    String userName;

    String passWord;

    String unlockTime;

    String lastLogin;

    String createTime;

    public CapUser(){

    }

    public CapUser(String operatorId, String tenantId, String userId, String userName, String passWord, String unlockTime, String lastLogin, String createTime) {
        this.operatorId = operatorId;
        this.tenantId = tenantId;
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.unlockTime = unlockTime;
        this.lastLogin = lastLogin;
        this.createTime = createTime;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public String getTendId() {
        return tenantId;
    }

    public void setTendId(String tendId) {
        this.tenantId = tendId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getUnlockTime() {
        return unlockTime;
    }

    public void setUnlockTime(String unlockTime) {
        this.unlockTime = unlockTime;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CapUser{" +
                "operatorId='" + operatorId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", unlockTime='" + unlockTime + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
