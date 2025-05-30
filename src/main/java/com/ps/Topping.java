package com.ps;

public abstract class Topping {
    public boolean extra;
    protected String name;
    protected boolean isExtra;

    public Topping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name + (isExtra ? " (extra)" : "");
    }

    public abstract double getPrice(int size);
}



