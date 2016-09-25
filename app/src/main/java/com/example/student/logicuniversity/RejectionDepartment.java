package com.example.student.logicuniversity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student.logicuniversity.adapter.EmployeeAdapter;
import com.example.student.logicuniversity.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class RejectionDepartment extends ListActivity
{

    String[] option = {
            "Damaged Items",
            "Wrong Items",
            "Short Items"
    };

    EditText rejectQty;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejection_department);

        // -- Display mode of the ListView
        ListView listview = getListView();

        // Enable the following line to allow (SINGLE) or (MULTIPLE) row selection
        listview.setChoiceMode(listview.CHOICE_MODE_SINGLE);

        //--	text filtering
        listview.setTextFilterEnabled(true);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, option));





        /*// Test To find out which row was selected
        SparseBooleanArray checked = listview.getCheckedItemPositions();
        int size = checked.size(); // number of name-value pairs in the array
        for (int i = 0; i < size; i++)
        {
            int key = checked.keyAt(i);
            boolean value = checked.get(key);

            if (value = false)
            {
                System.out.println("Select item - Clicked");
                Log.d("Row", "value: " + key);

            }
        }*/



        // Submit button definition and listener assignment
        Button clickButton = (Button) findViewById(R.id.buttonSubmit);
        clickButton.setOnClickListener( new View.OnClickListener()
        {


            @Override
            public void onClick(View v)
            {
                // Variable to register the reject quantity
                rejectQty = (EditText)findViewById(R.id.editText5);
                Log.v("RejectQty", rejectQty.getText().toString());

                // Asyn task to call method to post rejection form data to database
                /*new AsyncTask<String, Void, String>()
                {
                    @Override
                    protected String doInBackground(String... params)
                    {
                        Employee.getEmployee(params[0]);
                        return "";
                    }
                }.execute("deptId");
                finish();*/
            }
        });


    }


}