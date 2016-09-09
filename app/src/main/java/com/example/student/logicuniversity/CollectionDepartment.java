package com.example.student.logicuniversity;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class CollectionDepartment extends ListActivity
{
    // For Testing - Temporary use of String array; need to use CursorAdaptor
    String[] menulist = {"Ruler", "Pencil"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_department);

        // For Testing - Temporary use of Array Adaptor to pull data from String array to ListView, need to use CursorAdaptor
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_activated_1, menulist);
        getListView().setAdapter(adaptor);


    }
}
