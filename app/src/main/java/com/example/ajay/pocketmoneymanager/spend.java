package com.example.ajay.pocketmoneymanager;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class spend extends AppCompatActivity {
    EditText Spendon,Amount;
    String spendon,amount;
    Button update;
    Context ctx =this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spend);
        getSupportActionBar().hide();
        Spendon=(EditText)findViewById(R.id.spendon);
        Amount=(EditText)findViewById(R.id.amount);
        update=(Button)findViewById(R.id.button);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spendon = Spendon.getText().toString();
                amount = Amount.getText().toString();
                if (Integer.parseInt(amount) < Addcash.total_cash){
                    DataOperations DB = new DataOperations(ctx);
                    Addcash.total_cash = Addcash.total_cash - Integer.parseInt(amount);
                    long ret = DB.putInformation(DB, spendon, amount);
                    if (ret != -1) {
                        Toast.makeText(getBaseContext(), "Record Updated", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(getBaseContext(), "Records couldn't be updated", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }else{
                        Toast.makeText(getBaseContext(), "You don't have sufficient balance", Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spend, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
