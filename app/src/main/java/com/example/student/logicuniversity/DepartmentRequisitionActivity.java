package com.example.student.logicuniversity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.student.logicuniversity.model.Department;

public class DepartmentRequisitionActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_requisition);
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id) {
        Department department = (Department) av.getAdapter().getItem(position);
        Intent intent = new Intent(this, CollectionDepartmentMulti.class);
        intent.putExtra("department", department);
        startActivity(intent);
    }
}
