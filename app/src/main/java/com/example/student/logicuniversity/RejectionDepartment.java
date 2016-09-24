package com.example.student.logicuniversity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student.logicuniversity.adapter.EmployeeAdapter;
import com.example.student.logicuniversity.model.Employee;

import java.util.List;

public class RejectionDepartment extends ListActivity
{

    String[] option = {
            "Damaged Items",
            "Wrong Items",
            "Short Items"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejection_department);

        // -- Display mode of the ListView
        ListView listview = getListView();
        listview.setChoiceMode(listview.CHOICE_MODE_MULTIPLE);

        //--	text filtering
        listview.setTextFilterEnabled(true);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, option));



        // Cancel button definition and listener assignment
        Button clickButton = (Button) findViewById(R.id.buttonSubmit);
        clickButton.setOnClickListener( new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                new AsyncTask<String, Void, String>()
                {
                    @Override
                    protected String doInBackground(String... params)
                    {
                        Employee.getEmployee(params[0]);
                        return "";
                    }
                }.execute("deptId");
                finish();
            }
        });


    }
}