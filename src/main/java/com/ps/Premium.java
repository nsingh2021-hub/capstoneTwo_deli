package com.ps;

public class Premium extends Topping {
    private boolean isMeat;

    public Premium(String name, boolean isExtra) {
        super(name, isExtra);
        this.isMeat = isMeat;
    }

    @Override
    public double getPrice(int size) {
        double base = isMeat ? (size == 4 ? 1.00 : size == 8 ? 2.00 : 3.00) : (size == 4 ? 0.75 : size == 8 ? 1.50 : 2.25);
        if (isExtra) {
            base += isMeat ? (size == 4 ? 0.50 : size == 8 ? 1.00 : 1.50) : (size == 4 ? 0.30 : size == 8 ? 0.60 : 0.90);
        }
        return base;
    }
}
