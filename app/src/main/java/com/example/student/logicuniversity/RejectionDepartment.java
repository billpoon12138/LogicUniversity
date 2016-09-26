package com.example.student.logicuniversity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.example.student.logicuniversity.model.Item;

import java.util.ArrayList;
import java.util.List;

public class RejectionDepartment extends AppCompatActivity
{

    String[] option = {
            "Damaged Items",
            "Wrong Items",
            "Short Items"
    };

    EditText rejectQty;
    EditText rejectReason;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejection_department);

        // Get dept requisition detail ID and item name from previous activity
        final String deptReqDetailId = (String)getIntent().getSerializableExtra("deptReqDetailId");
        final String name = (String)getIntent().getSerializableExtra("name");

        // Set the item name to  item name edittext view
        TextView na = (TextView)findViewById(R.id.textView3);
        na.setText(name);


      /*  // -- Display mode of the ListView
        ListView listview = getListView();

        // Enable the following line to allow (SINGLE) or (MULTIPLE) row selection
        listview.setChoiceMode(listview.CHOICE_MODE_SINGLE);

        //--	text filtering
        listview.setTextFilterEnabled(true);


        final String deptReqDetailId = (String)getIntent().getSerializableExtra("deptReqDetailId");
        final String name = (String)getIntent().getSerializableExtra("name");


        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, option));
        */





        // Submit button definition and listener assignment
        Button clickButton = (Button) findViewById(R.id.buttonSubmit);
        clickButton.setOnClickListener( new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // Variable to register the reject quantity and reason
                rejectQty = (EditText)findViewById(R.id.editText5);
                rejectReason = (EditText)findViewById(R.id.editText6);
                Log.v("RejectQty", rejectQty.getText().toString());
                Log.v("Reject Reason", rejectReason.getText().toString());

                System.out.println("Submit buttion - Clicked");

                // Asyn task to call method to post rejection form data to database
                new AsyncTask<String, Void, String>()
                {
                    @Override
                    protected String doInBackground(String... params)
                    {
                        Item.RejectbyDeptReqDetailId(params[0], params[1], params[2]);
                        return "";
                    }
                }.execute(deptReqDetailId, rejectQty.getText().toString(), rejectReason.getText().toString());
                finish();
            }
        });


    }


}