package com.example.admin_gestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.admin_gestion.adapters.ClientAdapter;
import com.example.admin_gestion.adapters.UserAdapter;
import com.example.admin_gestion.classes.Client;
import com.example.admin_gestion.classes.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class emploi_du_temps extends AppCompatActivity {
    private ListView list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emploi_du_temps);
        list=findViewById(R.id.ListClient);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "https://fathiy.000webhostapp.com/get_clients.php", null,
                jsonArray -> {
                    ArrayList<Client> data = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject object1 = jsonArray.getJSONObject(i);
                            Client c= new Client(object1);
                            data.add(c);
                        } catch (JSONException e) {
                            Toast.makeText(this, "Unable to fetch data: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    ClientAdapter adapter = new ClientAdapter(this, data);
                    list.setAdapter(adapter);
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
//                            Toast.makeText(getContext(), "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

        MySingleton.getInstance(this).addToRequestQueue(request);


    }
    }
