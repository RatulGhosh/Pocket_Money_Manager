package com.example.ajay.pocketmoneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Button btspend = (Button) findViewById(R.id.btspend);
        btspend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), spend.class);
                startActivity(i);
            }
        });
        Button btac = (Button)findViewById(R.id.btac);
        btac.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Addcash.class);
                startActivity(intent);

            }
        });
        Button btreset = (Button)findViewById(R.id.btreset);
        btreset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Reset.class);
                startActivity(in);

            }
        });
        Button btabout = (Button)findViewById(R.id.btabout);
        btabout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent in2 = new Intent(getApplicationContext(),About.class);
                startActivity(in2);

            }
        });
        Button btrecord = (Button)findViewById(R.id.btrecord);
        btrecord.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent in2 = new Intent(getApplicationContext(),Record.class);
                startActivity(in2);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
