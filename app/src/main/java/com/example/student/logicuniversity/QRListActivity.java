package com.example.student.logicuniversity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QRListActivity extends AppCompatActivity
{

    final static int []view = {R.id.editText1, R.id.editText2, R.id.editText3, R.id.editText4,R.id.editText5, R.id.editText6, R.id.editText7, R.id.editText8,R.id.editText9};
    final static String []key = {"Partid", "Description", "Location", "Vendor","Vendorid", "Documentid", "Targetlevel", "Reorderlevel","Balance"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrlist);

        // Received part id from QR code from previous activity intent and store in variable value1
        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("key1");

        // Use variable value1 (QR code value) and use getSpares method to pull data into activity table view
        new AsyncTask<String, Void, QRSpares>()
        {
            @Override
            protected QRSpares doInBackground (String...params)
            {
                return QRSpares.getSpares(params[0]);
            }

            // Returned Spares object (spa) value from getSpares method as input parameter (result)
            // Based on key values (column name), pull out the associated data values and put them into EditText view
            @Override
            protected void onPostExecute (QRSpares result)
            {
                // If the returned object from getSpares method is null; i.e cannot find part id on web server
                if (result == null)
                {
                    // Do not want to use a standard toast; cannot set color and position
                    //Toast.makeText(getApplicationContext(), "THIS PART DOES NOT EXISTS !",Toast.LENGTH_SHORT).show();

                    Toast toast = Toast.makeText(getApplicationContext(), "THIS PART DOES NOT EXISTS ! ", Toast.LENGTH_LONG);
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(Color.RED);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
                    toast.show();

                    return;
                }

                for (int i = 0; i < view.length; i++)
                {
                    EditText t = (EditText) findViewById(view[i]);
                    t.setText(result.get(key[i]));
                }

                // Extract the value from the EditText view and convert to an integer, assign to bal (balance)
                EditText balance = (EditText) findViewById(view[8]);
                int bal = Integer.valueOf(balance.getText().toString());
                // Extract the value from the EditText view and convert to an integer, assign to reord (reorderlevel)
                EditText reorder = (EditText) findViewById(view[7]);
                int reord = Integer.valueOf(reorder.getText().toString());

                // Compare balance and reorderlevel, if less, create a toast to ask for top up.
                if (bal < reord)
                {
                    Log.i("event", "Top up needed");
                    //Standard toast cannot set color or position
                    //Toast.makeText(getApplicationContext(), "PLEASE TOP UP THIS PART !",Toast.LENGTH_SHORT).show();

                    // Use this toast to set color and position
                    Toast toast = Toast.makeText(getApplicationContext(), "PLEASE TOP UP THIS PART !", Toast.LENGTH_LONG);
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(Color.RED);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        }.execute(value1);


    }

}
