package com.example.sherry.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class ProductDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "product.db";
    private static final String TABLE_NAME = "Product";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";

    public ProductDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                COLUMN_NAME + " TEXT " + ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void add(Product product)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, product.getName());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert(TABLE_NAME,null,values);
        sqLiteDatabase.close();
    }

    public void delete(String name)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + " =/ " + name + " /; " );
    }

    public String get()
    {
        String data = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME ;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        data = "name lelo";
        cursor.moveToFirst();

//        while(!cursor.isAfterLast())
//        {
//            if(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)) != null)
//            {
//                data += cursor.getString(1);
//                data += "\n";
//            }
//        }
        while(cursor.isAfterLast() == false){
            data += cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            data += "\n";
            cursor.moveToNext();
        }
        sqLiteDatabase.close();
        return data;
    }
    public ArrayList<String> getArray()
    {
        ArrayList<String> data = new ArrayList<String>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME ;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
      //  data = "name lelo";
        cursor.moveToFirst();

//        while(!cursor.isAfterLast())
//        {
//            if(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)) != null)
//            {
//                data += cursor.getString(1);
//                data += "\n";
//            }
//        }
        while(cursor.isAfterLast() == false){
            data.add(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
         //   data += "\n";
            cursor.moveToNext();
          //  Log.i("data",cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
        }

        sqLiteDatabase.close();
        return data;

    }


}
