package com.example.admin_gestion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeDashboard extends AppCompatActivity implements View.OnClickListener{
    private CardView EmploiTemps,Taches,Seances,Pointage,users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dashboard);
        //defining Cards
        EmploiTemps = (CardView) findViewById(R.id.EmploiTempsId);
        Taches = (CardView) findViewById(R.id.TacheId);
        Seances = (CardView) findViewById(R.id.SeancesId);
        Pointage = (CardView) findViewById(R.id.PointageId);
        users = (CardView) findViewById(R.id.GestionUserId);
        //Add Click Listener to the cards
        EmploiTemps.setOnClickListener(this);
        Taches.setOnClickListener(this);
        Seances.setOnClickListener(this);
        Pointage.setOnClickListener(this);
        users.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.EmploiTempsId : i = new Intent(this,emploi_du_temps.class);startActivity(i); break;
            case R.id.TacheId : i = new Intent(this,Taches.class);startActivity(i);break;
            case R.id.SeancesId : i = new Intent(this,Seances.class);startActivity(i);break;
            case R.id.PointageId : i = new Intent(this,Pointage.class);startActivity(i);break;
            case R.id.GestionUserId : i = new Intent(this,users.class);startActivity(i);break;
            default:break;
        }
    }
}