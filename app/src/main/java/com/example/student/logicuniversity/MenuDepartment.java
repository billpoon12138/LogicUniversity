package com.example.student.logicuniversity;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
<<<<<<< HEAD
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
=======

import android.support.v7.app.ActionBarActivity;
>>>>>>> a0ebff28448a3259d7771aac2ed5c405cc0826d5
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuDepartment extends ListActivity
{
    String[] menulist = {"Collection", "Distribute"}; // Names for the 2 ListView rows
    String deptId;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_department);
        deptId = (String)getIntent().getSerializableExtra("DeptId");

        //set title
        setTitle("MENU");

        // Use Array Adaptor to pull data from String array to ListView
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(getListView().getContext(), R.layout.mytextview, menulist);
        getListView().setAdapter(adaptor);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);

        if (position == 0) // OnClick first row of ListView, transit to next activity (Collection screen)
        {
            Intent intent = new Intent(this, CollectionDepartmentMulti.class);
            intent.putExtra("DeptId", deptId);
            startActivity(intent);
        }
        else if (position == 1) // OnClick second row of ListView, transit to next activity (Distribute Employee screen)
        {
//            SharedPreferences pref =  PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//            String deptId = pref.getString("DeptId", "1");
            Intent intent = new Intent(this, EmployeeDepartment.class);
            intent.putExtra("DeptId", deptId);
            startActivity(intent);
        }

    }
}
