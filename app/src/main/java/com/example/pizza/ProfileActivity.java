package com.example.pizza;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar=(Toolbar) findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        SQLiteOpenHelper db_helper=new DatabaseHelper(this);
        try{
            SQLiteDatabase db=db_helper.getReadableDatabase();
            Cursor cursor=db.query("USER",
                    new String[]{"NAME","PASSWORD","IMG_RES"},
                    "_id=?",
                    new String[]{Integer.toString(1)},null,null,null);
            if (cursor.moveToFirst())
            {
                String name=cursor.getString(0);
                int img_res=cursor.getInt(2);

                TextView user_name=findViewById(R.id.user_name);
                user_name.setText(name);

                ImageView imageView=findViewById(R.id.profile_imageView);
                imageView.setImageResource(img_res);
                imageView.setContentDescription(name);
            }
            cursor.close();
            db.close();
        }catch (SQLiteException e)
        {
            Toast.makeText(this,"Database not available",Toast.LENGTH_SHORT).show();
        }
    }
}