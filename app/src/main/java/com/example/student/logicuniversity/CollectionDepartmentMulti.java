package com.example.student.logicuniversity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.example.student.logicuniversity.adapter.CollectionAdapter;
import com.example.student.logicuniversity.model.Department;
import com.example.student.logicuniversity.model.Item;

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

        final String deptId = (String)getIntent().getSerializableExtra("DeptId");

        new AsyncTask<String, Void, List<Item>>()
        {
            @Override
            protected List<Item> doInBackground(String... params)
            {
                return items = Item.getRequisitionByDepartmentIdCollection(deptId);
            }
            @Override
            protected void onPostExecute(List<Item> result)
            {
                CollectionAdapter adapter = new CollectionAdapter(CollectionDepartmentMulti.this, R.layout.row_collection_department, items);
                list.setAdapter(adapter);
            }
        }.execute(deptId);

        // Submit button to confirm the collection
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
                        Department.confirmCollection(deptId);
                        return "";
                    }
                    @Override
                    protected void onPostExecute(String aa)
                    {
                        finish();
                    }
                }.execute(deptId);
            }
        });

        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id)
    {
        Item item = (Item) av.getAdapter().getItem(position);

        Intent intent = new Intent(getApplicationContext(), RejectionDepartment.class);
        intent.putExtra("deptReqDetailId", item.get("deptReqDetailId"));
        intent.putExtra("name", item.get("name"));
        startActivity(intent);

    }


}

//        System.out.println("ListView Select item - Clicked");
//
//        Toast.makeText(getApplicationContext(), item + " selected",
//                Toast.LENGTH_LONG).show();

/*    public void onCheckboxClicked(View view)
    {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId())
        {
            // CheckBox1 not used
            *//*case R.id.checkBox1:
                if (checked)
                {
                    System.out.println("ListView CheckBox item - Clicked");

                }
                else
                {

                }
                break;*//*

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
    }*/