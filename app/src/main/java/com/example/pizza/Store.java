package com.example.pizza;

public class Store {

    private int store_id;
    private String name;
    String[] pizzaArr;
    String[] pastaArr;

    public static final Store[] stores={
            new Store("Store A",R.drawable.stored,new String[]{"Diavolo Pizza","Chicago Pizza"},
                    new String[]{"Green Chille and Cheese pasta",""}),
            new Store("Store B",R.drawable.storea,new String[]{"Funghi Pizza","Neapolitan Pizza"},
                    new String[]{"Cheeseburger Pasta","Lemon Parsley Pasta"}),
            new Store("Store C",R.drawable.storec,new String[]{"Cheese Burst Pizza",""},
                    new String[]{"Creamy Pesto Mac with Spinnach","Summer Vegetable Pasta"})
    };

    Store(String name,int store_id,String[] pizzaArr,String[] pastaArr)
    {
        this.name=name;
        this.store_id=store_id;
        this.pizzaArr=pizzaArr;
        this.pastaArr=pastaArr;

    }

    public String getName()
    {
        return this.name;
    }

    public int getImageId()
    {
        return this.store_id;
    }

    public String[] getPizzaArr()
    {
        return this.pizzaArr;
    }

    public String[] getPastaArr()
    {
        return this.pastaArr;
    }

}
