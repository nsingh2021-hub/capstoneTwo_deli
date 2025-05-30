package com.ps;


public class Chip implements Product {
    private String type;

    public Chip(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return type + " Chips";
    }

    @Override
    public String toString() {
        return "Chips - " + type;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }
}

