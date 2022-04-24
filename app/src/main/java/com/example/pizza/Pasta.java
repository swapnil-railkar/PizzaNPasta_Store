package com.example.pizza;

public class Pasta {

    private String name;
    private  int id;
    int price;
    String provider;

    public static final Pasta[] pastas={
            new Pasta("Cheeseburger Pasta",R.drawable.cheeseburgerpasta,100,"Store B"),
            new Pasta("Creamy Pesto Mac with Spinnach",R.drawable.creemypestomacwithspinach,150,"Store C"),
            new Pasta("Green Chille and Cheese",R.drawable.greenchilleandcheesepasta,200,"Store A"),
            new Pasta("Lemon Parsley Pasta",R.drawable.lemonparslypasta,100,"Store B"),
            new Pasta("Summer Vegetable Pasta",R.drawable.summervegetablepasta,150,"Store C")
    };

    Pasta(String name,int imageResourceId,int price,String provider)
    {
        this.name=name;
        this.id=imageResourceId;
        this.price=price;
        this.provider=provider;
    }

    public String getName()
    {
        return this.name;
    }

    public int getImageResourceId()
    {
        return this.id;
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
