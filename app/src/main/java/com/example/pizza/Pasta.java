package com.example.pizza;

public class Pasta {

    private String name;
    private  int id;

    public static final Pasta[] pastas={
            new Pasta("Cheeseburger Pasta",R.drawable.cheeseburgerpasta),
            new Pasta("Creamy Pesto Mac with Spinnach",R.drawable.creemypestomacwithspinach),
            new Pasta("Green Chille and Cheese",R.drawable.greenchilleandcheesepasta),
            new Pasta("Lemon Parsley Pasta",R.drawable.lemonparslypasta),
            new Pasta("Summer Vegetable Pasta",R.drawable.summervegetablepasta)
    };

    Pasta(String name,int id)
    {
        this.name=name;
        this.id=id;
    }

    public String getName()
    {
        return this.name;
    }

    public int getImageResourceId()
    {
        return this.id;
    }
}
