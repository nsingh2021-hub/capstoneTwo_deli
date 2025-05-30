package com.ps;

public class Drink implements Product {
    private String flavor;
    private String size;

    public Drink(String flavor, String size) {
        this.flavor = flavor;
        this.size = size;
    }

    @Override
    public String getName() {
        return size + " " + flavor + " Drink";
    }

    @Override
    public String toString() {
        return size + " Drink - " + flavor;
    }

    @Override
    public double getPrice() {
        return size.equalsIgnoreCase("Small") ? 2.00 :
                size.equalsIgnoreCase("Medium") ? 2.50 : 3.00;
    }
}

