package com.example.admin_gestion.classes;

import org.json.JSONException;
import org.json.JSONObject;

public class Seances {

    private int seanceID;
    private int seanceGrpID;
    private int clientID;
    private int monitorID;
    private String startDate;
    private int durationMinut;
    private boolean isDone;
    private int paymentID;
    private String comments;
    private String userFName;
    private String userLName;
    private String ClientfName;
    private String ClientlName;

    public int getSeanceID() {
        return seanceID;
    }

    public void setSeanceID(int seanceID) {
        this.seanceID = seanceID;
    }

    public int getSeanceGrpID() {
        return seanceGrpID;
    }

    public void setSeanceGrpID(int seanceGrpID) {
        this.seanceGrpID = seanceGrpID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getMonitorID() {
        return monitorID;
    }

    public void setMonitorID(int monitorID) {
        this.monitorID = monitorID;
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

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getClientfName() {
        return ClientfName;
    }

    public void setClientfName(String ClientfName) {
        this.ClientfName = ClientfName;
    }

    public String getClientlName() {
        return ClientlName;
    }

    public void setClientlName(String ClientlName) {
        this.ClientlName = ClientlName;
    }

    public Seances() {
    }

    public Seances(JSONObject json) throws JSONException {
         seanceID=json.getInt("seanceID");
         seanceGrpID=json.getInt("seanceGrpID");
         clientID=json.getInt("clientID");
         monitorID=json.getInt("monitorID");
         startDate=json.getString("startDate");
         durationMinut=json.getInt("durationMinut");
         isDone = json.getString("isDone").equals("1");
         paymentID=json.getInt("paymentID");
         comments=json.getString("comments");
         userFName=json.getString("userFName");
         userLName=json.getString("userLName");
         ClientfName=json.getString("fName");
         ClientlName=json.getString("lName");
    }
}
