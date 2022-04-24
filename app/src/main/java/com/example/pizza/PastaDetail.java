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

public class PastaDetail extends AppCompatActivity {
    public static final String EXTRA_PASTA_ID = "pastaId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta_detail);

        //Create Realm reference and object
        Realm.init(getApplicationContext());
        final Realm realm_pasta = Realm.getDefaultInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.pasta_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int pasta_id = (Integer) getIntent().getExtras().get(EXTRA_PASTA_ID);
        int past_res = Pasta.pastas[pasta_id].getImageResourceId();
        final String pasta_name = Pasta.pastas[pasta_id].getName();
        final int price= Pasta.pastas[pasta_id].getPrice();
        String provider= Pasta.pastas[pasta_id].getProvider();


        TextView pastaNameTv = (TextView)findViewById(R.id.pasta_text);
        pastaNameTv.setText(pasta_name);

        ImageView imageView = (ImageView) findViewById(R.id.pasta_img);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, past_res));
        imageView.setContentDescription((CharSequence) pasta_name);

        TextView pastaPriceTv = (TextView) findViewById(R.id.pastaPriceText);
        pastaPriceTv.setText("Rs. "+price);

        Button orderButton = (Button) findViewById(R.id.orderPasta);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm_pasta.beginTransaction();
                FoodItem item = realm_pasta.createObject(FoodItem.class);
                item.setFoodName(pasta_name);
                item.setFoodPrice(price);
                realm_pasta.commitTransaction();

                Toast.makeText(getApplicationContext(),pasta_name+" is added to cart",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        final TextView pastaProviderTv = (TextView) findViewById(R.id.pastaProviderText);
        pastaProviderTv.setText(provider);
        pastaProviderTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position;
                switch(pastaProviderTv.getText().toString())
                {
                    case "Store A": position=0;
                                    break;
                    case "Store B": position=1;
                                    break;
                    case "Store C": position=2;
                                    break;
                    default: position=0;
                }
                Intent intent = new Intent(PastaDetail.this,StoreDetail.class);
                intent.putExtra(StoreDetail.EXTRA_STORE_ID,position);
                startActivity(intent);
            }
        });




    }


}