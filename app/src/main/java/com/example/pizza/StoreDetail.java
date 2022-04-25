package com.example.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        /*
        Get information about selected store.
         */
        int img_id = (Integer) getIntent().getExtras().get(EXTRA_STORE_ID);
        int img_res = Store.stores[img_id].getImageId();
        String name = Store.stores[img_id].getName();
        String[] pizzaArr= Store.stores[img_id].getPizzaArr();
        String[] pastaArr= Store.stores[img_id].getPastaArr();

        /*
        Populate view with information about selected item
         */
        ImageView imageView = (ImageView) findViewById(R.id.store_img);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, img_res));
        imageView.setContentDescription(name);

        TextView storeNameTv = (TextView) findViewById(R.id.store_name);
        storeNameTv.setText(name);

        /*
        Listeners for clicks on textView.
         */
        final TextView firstPizzaTv=(TextView) findViewById(R.id.pizzaOne);
        firstPizzaTv.setText(pizzaArr[0]);
        firstPizzaTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPizzaDetails(firstPizzaTv.getText().toString());
            }
        });

        final TextView secondPizzaTv=(TextView) findViewById(R.id.pizzaTwo);
        secondPizzaTv.setText(pizzaArr[1]);
        secondPizzaTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPizzaDetails(secondPizzaTv.getText().toString());
            }
        });

        final TextView firstPastaTv=(TextView) findViewById(R.id.pastaOne);
        firstPastaTv.setText(pastaArr[0]);
        firstPastaTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPastaDetails(firstPastaTv.getText().toString());
            }
        });

        final TextView secondPastaTv=(TextView) findViewById(R.id.pastaTwo);
        secondPastaTv.setText(pastaArr[1]);
        secondPastaTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPastaDetails(secondPastaTv.getText().toString());
            }
        });

    }

    private void getPastaDetails(String pastaName) {
        int position;
        switch (pastaName)
        {
            case "Cheeseburger Pasta":position=0;
                                      break;
            case "Creamy Pesto Mac with Spinnach":position=1;
                                                  break;
            case "Green Chille and Cheese pasta":position=2;
                                           break;
            case "Lemon Parsley Pasta":position=3;
                                       break;
            case "Summer Vegetable Pasta":position=4;
                                          break;
            default:position=0;
        }
        Intent intent=new Intent(StoreDetail.this,PastaDetail.class);
        intent.putExtra(PastaDetail.EXTRA_PASTA_ID,position);
        startActivity(intent);
    }

    private void getPizzaDetails(String pizzaName) {
        int position;
        switch (pizzaName)
        {
            case "Diavolo Pizza":position=0;
                break;
            case "Funghi Pizza":position=1;
                break;
            case "Cheese Burst Pizza":position=2;
                break;
            case "Chicago Pizza":position=3;
                break;
            case "Neapolitan Pizza":position=4;
                break;
            default:position=0;
        }
        Intent intent=new Intent(StoreDetail.this,PizzaDetail.class);
        intent.putExtra(PizzaDetail.EXTRA_PIZZA_ID,position);
        startActivity(intent);
    }
}