package com.ps;

public class Regular extends Topping {
    public Regular(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int size) {
        return 0.0;
    }
}