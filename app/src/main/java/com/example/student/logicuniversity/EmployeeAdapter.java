package com.example.student.logicuniversity;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by student on 8/9/16.
 */
public class EmployeeAdapter extends ArrayAdapter<Employee>
{

    private List<Employee> employees;

    public EmployeeAdapter(Context context, int resource, List<Employee> employees) {
        super(context, resource, employees);
        this.employees = employees;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_employee_department, null);
        Employee item = employees.get(position);

        if(item != null) {
            TextView name = (TextView) view.findViewById(R.id.text1);
            name.setText(item.get("name"));

            TextView id = (TextView) view.findViewById(R.id.text2);
            id.setText(item.get("id"));

        }
        return view;
    }
}

