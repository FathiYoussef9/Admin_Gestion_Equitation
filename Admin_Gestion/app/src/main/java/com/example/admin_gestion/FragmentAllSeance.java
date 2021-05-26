package com.example.admin_gestion;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.admin_gestion.adapters.SeanceAdapter;
import com.example.admin_gestion.classes.Seances;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentAllSeance extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Activity act;
    private ListView list ;
    public FragmentAllSeance() {

    }

    // TODO: Rename and change types and number of parameters
    public static FragmentAllSeance newInstance(String param1, String param2) {
        FragmentAllSeance fragment = new FragmentAllSeance();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        act = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.all_seance_fragment, container, false);
        list=view.findViewById(R.id.ListSeance);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        if (view != null) {
            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "https://fathiy.000webhostapp.com/get_seances.php", null,
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
    }
    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
