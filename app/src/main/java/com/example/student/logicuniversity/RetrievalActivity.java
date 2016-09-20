package com.example.student.logicuniversity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RetrievalActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieval);
        //set title
        setTitle("RETRIEVAL");
//        items = Item.getRequisition();
//        SimpleAdapter adapter = new SimpleAdapter
//                (this, items, R.layout.row2,
//                        new String[]{"name", "id"},
//                        new int[]{R.id.text1, R.id.text2});
        final ListView list = (ListView) findViewById(R.id.listView);

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
                ItemAdapter adapter = new ItemAdapter(RetrievalActivity.this, R.layout.row3, items);
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

        }
    }


}
