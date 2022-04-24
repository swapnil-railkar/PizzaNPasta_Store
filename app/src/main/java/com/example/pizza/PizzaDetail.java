package com.example.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import io.realm.Realm;

public class PizzaDetail extends AppCompatActivity {

    public static final String EXTRA_PIZZA_ID = "pizzaId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        // Create Realm reference and object
        Realm.init(getApplicationContext());
        final Realm realm_pizza = Realm.getDefaultInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int pizzaId = (Integer) getIntent().getExtras().get(EXTRA_PIZZA_ID);
        final String pizza_name = Pizza.pizza[pizzaId].getName();
        int pizza_img = Pizza.pizza[pizzaId].getImageResourceId();
        final int pizza_price= Pizza.pizza[pizzaId].getPrice();
        final String pizza_provider= Pizza.pizza[pizzaId].getProvider();

        TextView pizzaNameTv = (TextView) findViewById(R.id.pizza_text);
        pizzaNameTv.setText(pizza_name);

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pizza_img));
        imageView.setContentDescription((CharSequence) pizza_name);

        TextView pizzaPriceTv = (TextView) findViewById(R.id.pizzaPriceText);
        pizzaPriceTv.setText("Rs. "+pizza_price);

        Button orderButton = (Button) findViewById(R.id.orderPizza);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm_pizza.beginTransaction();
                FoodItem item = realm_pizza.createObject(FoodItem.class);
                item.setFoodPrice(pizza_price);
                item.setFoodName(pizza_name);
                realm_pizza.commitTransaction();
                Toast.makeText(getApplicationContext(),pizza_name+" is added to cart ",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        final TextView pizzaProviderTv = (TextView) findViewById(R.id.pizzaProviderText);
        pizzaProviderTv.setText(pizza_provider);
        pizzaProviderTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position;
                switch (pizzaProviderTv.getText().toString())
                {
                    case "Store A": position=0;
                        break;
                    case "Store B": position=1;
                        break;
                    case "Store C": position=2;
                        break;
                    default: position=0;
                }
                Intent intent = new Intent(PizzaDetail.this,StoreDetail.class);
                intent.putExtra(StoreDetail.EXTRA_STORE_ID,position);
                startActivity(intent);


            }
        });

    }

}