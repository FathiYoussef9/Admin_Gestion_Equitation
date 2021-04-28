package com.example.admin_gestion.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin_gestion.R;
import com.example.admin_gestion.classes.User;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> implements View.OnClickListener{

    private ArrayList<User> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView name;
        TextView email;
    }

    public UserAdapter(ArrayList<User> data, Context context) {
        super(context, R.layout.user_object, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

//        int position=(Integer) v.getTag();
//        Object object= getItem(position);
//        User dataModel=(User)object;
//        switch (v.getId())
//        {
//            case R.id.item_info:
//                Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
//                break;
//        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.user_object, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.email = (TextView) convertView.findViewById(R.id.email);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.name.setText(dataModel.getUserFName()+" "+dataModel.getUserFName());
        viewHolder.email.setText(dataModel.getUserEamil());

        // Return the completed view to render on screen
        return convertView;
    }
}
