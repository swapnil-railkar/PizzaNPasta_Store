package com.example.pizza;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class StoreDetail extends AppCompatActivity {
    public static final String EXTRA_STORE_ID = "storeId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_store);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int img_id = (Integer) getIntent().getExtras().get(EXTRA_STORE_ID);
        int img_res = Store.stores[img_id].getImageId();
        String name = Store.stores[img_id].getName();

        ImageView imageView = (ImageView) findViewById(R.id.store_img);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, img_res));
        imageView.setContentDescription(name);

        TextView textView = (TextView) findViewById(R.id.store_name);
        textView.setText(name);
    }
}