package com.example.student.logicuniversity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StoreMenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_menu);
        setTitle("Menu");
        final ListView list = (ListView) findViewById(R.id.listView);
        String []values = {"Retrieval", "Disbursement", "Inventory Update", "Inventory Audit", "Scan bin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.row, R.id.textView1, values);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id) {
        Department department = (Department) av.getAdapter().getItem(position);
    }
}
