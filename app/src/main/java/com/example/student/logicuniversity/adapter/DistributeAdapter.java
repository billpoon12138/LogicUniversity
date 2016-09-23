package com.example.student.logicuniversity.adapter;


import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.student.logicuniversity.R;
import com.example.student.logicuniversity.model.Item;

import java.util.List;

/**
 * Created by Johnson Dell laptop on 14-Sep-16.
 */
public class DistributeAdapter extends ArrayAdapter<Item>
{
    private List<Item> items;

    public DistributeAdapter(Context context, int resource, List<Item> items)
    {
        super(context, resource, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.row_distribute_department, null);

        final Item item = items.get(position);

        if(item != null)
        {
            TextView name = (TextView) view.findViewById(R.id.text1);
            name.setText(item.get("name"));

            TextView requested = (TextView) view.findViewById(R.id.text3);
            requested.setText(item.get("requested"));

            TextView actual = (TextView) view.findViewById(R.id.text5);
            actual.setText(item.get("actual"));

            final CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox1);
            if(item.get("retrieveStatus").equals("retrieved")){
                checkBox.setChecked(true);
            }
            checkBox.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(checkBox.isChecked()){
                        new AsyncTask<String, Void, String>()
                        {
                            @Override
                            protected String doInBackground(String... params)
                            {
                                System.out.println(item.get("employeeReqDetailId"));
                                item.changeEmployeeRequisitionDetailRetrieveStatusToRetrieve(item.get("employeeReqDetailId"));
//                                item.changeDepartmentRequisitionDetailRetrieveStatusToRetrieve(item.get("deptReqDetailId"));
                                return "";
                            };
                        }.execute(item.get("deptReqDetailId"));
//                        item.changeDepartmentRequisitionDetailRetrieveStatus(item.get("deptReqDetailId"));
                    }else{
                        new AsyncTask<String, Void, String>()
                        {
                            @Override
                            protected String doInBackground(String... params)
                            {
                                item.changeEmployeeRequisitionDetailRetrieveStatusToUnCheck(item.get("employeeReqDetailId"));
//                                System.out.println("ListView Select item - Clicked");
//                                Department.getDepartments();
//                                item.changeDepartmentRequisitionDetailRetrieveStatusToOpen(item.get("deptReqDetailId"));
                                return "";
                            };
                        }.execute(item.get("deptReqDetailId"));
                    }
                }
            });
        }
        return view;
    }

}
