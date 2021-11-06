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

    @SerializedName("Email")
    @Expose
    private String Email;

    @SerializedName("UserTypeId")
    @Expose
    private int UserTypeId;

    @SerializedName("UserCode")
    @Expose
    private String UserCode;

    @SerializedName("UserType")
    @Expose
    private String UserType;

    @SerializedName("UserImage")
    @Expose
    private String UserImage;

    @SerializedName("BlockName")
    @Expose
    private String BlockName;

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public String getUserImage() {
        return UserImage;
    }

    public void setUserImage(String userImage) {
        UserImage = userImage;
    }
    public String getBlockName() {
        return BlockName;
    }

    public void setBlockName(String blockName) {
        BlockName = blockName;
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
}
