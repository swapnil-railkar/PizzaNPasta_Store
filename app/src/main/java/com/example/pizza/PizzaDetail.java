package com.example.pizza;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class PizzaDetail extends AppCompatActivity {

    public static final String EXTRA_PIZZA_ID = "pizzaId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int pizzaId = (Integer) getIntent().getExtras().get(EXTRA_PIZZA_ID);
        String pizza_name = Pizza.pizza[pizzaId].getName();
        int pizza_img = Pizza.pizza[pizzaId].getImageResourceId();

        TextView textView = (TextView) findViewById(R.id.pizza_text);
        textView.setText(pizza_name);

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pizza_img));
        imageView.setContentDescription((CharSequence) pizza_name);


    }
}