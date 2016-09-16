package com.example.student.logicuniversity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by student on 8/9/16.
 */
public class ItemAdapter extends ArrayAdapter<Item>
{

    private List<Item> items;

    public ItemAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row3, null);
        Item item = items.get(position);

        if(item != null) {
            TextView name = (TextView) view.findViewById(R.id.text1);
//            name.setText(item.get("name"));
            name.setText(item.get("row1"));
            TextView id = (TextView) view.findViewById(R.id.text2);
//            id.setText(item.get("id"));
            id.setText(item.get("row2"));
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox1);
        }
        return view;
    }
}