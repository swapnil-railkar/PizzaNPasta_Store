package com.example.pizza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.Realm;
import io.realm.RealmResults;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.BillViewHolder> {
    Context context;
    RealmResults<FoodItem> foodItemsList;

    public BillAdapter(Context context, RealmResults<FoodItem> foodItemsList) {
        this.context = context;
        this.foodItemsList = foodItemsList;
    }

    @NonNull
    @Override
    public BillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BillViewHolder(LayoutInflater.from(context).inflate(R.layout.selected_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BillViewHolder holder, int position) {
        final FoodItem foodItem = foodItemsList.get(position);
        holder.food_price.setText(String.valueOf(foodItem.getFoodPrice()));
        holder.ordered_food.setText(foodItem.getFoodName());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu menu = new PopupMenu(context,view);
                menu.getMenu().add("REMOVE");
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getTitle().equals("REMOVE"))
                        {
                            Realm realm = Realm.getDefaultInstance();
                            realm.beginTransaction();
                            foodItem.deleteFromRealm();
                            realm.commitTransaction();
                            Toast.makeText(context,"Order Removed ",Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
                menu.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodItemsList.size();
    }

    public class BillViewHolder extends RecyclerView.ViewHolder{
         TextView ordered_food;
         TextView food_price;
        public BillViewHolder(@NonNull View itemView) {
            super(itemView);
            ordered_food = (TextView) itemView.findViewById(R.id.selected_item);
            food_price = (TextView) itemView.findViewById(R.id.selected_cost);
        }
    }

}
