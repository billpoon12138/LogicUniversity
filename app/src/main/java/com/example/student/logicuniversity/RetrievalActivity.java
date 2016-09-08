package com.example.student.logicuniversity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RetrievalActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieval);
        //set title
        setTitle("Menu");
        String []values = {"Apple","Blackberry","Cherry","Dragon Fruit","Grape"};
        List<String> itemList = new ArrayList<String>();
        for(Item item : Item.getRequisition()){
            itemList.add(item.get("name").toString());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.row, R.id.textView1, (String[]) itemList.toArray());
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id) {
        String item = (String) av.getAdapter().getItem(position);
        Toast.makeText(getApplicationContext(), item + " selected",
                Toast.LENGTH_LONG).show();
    }
}
