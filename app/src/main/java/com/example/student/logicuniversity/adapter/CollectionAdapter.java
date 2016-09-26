package com.example.student.logicuniversity.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.student.logicuniversity.R;
import com.example.student.logicuniversity.RejectionDepartment;
import com.example.student.logicuniversity.model.Item;

import java.util.List;

/**
 * Created by Johnson Dell laptop on 14-Sep-16.
 */
public class CollectionAdapter extends ArrayAdapter<Item>
{
    private List<Item> items;

    public CollectionAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_collection_department, null);
        final Item item = items.get(position);

        if(item != null) {
            TextView name = (TextView) view.findViewById(R.id.text1);
            name.setText(item.get("name"));
            TextView requested = (TextView) view.findViewById(R.id.text3);
            requested.setText(item.get("requested"));
            TextView actual = (TextView) view.findViewById(R.id.text5);
            actual.setText(item.get("actual"));

/*            final CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox2);
            checkBox.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(checkBox.isChecked()){
                        System.out.println("ListView CheckBox item - Clicked");
                        System.out.println(item);
//                        Intent intent = new Intent(getApplicationContext(), RejectionDepartment.class);
//                        startActivity(intent);
                    }
                }
            });*/
        }
        return view;
    }

}
