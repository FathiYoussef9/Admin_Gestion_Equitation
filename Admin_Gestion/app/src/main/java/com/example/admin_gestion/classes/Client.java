package com.example.admin_gestion.classes;

import android.graphics.Bitmap;

import org.json.JSONException;
import org.json.JSONObject;

public class Client {

    public int clientId;
    public String fName;
    public String lName;
    public String birthDate;
    public Bitmap photo;
    public String identityDoc;
    public String identityNumber;
    public String inscriptionDate;
    public String ensurenceValidity;
    public String licenceValidity;
    public String clientEmail;
    public String passwd;
    public String clientPhone;
    public int priceRate;
    public boolean isActive;
    public String notes;

    public Client() {

    }



    public Client(JSONObject json) throws JSONException {
        clientId = json.getInt("clientID");
        fName = json.getString("fName");
        lName = json.getString("lName");
        birthDate = json.getString("birthDate");
        photo = null;
        identityDoc = json.getString("identityDoc");
        identityNumber = json.getString("identityNumber");
        inscriptionDate = json.getString("inscriptionDate");
        ensurenceValidity = json.getString("ensurenceValidity");
        licenceValidity = json.getString("licenceValidity");
        clientEmail = json.getString("clientEmail");
        passwd =json.getString( "passwd");
        clientPhone = json.getString("clientPhone");
        priceRate = json.getInt("priceRate");
        notes = json.getString("notes");
    }

}
