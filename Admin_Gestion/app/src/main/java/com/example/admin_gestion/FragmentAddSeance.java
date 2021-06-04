package com.example.admin_gestion;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentAddSeance extends Fragment {


    View v;

    public FragmentAddSeance() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.add_seance_fragment,container,false);
        EditText clientid = v.findViewById(R.id.SeanceClinetID);
        EditText monitorid = v.findViewById(R.id.SeanceMonitorID);
        EditText duree = v.findViewById(R.id.SeanceDuree);
        EditText repitition = v.findViewById(R.id.Repitition);
        TextView dt = v.findViewById(R.id.dt);
        CalendarView calendar = v.findViewById(R.id.calendarView);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date =year+"-"+(month-1)+"-"+dayOfMonth;
                dt.setText(date);
            }
        });
        Button btn= v.findViewById(R.id.AddSeanceBtn);
                        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://projet-aymax.000webhostapp.com/add_seance.php?" +
                        "clientID="+clientid.getText().toString()+
                        "&monitorID="+monitorid.getText().toString()+
                        "&startDate="+dt.getText().toString()+
                        "&seanceGrpID=6&durationMinut="+duree.getText().toString()+
                        "&comments=testcomments&repitition="+repitition.getText().toString();
                Log.e("Link",url);
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(v.getContext(), "Operation fait avec success", Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(v.getContext(), "Error  : " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                MySingleton.getInstance(getContext()).addToRequestQueue(stringRequest);
                getActivity().onBackPressed();
            }
        });
        return v;
    }
}
