package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBManager {

    private Context context;
    private static DBManager instance;
    // 操作表的对象，进行增删改查
    static private SQLiteDatabase writableDatabase;

    private DBManager(Context context) {
        this.context = context;
        DBHelper dbHelper = new DBHelper(context, 1);
        writableDatabase = dbHelper.getWritableDatabase();
    }

    public static DBManager getInstance(Context context) {
        if (instance == null) {
            synchronized (DBManager.class) {
                if (instance == null) {
                    instance = new DBManager(context);
                }
            }
        }
        return instance;
    }

    public static void add(ContentValues contentValues)
    {
        writableDatabase.insert("results", null, contentValues);
    }
    //插入数据，数据要拼装成一个contentvalue

    public String select() {

        Cursor cursor = writableDatabase.query("table1", null, null, null, null, null, null, null);

        int position = cursor.getPosition();
        Log.e(TAG, "select: 游标默认位置：" + position);

        String result = "";

        while (cursor.moveToNext()) {

            byte _byte = (byte) cursor.getShort(cursor.getColumnIndex("_byte"));
            long _long = cursor.getLong(cursor.getColumnIndex("_long"));
            String _text = cursor.getString(cursor.getColumnIndex("_text"));
            short _short = cursor.getShort(cursor.getColumnIndex("_short"));
            int _int = cursor.getInt(cursor.getColumnIndex("_int"));
            float _float = cursor.getFloat(cursor.getColumnIndex("_float"));
            double _double = cursor.getDouble(cursor.getColumnIndex("_double"));
            boolean _boolean = cursor.getInt(cursor.getColumnIndex("_boolean")) == 1 ? true : false;
            byte[] _byteArr = cursor.getBlob(cursor.getColumnIndex("_blob"));

            result += String.format("_byte = %s, _long = %s, _text = %s, _short = %s, _int = %s, _float = %s, _double = %s, _boolean = %s, _byteArr = %s",
                    _byte, _long, _text, _short, _int, _float, _double, _boolean, _byteArr) + "\n";

        }

        return result;

    }

}

