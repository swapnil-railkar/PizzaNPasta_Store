package com.example.pizza;

import io.realm.RealmObject;

/*
Realm is an open source object database management system. We are going to store FoodItem.class
objects in Realm.
 */
public class FoodItem extends RealmObject {
    String foodName;
    int foodPrice;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }
}
