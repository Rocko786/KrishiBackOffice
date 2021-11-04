package com.utsav.krishibackoffice.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {
    private int UserId;
    private String UserName;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    private String ContactNo;

    public UserModel(int userId, String userName, String contactNo) {
        UserId = userId;
        UserName = userName;
        ContactNo = contactNo;
    }


}
