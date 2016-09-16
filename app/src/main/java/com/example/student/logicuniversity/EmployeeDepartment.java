package com.example.student.logicuniversity;


import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class EmployeeDepartment extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    List<Item> items;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_department);

        //set title
        setTitle("EMPLOYEE");

        // Set up Java / XML ListView listener (using Listener interface method)
        final ListView list = (ListView) findViewById(R.id.listView3);
        list.setOnItemClickListener(this);


        new AsyncTask<Void, Void, List<Item>>()
        {
            @Override
            protected List<Item> doInBackground(Void... params)
            {
                return items = Item.getRequisition();
            }
            @Override
            protected void onPostExecute(List<Item> result)
            {
                EmployeeAdapter adapter = new EmployeeAdapter(EmployeeDepartment.this, R.layout.row_employee_department, items);
                list.setAdapter(adapter);
            }
        }.execute();

    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id)
    {
        //String item = (String) av.getAdapter().getItem(position);

        System.out.println("ListView Select item - Clicked");

        Intent intent = new Intent(getApplicationContext(), DistributeDepartment.class);
        startActivity(intent);

        //Toast.makeText(getApplicationContext(), item + " selected", Toast.LENGTH_LONG).show();
    }



}
