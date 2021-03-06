package com.example.student.logicuniversity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.student.logicuniversity.adapter.DepartmentAdapter;
import com.example.student.logicuniversity.model.Department;

import java.util.List;

public class DisbursementActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    List<Department> departments;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disbursement);

        //set title
        setTitle("Breakdown By Department");

        final ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(this);

        new AsyncTask<Void, Void, List<Department>>()
        {
            @Override
            protected List<Department> doInBackground(Void... params)
            {
                return departments = Department.getDepartments();
            }
            @Override
            protected void onPostExecute(List<Department> result)
            {
                DepartmentAdapter adapter = new DepartmentAdapter(DisbursementActivity.this, R.layout.row4, departments);
                list.setAdapter(adapter);
            }
        }.execute();
    }

    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();
        //Refresh your stuff here
        final ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(this);

        new AsyncTask<Void, Void, List<Department>>()
        {
            @Override
            protected List<Department> doInBackground(Void... params)
            {
                return departments = Department.getDepartments();
            }
            @Override
            protected void onPostExecute(List<Department> result)
            {
                DepartmentAdapter adapter = new DepartmentAdapter(DisbursementActivity.this, R.layout.row4, departments);
                list.setAdapter(adapter);
            }
        }.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id)
    {
        Department department = (Department) av.getAdapter().getItem(position);
        Intent intent = new Intent(this, DisbursementActivity2.class);
        String did = department.get("id");
        intent.putExtra("DeptId", did);
        intent.putExtra("department", department);
        intent.putExtra("deptName", department.get("name"));
        startActivity(intent);
    }
}
