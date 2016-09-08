package com.example.student.logicuniversity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //set title
        setTitle("Menu");
        String []values = {"Retrieval","Disbursement","Inventory Update","Inventory Audit","Scan Bin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.row, R.id.textView1, values);
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id) {
        String item = (String) av.getAdapter().getItem(position);
//        Toast.makeText(getApplicationContext(), item + " selected",
//                Toast.LENGTH_LONG).show();
        switch (item) {
            case "Retrieval":
                startActivity(new Intent(this, RetrievalActivity.class));
        }

    }
}
