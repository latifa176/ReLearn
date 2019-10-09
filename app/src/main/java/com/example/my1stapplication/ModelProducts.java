package com.example.my1stapplication;

public class ModelProducts {

    private String coursename ;
    private int price;

    public ModelProducts(String coursename,int price)
    {
        this.coursename  = coursename;
        this.price = price;
    }

    public String getProductName() {

        return coursename;
    }

    public int getProductPrice() {

        return price;
    }

}
