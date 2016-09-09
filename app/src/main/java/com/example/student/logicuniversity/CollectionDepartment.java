package com.example.student.logicuniversity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

public class CollectionDepartment extends ListActivity {

    String[] stationary= {
            "Pen",
            "Pencil",
            "Paper",
            "Stapler"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_department);

        // -- Display mode of the ListView
        ListView listview= getListView();
        listview.setChoiceMode(listview.CHOICE_MODE_MULTIPLE);

        //--	text filtering
        listview.setTextFilterEnabled(true);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, stationary));


        // On-long press touch listener for each ListView row
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                System.out.println("ListView item - Long press");
                Intent intent = new Intent(getApplicationContext(), RejectionDepartment.class);
                startActivity(intent);
                return false;
            }
        });

    }

    // On-click listener for each ListView row to generate a toast
    public void onListItemClick(ListView parent, View v,int position,long id)
    {
        CheckedTextView item = (CheckedTextView) v; Toast.makeText(this, stationary[position] + " checked : " + item.isChecked(), Toast.LENGTH_SHORT).show();
        System.out.println("ListView item - Clicked");
    }

}
