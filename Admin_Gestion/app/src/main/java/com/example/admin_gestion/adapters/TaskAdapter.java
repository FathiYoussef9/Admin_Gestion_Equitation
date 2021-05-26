package com.example.admin_gestion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin_gestion.R;
import com.example.admin_gestion.classes.Tasks;



import java.util.ArrayList;

public class TaskAdapter extends BaseAdapter {
    private Context context; //context
    private ArrayList<Tasks> tasks; //data source of the list adapter

    //public constructor
    public TaskAdapter(Context context, ArrayList<Tasks> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public int getCount() {
        return tasks.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        TextView titre;
        TextView salarie;
        TextView datedebut;
        TextView detail;
        TextView duree;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.task_listitem, parent, false);

            viewHolder = new TaskAdapter.ViewHolder();
            viewHolder.titre = convertView.findViewById(R.id.title);
            viewHolder.salarie = convertView.findViewById(R.id.user);
            viewHolder.datedebut = convertView.findViewById(R.id.startDate);
            viewHolder.detail = convertView.findViewById(R.id.detail);
            viewHolder.duree = convertView.findViewById(R.id.tacheduration);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Tasks currentItem = (Tasks) getItem(position);


        viewHolder.titre.setText(currentItem.getTitle());
        viewHolder.salarie.setText(currentItem.getUserFName() + " " + currentItem.getUserLName());
        viewHolder.datedebut.setText(currentItem.getStartDate());
        viewHolder.detail.setText(currentItem.getDetail());
        viewHolder.duree.setText(String.valueOf(currentItem.getDurationMinut()));

        return convertView;
    }
}