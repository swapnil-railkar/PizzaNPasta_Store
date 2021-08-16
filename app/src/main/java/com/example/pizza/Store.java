package com.example.pizza;

public class Store {

    private int store_id;
    private String name;

    public static final Store[] stores={
            new Store("Store A",R.drawable.stored),
            new Store("Store B",R.drawable.storea),
            new Store("Store C",R.drawable.storec)
    };
    Store(String name,int store_id)
    {
        this.name=name;
        this.store_id=store_id;
    }

    public String getName()
    {
        return this.name;
    }

    public int getImageId()
    {
        return this.store_id;
    }
}
