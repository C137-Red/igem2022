package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String db_name = "igem2022.db";

    public DBHelper(Context context, int version) {
        super(context, db_name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table results (" +
                "instrument_no INTEGER,"+
                "port_no INTEGER,"+
                "Time TEXT,"+
                "R INTEGER,"+
                "G INTEGER,"+
                "B INTEGER"+
                ")");
        //创建数据表，属性依次为设备号，设备端口号，时间，各项参数

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
