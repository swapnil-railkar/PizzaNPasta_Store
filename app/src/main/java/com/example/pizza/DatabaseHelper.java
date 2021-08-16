package com.example.pizza;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="USER_PROFILE";
    private static final int DB_VERSION=2;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
          updateData(db,0,DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          updateData(db,oldVersion,newVersion);
    }

    public void insertData(SQLiteDatabase db,String name,String password,int img_res)
    {
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("PASSWORD",password);
        values.put("IMG_RES",img_res);
        db.insert("USER",null,values);
    }

    public void updateData(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        if(oldVersion < 1)
        {
            db.execSQL("CREATE TABLE USER (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "NAME TEXT," +
                    "PASSWORD TEXT" +
                    ",IMG_RES INTEGER)");
            insertData(db,"Doge","dogeOp",R.drawable.doge);
        }
    }

}
