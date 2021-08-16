package com.example.pizza;

public class Pizza {

    private String name;
    private int imageResourceId;

    public static final Pizza[] pizza={
            new Pizza("Diavolo",R.drawable.diavolopizza),
            new Pizza("Funghi",R.drawable.funghipizza),
            new Pizza("Cheese Burst Pizza",R.drawable.cheeseburstpizza),
            new Pizza("Chicago Pizza",R.drawable.chicagopizza),
            new Pizza("Neapolitan Pizza",R.drawable.neapolitanpizza)
    };

    Pizza(String name,int imageResourceId)
    {
        this.name=name;
        this.imageResourceId=imageResourceId;
    }

    public String getName()
    {
        return name;
    }

    public int getImageResourceId()
    {
        return imageResourceId;
    }
}
