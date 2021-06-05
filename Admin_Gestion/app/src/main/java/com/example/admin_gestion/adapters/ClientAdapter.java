package com.example.admin_gestion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.admin_gestion.R;
import com.example.admin_gestion.classes.Client;

import java.util.ArrayList;

public class ClientAdapter extends BaseAdapter {
    private Context context; //context
    private ArrayList<Client> clients; //data source of the list adapter
    //public constructor
    public ClientAdapter(Context context, ArrayList<Client> clients) {
        this.context = context;
        this.clients = clients;
    }

    @Override
    public int getCount() {
        return clients.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return clients.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        TextView name;
        TextView email;
        TextView phone;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.client_listitem, parent, false);

            viewHolder=new ViewHolder();
            viewHolder.name=convertView.findViewById(R.id.name);
            viewHolder.email=convertView.findViewById(R.id.email);
            viewHolder.phone=convertView.findViewById(R.id.phone);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Client currentItem = (Client) getItem(position);
        viewHolder.name.setText(currentItem.fName+" "+currentItem.lName);
        viewHolder.email.setText(currentItem.clientEmail);
        viewHolder.phone.setText(currentItem.clientPhone);
        return convertView;
    }
}