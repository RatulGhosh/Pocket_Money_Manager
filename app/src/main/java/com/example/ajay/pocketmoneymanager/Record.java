package com.example.ajay.pocketmoneymanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Record extends AppCompatActivity {

    ListView lvRecord;
    ArrayList<Column_Data> arrayList;
    DataOperations db;
    TextView tv_totalamount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        lvRecord = (ListView)findViewById(R.id.listView);
        db = new DataOperations(getApplicationContext());
        arrayList = db.getInformation();
        tv_totalamount = (TextView) findViewById(R.id.textView8);
        tv_totalamount.setText("Current Balance is : Rs. "+Addcash.total_cash);
        lvRecord.setAdapter(new RecordAdapter());


    }
    class RecordAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View layout = convertView;
            if(layout == null){
                layout = getLayoutInflater().inflate(R.layout.about_item,parent,false);
            }

            TextView tvSpend = (TextView) layout.findViewById(R.id.textView5);
            TextView tvAmount = (TextView) layout.findViewById(R.id.textView6);
            TextView tvDate = (TextView)layout.findViewById(R.id.textView7);
            Column_Data contactHolder = arrayList.get(position);
            tvSpend.setText(contactHolder.spend);
            tvAmount.setText("Rs. "+contactHolder.amount);
            tvDate.setText(contactHolder.date);
            return layout;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_record, menu);
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
