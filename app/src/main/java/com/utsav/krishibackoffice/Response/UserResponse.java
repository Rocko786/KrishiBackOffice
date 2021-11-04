package com.utsav.krishibackoffice.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("UserId")
    @Expose
    private int UserId;
    @SerializedName("UserName")
    @Expose
    private String UserName;

    @SerializedName("ContactNo")
    @Expose
    private String ContactNo;

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
}
