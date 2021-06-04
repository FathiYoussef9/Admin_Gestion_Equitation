package com.example.admin_gestion;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.admin_gestion.adapters.SeanceAdapter;
import com.example.admin_gestion.classes.Seances;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentSearchSeance  extends Fragment {
    View v;


    public FragmentSearchSeance() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.search_seance_fragment,container,false);
        Button find = v.findViewById(R.id.findseance);
        ListView list =v.findViewById(R.id.ListSeance2);
        CalendarView calendar = v.findViewById(R.id.cv);
        TextView dt = v.findViewById(R.id.dt2);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date =year+"-"+(month+1)+"-"+dayOfMonth;
                dt.setText(date);
            }
        });
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://projet-aymax.000webhostapp.com/get_seances.php?jour="+dt.getText();
                Log.e("l", url);
                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url  , null,
                        jsonArray -> {
                            ArrayList<Seances> data = new ArrayList<>();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                try {
                                    JSONObject object1 = jsonArray.getJSONObject(i);
                                    com.example.admin_gestion.classes.Seances s= new com.example.admin_gestion.classes.Seances(object1);
                                    data.add(s);
                                } catch (JSONException e) {
                                    Toast.makeText(getContext(), "Unable to fetch data: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                            SeanceAdapter adapter = new SeanceAdapter(getContext(), data);
                            list.setAdapter(adapter);
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
//                            Toast.makeText(getContext(), "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });

                MySingleton.getInstance(getContext()).addToRequestQueue(request);
            }
        });
        return v;
    }




}
