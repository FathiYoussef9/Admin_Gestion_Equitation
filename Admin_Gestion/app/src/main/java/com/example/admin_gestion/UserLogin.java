package com.example.admin_gestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;


import org.json.JSONException;

import java.util.concurrent.atomic.AtomicReference;

public class UserLogin extends AppCompatActivity {
    private EditText username;
    private EditText password;
    Intent myIntent;
    private Button BtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        username = findViewById(R.id.LoginInput);
        password= findViewById(R.id.PasswordInput);
        BtnLogin = findViewById(R.id.BtnLogin);
        myIntent= new Intent(UserLogin.this, HomeDashboard.class);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtnLogin.setEnabled(false);
                if (username.getText().length() > 0 && password.getText().length() > 0) {
                    JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "https://fathiy.000webhostapp.com/login.php?email=" + username.getText() + "&pass=" + password.getText(), null,
                            jsonArray -> {
                                if (jsonArray.length() > 0) {
                                    try {
                                        if (jsonArray.getJSONObject(0).get("userType").toString().equals("ADMIN")) {
                                            myIntent.putExtra("id", jsonArray.getJSONObject(0).get("userID").toString());
                                            UserLogin.this.startActivity(myIntent);
                                        }else {
                                            Toast.makeText(getApplicationContext(), "Ce compte est un compte d'un salarie , utitilise l'application associe au salaries", Toast.LENGTH_SHORT).show();
                                            BtnLogin.setEnabled(true);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Utilisateur ou mot de passe incorrect ", Toast.LENGTH_SHORT).show();
                                    BtnLogin.setEnabled(true);
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError volleyError) {
                                    Toast.makeText(getApplicationContext(), "Unable to fetch data: ", Toast.LENGTH_SHORT).show();
                                }
                            });
                    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);

                } else {
                    Toast.makeText(getApplicationContext(), "Merci de remplir les champs", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}