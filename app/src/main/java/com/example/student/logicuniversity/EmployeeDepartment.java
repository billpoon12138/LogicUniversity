package com.example.student.logicuniversity;


import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.student.logicuniversity.adapter.EmployeeAdapter;
import com.example.student.logicuniversity.model.Employee;

import java.util.List;

public class EmployeeDepartment extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    List<Employee> employees;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_department);

        //set title
        setTitle("DISTRIBUTE");

        // Set up Java / XML ListView listener (using Listener interface method)
        final ListView list = (ListView) findViewById(R.id.listView3);
        list.setOnItemClickListener(this);

        // Get the departmentId
//        SharedPreferences pref =  PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//        String deptId = pref.getString("DeptId", "1");
        String deptId = (String)getIntent().getSerializableExtra("DeptId");


        new AsyncTask<String, Void, List<Employee>>()
        {
            @Override
            protected List<Employee> doInBackground(String... params)
            {
                return employees = Employee.getEmployee(params[0]);
            }
            @Override
            protected void onPostExecute(List<Employee> result)
            {
                EmployeeAdapter adapter = new EmployeeAdapter(EmployeeDepartment.this, R.layout.row_employee_department, employees);
                list.setAdapter(adapter);
            }
        }.execute(deptId);

    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id)
    {
        //String item = (String) av.getAdapter().getItem(position);
        Employee employee = (Employee) av.getAdapter().getItem(position);

        System.out.println("ListView Select item - Clicked");
        String eid = employee.get("id");
        Intent intent = new Intent(getApplicationContext(), DistributeDepartment.class);
        intent.putExtra("EmployeeId", eid);
        startActivity(intent);

        //Toast.makeText(getApplicationContext(), item + " selected", Toast.LENGTH_LONG).show();
    }



}
