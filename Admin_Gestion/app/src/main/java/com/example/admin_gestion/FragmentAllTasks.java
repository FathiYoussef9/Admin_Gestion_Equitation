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
import com.example.admin_gestion.adapters.TaskAdapter;
import com.example.admin_gestion.classes.Tasks;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentAllTasks extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Activity act;
    private ListView list ;
    public FragmentAllTasks() {

    }

    // TODO: Rename and change types and number of parameters
    public static FragmentAllTasks newInstance(String param1, String param2) {
        FragmentAllTasks fragment = new FragmentAllTasks();
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
        View view =  inflater.inflate(R.layout.all_tasks_fragment, container, false);
        list=view.findViewById(R.id.ListTask);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        if (view != null) {
            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "https://projet-aymax.000webhostapp.com/get_tasks.php", null,
                    jsonArray -> {
                        ArrayList<Tasks> data = new ArrayList<>();
                        ;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject object1 = jsonArray.getJSONObject(i);
                                Tasks t= new Tasks();
                                t.setTaskID(object1.getInt("taskID"));
                                t.setStartDate(object1.getString("startDate"));
                                t.setDurationMinut(object1.getInt("durationMinut"));
                                t.setTitle(object1.getString("title"));
                                t.setDetail(object1.getString("detail"));
                                t.setIsDone(object1.getString("isDone"));
                                t.setUser_Fk(object1.getInt("user_Fk"));
                                t.setUserLName(object1.getString("userLName"));
                                t.setUserFName(object1.getString("userFName"));
                                data.add(t);
                            } catch (JSONException e) {
                            }
                        }
                        TaskAdapter adapter = new TaskAdapter(getContext(), data);
                        list.setAdapter(adapter);
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            Toast.makeText(getContext(), "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();

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
