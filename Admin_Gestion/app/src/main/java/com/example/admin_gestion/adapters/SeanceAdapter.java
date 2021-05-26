package com.example.admin_gestion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin_gestion.R;
import com.example.admin_gestion.classes.Seances;


import java.util.ArrayList;

public class SeanceAdapter extends BaseAdapter {
    private Context context; //context
    private ArrayList<Seances>  seances;//data source of the list adapter

    //public constructor
    public SeanceAdapter(Context context, ArrayList<Seances> seances) {
        this.context = context;
        this.seances = seances;
    }

    @Override
    public int getCount() {
        return seances.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return seances.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        TextView monitor;
        TextView client;
        TextView datedebut;
        TextView duree;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.seance_listitem, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.monitor = convertView.findViewById(R.id.monitor);
            viewHolder.client = convertView.findViewById(R.id.client);
            viewHolder.datedebut = convertView.findViewById(R.id.startDate);
            viewHolder.duree = convertView.findViewById(R.id.dseance);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        Seances currentItem = (Seances) getItem(position);
        viewHolder.monitor.setText(currentItem.getUserFName() + " " + currentItem.getUserLName());
        viewHolder.client.setText(currentItem.getClientfName() + " " + currentItem.getClientlName());
        viewHolder.datedebut.setText(currentItem.getStartDate());
        viewHolder.duree.setText(String.valueOf(currentItem.getDurationMinut()));
        return convertView;
    }
}