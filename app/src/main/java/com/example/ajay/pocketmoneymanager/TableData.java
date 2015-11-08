package com.example.ajay.pocketmoneymanager;

import android.provider.BaseColumns;

/**
 * Created by Ajay on 10/31/2015.
 */
public class TableData {
    public TableData(){

    }
    public static abstract class TableInfo implements BaseColumns{
        public static final String Spendon="spendon";
        public static final String Amount ="amount";
        public static final String id ="id";
        public static final String date = "date";
        public static final String DATABASE_NAME="user_info";
        public static final String TABLE_NAME="reg_info";
    }

}
