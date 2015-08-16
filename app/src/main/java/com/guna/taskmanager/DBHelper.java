package com.guna.taskmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.guna.taskmanager.dummy.DummyContent;

public class DBHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "MyDb";
    private final static int VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE Records(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT NOT NULL," +
                "PATH TEXT NOT NULL," +
                "DESC TEXT," +
                "COUNT INT NOT NULL);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertRecords(String name, String path, String desc, int count) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues insertValues = new ContentValues();
        insertValues.put("NAME", name);
        insertValues.put("PATH", path);
        insertValues.put("DESC", desc);
        insertValues.put("COUNT", count);
        db.insert("Records", null, insertValues);
    }

    public void updateCount(String id, int count) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues insertValues = new ContentValues();
        insertValues.put("COUNT", count);
        db.update("Records", insertValues, "ID=" + id, null);
    }

    public void getRecords() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT ID,NAME,PATH,DESC,COUNT FROM Records ORDER BY COUNT DESC;";
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            do {
                Log.v("App", c.getString(0) + ", " + c.getString(1) + ", " + c.getString(2) + ", " + c.getString(3));
                DummyContent.addItem(new DummyContent.DummyItem(c.getString(0), c.getString(1), c.getString(2), c.getString(3), Integer.parseInt(c.getString(4))));
            } while (c.moveToNext());
        }
        c.close();
    }
}
