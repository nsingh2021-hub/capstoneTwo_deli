package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;

    public Order() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Summary:\n");

        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }

        sb.append("Total: $").append(getTotal());
        return sb.toString();
    }
}

