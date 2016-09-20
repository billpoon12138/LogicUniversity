package com.example.student.logicuniversity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class DisbursementActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    List<Department> departments;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disbursement);

        //set title
        setTitle("DISBURSEMENT");

        final ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(this);

        new AsyncTask<Void, Void, List<Department>>()
        {
            @Override
            protected List<Department> doInBackground(Void... params)
            {
                return departments = Department.getDepartments();
            }
            @Override
            protected void onPostExecute(List<Department> result)
            {
                DepartmentAdapter adapter = new DepartmentAdapter(DisbursementActivity.this, R.layout.row4, departments);
                list.setAdapter(adapter);
            }
        }.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id)
    {
        Department department = (Department) av.getAdapter().getItem(position);
//        Toast.makeText(getApplicationContext(), item + " selected",
//                Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, CollectionDepartmentMulti.class);
        intent.putExtra("department", department);
        startActivity(intent);
    }
}
