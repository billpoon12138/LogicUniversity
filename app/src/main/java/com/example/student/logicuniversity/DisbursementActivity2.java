package com.example.student.logicuniversity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.example.student.logicuniversity.adapter.Disbursement2Adapter;
import com.example.student.logicuniversity.model.Item;

import java.util.List;


public class DisbursementActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    List<Item> items;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disbursement2);

        //set title
        setTitle("BREAKDOWN BY DEPARTMENT");

        // Set up Java / XML ListView listener (using Listener interface method)
        final ListView list = (ListView) findViewById(R.id.listView2);
        list.setOnItemClickListener(this);

        final String deptId = (String)getIntent().getSerializableExtra("DeptId");


        new AsyncTask<String, Void, List<Item>>()
        {
            @Override
            protected List<Item> doInBackground(String... params)
            {
                return items = Item.getRequisitionByDepartmentId(params[0]);
            }
            @Override
            protected void onPostExecute(List<Item> result)
            {
                Disbursement2Adapter adapter = new Disbursement2Adapter(DisbursementActivity2.this, R.layout.row_disbursement_store, items);
                list.setAdapter(adapter);
            }
        }.execute(deptId);

    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id)
    {
        String item = (String) av.getAdapter().getItem(position);

        System.out.println("ListView Select item - Clicked");

        Toast.makeText(getApplicationContext(), item + " selected",
                Toast.LENGTH_LONG).show();
    }

//    public void onCheckboxClicked(View view)
//    {
//        // Is the view now checked?
//        boolean checked = ((CheckBox) view).isChecked();
//
//        // Check which checkbox was clicked
//        switch(view.getId())
//        {
//            case R.id.checkBox1:
//                if (checked)
//                {
//                    System.out.println("ListView CheckBox item - Clicked");
//                    System.out.println(view.getId());
//
//
//
//                }
//                else
//                {
//                    System.out.println("ListView CheckBox item - UnClick");
//                }
//                break;
//
//        }
//    }

}

