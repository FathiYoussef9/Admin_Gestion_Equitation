package com.example.admin_gestion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.admin_gestion.R;
import com.example.admin_gestion.classes.User;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context; //context
    private ArrayList<User> users; //data source of the list adapter
    //public constructor
    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return users.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        TextView name;
        TextView email;
        TextView type;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.user_listitem, parent, false);

            viewHolder=new ViewHolder();
            viewHolder.name=convertView.findViewById(R.id.uname);
            viewHolder.email=convertView.findViewById(R.id.uemail);
            viewHolder.type=convertView.findViewById(R.id.utype);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        User currentItem = (User) getItem(position);


        viewHolder.name.setText(currentItem.getUserFName()+" "+currentItem.getUserLName());
        viewHolder.email.setText(currentItem.getUserEamil());
        viewHolder.type.setText(currentItem.getUserType());

        return convertView;
    }
}