package com.example.ajay.pocketmoneymanager;

/**
 * Created by Ratul on 11/7/2015.
 */
public class Column_Data {
    int id;
    String date;
    String spend;
    String amount;

    public Column_Data(int id,String spend, String amount,String date) {
        this.id = id;
        this.spend = spend;
        this.amount = amount;
        this.date = date;
    }
}
