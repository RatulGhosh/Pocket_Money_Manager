package com.example.ajay.pocketmoneymanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ajay.pocketmoneymanager.TableData.TableInfo;

import java.util.ArrayList;


/**
 * Created by Ajay on 10/31/2015.
 */
public class DataOperations extends SQLiteOpenHelper {
    public static final int database_version=1;


    public String CREATE_QUERY="CREATE TABLE IF NOT EXISTS "+TableInfo.TABLE_NAME+" ("+TableInfo.id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+TableInfo.Spendon+" TEXT,"+TableInfo.Amount+" TEXT,"+TableInfo.date+" DATETIME DEFAULT CURRENT_TIMESTAMP)";
    final static String QUERY_DROP_TABLE = "DELETE TABLE IF EXISTS "+TableInfo.TABLE_NAME;

    public DataOperations(Context context){
        super(context , TableInfo.DATABASE_NAME,null,database_version);
        Log.d("DataOperations","Database Created");

    }
    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Data Operations","Table Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(QUERY_DROP_TABLE);
    }
    public long putInformation(DataOperations dop,String spendon,String amount){
        //SQLiteDatabase SQ=dop.getWritableDatabase();
        SQLiteDatabase SQ=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TableInfo.Spendon,spendon);
        cv.put(TableInfo.Amount, amount);
        long k = SQ.insert(TableInfo.TABLE_NAME, null, cv);
        Log.d("Data Operations", "One raw inserted");
        return k;
    }
    public void delete(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TableInfo.TABLE_NAME,null,null);
    }
    public ArrayList<Column_Data> getInformation(){
        ArrayList<Column_Data> arrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TableInfo.TABLE_NAME, null, null, null, null, null, null);//null for all columns
        cursor.moveToFirst();//come to the first row
        for(int i = 0;i<cursor.getCount();i++){
            int id = cursor.getInt(cursor.getColumnIndex(TableInfo.id));
            String spend = cursor.getString(cursor.getColumnIndex(TableInfo.Spendon));
            String amount = cursor.getString(cursor.getColumnIndex(TableInfo.Amount));
            String date = cursor.getString(cursor.getColumnIndex(TableInfo.date));
            Column_Data column_data = new Column_Data(id,spend,amount,date);
            arrayList.add(column_data);
            cursor.moveToNext();
        }
        return arrayList;
    }

}
