package com.example.student.logicuniversity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MenuStoreActivity extends ListActivity
{
    // QR code; unique constant for the QR camera scan
    static final int CAPTURE_QRCODE = 1234;
    static final int REQUEST_CODE = 2222;

    String[] menulist = {"Retrieval", "Breakdown By Department"}; // Names for the 2 ListView rows
    // "Inventory Update", "Inventory Audit", "Scan bin" taken out of string array

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_store);



        // Use Array Adaptor to pull data from String array to ListView
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(getListView().getContext(), R.layout.mytextview, menulist);
        getListView().setAdapter(adaptor);

        // Create scan button event listener
        Button button3 = (Button) findViewById(R.id.buttonScan);
        button3.setOnClickListener(new View.OnClickListener()
        {
            //Start scan activity
            @Override
            public void onClick(View arg0)
            {
                Log.i("event", "Scan button clicked");
                Intent intent = new Intent("la.droid.qr.scan");
                intent.putExtra("la.droid.qr.complete", true);
                try
                {
                    startActivityForResult(intent, CAPTURE_QRCODE);

                } catch (android.content.ActivityNotFoundException anfe)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=la.droid.qr.priva")));
                }
            }
        });

    }
    // Listener for the list table menu
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
        else if (position == 1) // OnClick second row of ListView, transit to next activity (Disbursement screen)
        {
            Intent intent = new Intent(this, DisbursementActivity.class);
            startActivity(intent);
        }
    }
    // Listener actions for the QR code button
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == CAPTURE_QRCODE)
        {
            Log.i("event", "Scan button clicked 2");
            if (resultCode == RESULT_OK)
            {
                Log.i("event", "Scan button clicked 3");
                if (data.hasExtra("la.droid.qr.result"))
                {
                    Log.i("event", "Scan button clicked 4");
                    // res will hold the scanned QR code result
                    String res = data.getExtras().getString("la.droid.qr.result");

                    //To show the scanned result via a toast on screen
                    Toast.makeText(this, res, Toast.LENGTH_LONG).show();

                    // Start new activity to show information about scanned itemCode (QR code)

                    Intent i = new Intent(this, QRListActivity.class);
                    i.putExtra("key1", res);
                    Log.i("event", "Scan button clicked 5");
                    startActivityForResult(i, REQUEST_CODE);
                }
            } else if (resultCode == RESULT_CANCELED)
            {
                // Capture cancelled
                Log.i("event", "Scan button failed 1");
            } else
            {
                // Capture failed
                Log.i("event", "Scan button failed 2");
            }
        }
    }

}
