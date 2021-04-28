package com.example.admin_gestion.classes;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class User {


    private int userId;
    private String UserEamil;
    private String Passwd;
    private int AdminLevel;
    private String LastLoginTime;
    private boolean isActive;
    private String UserFName;
    private String UserLName;
    private String description;
    private String UserType;
    private String userphoto;
    private String contractDate;
    private String UserPhone;
    private String displayColor;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEamil() {
        return UserEamil;
    }

    public void setUserEamil(String userEamil) {
        UserEamil = userEamil;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setPasswd(String passwd) {
        Passwd = passwd;
    }

    public int getAdminLevel() {
        return AdminLevel;
    }

    public void setAdminLevel(int adminLevel) {
        AdminLevel = adminLevel;
    }

    public String getLastLoginTime() {
        return LastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        LastLoginTime = lastLoginTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUserFName() {
        return UserFName;
    }

    public void setUserFName(String userFName) {
        UserFName = userFName;
    }

    public String getUserLName() {
        return UserLName;
    }

    public void setUserLName(String userLName) {
        UserLName = userLName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public String getDisplayColor() {
        return displayColor;
    }

    public void setDisplayColor(String displayColor) {
        this.displayColor = displayColor;
    }

    public User() {

    }
    public User(JSONObject json) throws JSONException {
          userId=json.getInt("userID");
        UserEamil=json.getString("userEmail");
        Passwd=json.getString("userPasswd");
        AdminLevel=json.getInt("adminLevel");
        LastLoginTime=json.getString("lastLoginTime");
        isActive=json.getBoolean("isActive");
        UserFName=json.getString("userFName");
        UserFName=json.getString("userLName");
        description=json.getString("description");
        UserType=json.getString("userType");
        userphoto=json.getString("userphoto");
        contractDate=json.getString("contractDate");
        UserPhone=json.getString("userPhone");
        displayColor=json.getString("displayColor");


    }
}
