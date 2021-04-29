package com.example.admin_gestion.classes;

import org.json.JSONException;
import org.json.JSONObject;

public class Tasks {


     private int taskID;
     private String startDate;
     private int durationMinut;
     private String title;
     private String detail;
     private String isDone;
     private int user_Fk;
     private String userFName;
     private String userLName;


    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getDurationMinut() {
        return durationMinut;
    }

    public void setDurationMinut(int durationMinut) {
        this.durationMinut = durationMinut;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getIsDone() {
        return isDone;
    }

    public void setIsDone(String isDone) {
        this.isDone = isDone;
    }

    public int getUser_Fk() {
        return user_Fk;
    }

    public void setUser_Fk(int user_Fk) {
        this.user_Fk = user_Fk;
    }

    public String getUserFName() {
        return userFName;
    }

    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }

    public String getUserLName() {
        return userLName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public Tasks() {
    }

    public Tasks(JSONObject json) throws JSONException {
        taskID =json.getInt("taskID") ;
        startDate = json.getString("startDate");
        durationMinut = json.getInt("durationMinut");
        title = json.getString("title");
        detail = json.getString("detail");
        isDone = json.getString("isDone");
        user_Fk = json.getInt("user_Fk");
        userFName = json.getString("userFName");
        userLName = json.getString("userLName");
    }
}
