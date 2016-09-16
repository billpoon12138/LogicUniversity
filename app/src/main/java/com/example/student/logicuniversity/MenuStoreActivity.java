package com.example.student.logicuniversity;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuStoreActivity extends ListActivity {

    String[] menulist = {"Retrieval", "Disbursement", "Inventory Update", "Inventory Audit", "Scan bin"}; // Names for the 5 ListView rows

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_store);

        // Use Array Adaptor to pull data from String array to ListView
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_activated_1, menulist);
        getListView().setAdapter(adaptor);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);

        if (position == 0) // OnClick first row of ListView, transit to next activity (Collection screen)
        {
            Intent intent = new Intent(this, RetrievalActivity.class);
            startActivity(intent);
        }
        else if (position == 1) // OnClick second row of ListView, transit to next activity (Distribute Employee screen)
        {
            Intent intent = new Intent(this, DisbursementActivity.class); // Remember to change name to "Distribute"
//            Intent intent = new Intent(this, CollectionDepartmentMulti.class);
            startActivity(intent);
        }

    }
}
