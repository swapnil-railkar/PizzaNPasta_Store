package com.example.pizza;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void onClickDone(View view) {
        final CharSequence text="Order has been updated";
        final CharSequence toast_text="Order Cancelled";
        int duration= Snackbar.LENGTH_SHORT;
        Snackbar snackbar=Snackbar.make(findViewById(R.id.coordinator),text,duration);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(getApplicationContext(),toast_text,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        snackbar.show();
    }
}