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

/*
  Adapter class for recycler view which displays food items selected by user.The adapter has two
  main jobs: to create each of the views that are visible within the recycler view, and to bind
  each view to a piece of data
 */
public class BillAdapter extends RecyclerView.Adapter<BillAdapter.BillViewHolder> {
    Context context;
    RealmResults<FoodItem> foodItemsList;

    /*
    Context allows access to application-specific resources and classes
    RealmResult<T> is generic class which holds the resources stored in it by different classes.
     */
    public BillAdapter(Context context, RealmResults<FoodItem> foodItemsList) {
        this.context = context;
        this.foodItemsList = foodItemsList;
    }

    @NonNull
    @Override
    public BillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*
        onCreateViewHolder only creates a new view holder when there are no existing view holders
        which the RecyclerView can reuse. View is a basic building block of UI (User Interface) in
        android hence we need to inflate the view and give its context to recycler view so it can
        use it every time new item is added.
         */
        return new BillViewHolder(LayoutInflater.from(context).inflate(R.layout.selected_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BillViewHolder holder, int position) {
        /*
        Called by RecyclerView to display the data at the specified position.
         */
        final FoodItem foodItem = foodItemsList.get(position);
        holder.food_price.setText(String.valueOf(foodItem.getFoodPrice()));
        holder.ordered_food.setText(foodItem.getFoodName());

        /*
        Method to listen long click event on a view.
         */
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
        /*
        returns total items in recycler view.
         */
        return foodItemsList.size();
    }

    /*
    Inner class representing attributes of a single view.
     */
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
