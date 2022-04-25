package com.example.pizza;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /*
        Get instance of Realm object.
         */
        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        /*
        Get the list of food items selected by user.
         */
        RealmResults<FoodItem> foodItemsList = realm.where(FoodItem.class).findAll();

        /*
        Populate recyclerView with those items.
         */
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.bill_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final BillAdapter adapter = new BillAdapter(getApplicationContext(),foodItemsList);
        recyclerView.setAdapter(adapter);

        /*
        Listener if list changes
         */
        foodItemsList.addChangeListener(new RealmChangeListener<RealmResults<FoodItem>>() {
            @Override
            public void onChange(RealmResults<FoodItem> foodItems) {
                adapter.notifyDataSetChanged();
                long sum = (long) foodItems.sum("foodPrice");
                TextView totalCost = (TextView) findViewById(R.id.total_cost);
                totalCost.setText(String.valueOf(sum));
            }
        });

        /*
        Total cost of all food items selected by user.
         */
        TextView totalCost = (TextView) findViewById(R.id.total_cost);
        long sum = (long)foodItemsList.sum("foodPrice");
        totalCost.setText(String.valueOf(sum));
    }



    public void onClickDone(View view) {

        CharSequence text="Order will be delivered to your address";
        final CharSequence toast_text="Order Cancelled";
        int duration= Snackbar.LENGTH_SHORT;

        final EditText address = (EditText) findViewById(R.id.user_address_input);
        final EditText number = (EditText) findViewById(R.id.user_number_input);

        if(address.getText().toString().isEmpty())
        {
            text = "Please Enter Your Address";
        }else if (number.getText().toString().isEmpty())
        {
            text = "Please Enter Your Contact Number";
        }
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