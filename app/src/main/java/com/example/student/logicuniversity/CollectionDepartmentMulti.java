package com.example.student.logicuniversity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class CollectionDepartmentMulti extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    List<Item> items;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_department_multi);

        //set title
        setTitle("COLLECTION");

        // Set up Java / XML ListView listener (using Listener interface method)
        final ListView list = (ListView) findViewById(R.id.listView2);
        list.setOnItemClickListener(this);


 /*       // On-long press touch listener for each ListView row
        list.setLongClickable(true);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int pos, long id)
            {
                System.out.println("ListView item - Long press");
                Log.v("long clicked","pos: " + pos);
                Intent intent = new Intent(getApplicationContext(), RejectionDepartment.class);
                startActivity(intent);
                return true;
            }
        });*/

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
                CollectionAdapter adapter = new CollectionAdapter(CollectionDepartmentMulti.this, R.layout.row_collection_department, items);
                list.setAdapter(adapter);
            }
        }.execute();

    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id)
    {
        String item = (String) av.getAdapter().getItem(position);

        System.out.println("ListView Select item - Clicked");

        Toast.makeText(getApplicationContext(), item + " selected",
                Toast.LENGTH_LONG).show();
    }

    public void onCheckboxClicked(View view)
    {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId())
        {
            case R.id.checkBox1:
                if (checked)
                {
                    System.out.println("ListView CheckBox item - Clicked");

                }
                else
                {

                }
                break;

            case R.id.checkBox2:
                if (checked)
                {
                    System.out.println("ListView Reject CheckBox item - Clicked");
                    Intent intent = new Intent(getApplicationContext(), RejectionDepartment.class);
                    startActivity(intent);
                }
                else
                {

                }
                break;
        }
    }

}

