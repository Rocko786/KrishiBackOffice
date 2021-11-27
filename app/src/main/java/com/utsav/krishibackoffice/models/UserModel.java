package com.utsav.krishibackoffice.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {
    private int UserId;
    private String UserName;
    private String ContactNo;
    private String Email;
    private int UserTypeId;
    private String UserCode;
    private String BlockName;

    public String getJelaName() {
        return JelaName;
    }

    public void setJelaName(String jelaName) {
        JelaName = jelaName;
    }

    public String getUpoJelaName() {
        return UpoJelaName;
    }

    public void setUpoJelaName(String upoJelaName) {
        UpoJelaName = upoJelaName;
    }

    private String JelaName;
    private String UpoJelaName;

    public String getUserImage() {
        return UserImage;
    }

    public void setUserImage(String userImage) {
        UserImage = userImage;
    }

    private String UserImage;

    public UserModel(int userId, String userName, String contactNo, String email, int userTypeId, String userCode, String userImage, String userType,String blockName,String jelaName,String upoJelaName) {
        UserId = userId;
        UserName = userName;
        ContactNo = contactNo;
        Email = email;
        UserTypeId = userTypeId;
        UserCode = userCode;
        UserImage = userImage;
        UserType = userType;
        BlockName=blockName;
        JelaName=jelaName;
        UpoJelaName=upoJelaName;
    }

    private String UserType;




    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }









    public UserModel(int userId, String userName, String contactNo) {
        UserId = userId;
        UserName = userName;
        ContactNo = contactNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getUserTypeId() {
        return UserTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        UserTypeId = userTypeId;
    }

    public String getUserCode() {
        return UserCode;
    }

    public void setUserCode(String userCode) {
        UserCode = userCode;
    }

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

    public String getBlockName() {
        return BlockName;
    }

    public void setBlockName(String blockName) {
        BlockName = blockName;
    }


}
