package com.example.pizza;

public class Pizza {

    private String name;
    private int imageResourceId;
    int price;
    String provider;

    public static final Pizza[] pizza={
            new Pizza("Diavolo",R.drawable.diavolopizza,100,"Store A"),
            new Pizza("Funghi",R.drawable.funghipizza,150,"Store B"),
            new Pizza("Cheese Burst Pizza",R.drawable.cheeseburstpizza,200,"Store C"),
            new Pizza("Chicago Pizza",R.drawable.chicagopizza,100,"Store A"),
            new Pizza("Neapolitan Pizza",R.drawable.neapolitanpizza,150,"Store B")
    };

    Pizza(String name,int imageResourceId,int price,String provider)
    {
        this.name=name;
        this.imageResourceId=imageResourceId;
        this.price=price;
        this.provider=provider;
    }

    public String getName()
    {
        return name;
    }

    public int getImageResourceId()
    {
        return imageResourceId;
    }

    public int getPrice()
    {
        return price;
    }

    public String getProvider()
    {
        return provider;
    }


}
