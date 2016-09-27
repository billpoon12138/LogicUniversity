package com.example.student.logicuniversity.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.student.logicuniversity.R;
import com.example.student.logicuniversity.model.Department;

import java.util.List;

/**
 * Created by student on 13/9/16.
 */
public class DepartmentAdapter extends ArrayAdapter<Department> {

    private List<Department> departments;

    public DepartmentAdapter(Context context, int resource, List<Department> departments) {
        super(context, resource, departments);
        this.departments = departments;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row4, null);
        Department department = departments.get(position);

        if(department != null)
        {
            TextView name = (TextView) view.findViewById(R.id.text1);
            name.setText(department.get("name"));
            TextView status = (TextView) view.findViewById(R.id.text3);
            if(department.get("status").equals("open")){
                status.setText("UnCheck");
            }else{
                status.setText("Checked");
            }

        }
        return view;
    }
}
