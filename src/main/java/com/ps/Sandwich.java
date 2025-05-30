package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Product {
    private int size;
    private String bread;
    private boolean toasted;
    private List<Topping> toppings;

    public Sandwich(int size, String bread) {
        this.size = size;
        this.bread = bread;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    @Override
    public String getName() {
        return size + "\" " + bread + (toasted ? " (Toasted)" : "") + " Sandwich";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size + "\" Sandwich on " + bread);
        if (toasted) sb.append(" (Toasted)");
        else sb.append(" (Not Toasted)");
        sb.append("\nToppings:");
        for (Topping topping : toppings) {
            sb.append("\n- ").append(topping.name);
            if (topping.extra) sb.append(" (Extra)");
        }
        return sb.toString();
    }

    @Override
    public double getPrice() {
        double price = size == 4 ? 5.50 : size == 8 ? 7.00 : 8.50;
        for (Topping topping : toppings) {
            price += topping.getPrice(size);
        }
        return price;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToasted(boolean y) {
    }
}


