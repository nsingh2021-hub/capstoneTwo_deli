package com.ps;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Product> products = new ArrayList<>();

    public void start() {
        while (true) {
            System.out.println("---Welcome to Nav Sandwich Shop---");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                createNewOrder();
            } else if (input.equals("0")) {
                break;
            }
        }
    }

    private void createNewOrder() {
        products.clear();
        while (true) {
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                addSandwich();
            } else if (input.equals("2")) {
                addDrink();
            } else if (input.equals("3")) {
                addChips();
            } else if (input.equals("4")) {
                checkout();
                break;
            } else if (input.equals("0")) {
                break;
            }
        }
    }

    private void addSandwich() {
        System.out.println("Choose size: 4, 8, or 12");
        int size = Integer.parseInt(scanner.nextLine());

        System.out.println("Choose bread: white, wheat, rye, wrap");
        String bread = scanner.nextLine();

        Sandwich sandwich = new Sandwich(size, bread);

        while (true) {
            System.out.println("Add Topping: Lettuce, Onion, Tomato, Mushrooms, Cucumbers, Pickles (type 'done' to finish):");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            System.out.println("Premium? (y/n):");
            boolean isPremium = scanner.nextLine().equalsIgnoreCase("y");

            System.out.println("Extra? (y/n):");
            boolean isExtra = scanner.nextLine().equalsIgnoreCase("y");

            Topping topping = isPremium ? new Premium(name, isExtra) : new Regular(name, isExtra);
            sandwich.addTopping(topping);
        }

        System.out.println("Toasted? (y/n):");
        sandwich.setToasted(scanner.nextLine().equalsIgnoreCase("y"));

        products.add(sandwich);
    }

    private void addDrink() {
        System.out.println("Enter drink size (Small, Medium, Large):");
        String size = scanner.nextLine();

        System.out.println("Enter drink flavor: Cola, Sprite, Pepsi");
        String flavor = scanner.nextLine();

        products.add(new Drink(size, flavor));
    }

    private void addChips() {
        System.out.println("Enter chip type:BBQ,Lays, Doritos, Cheetos");
        String type = scanner.nextLine();
        products.add(new Chip(type));
    }

    private void checkout() {
        double total = 0;


        for (Product p : products) {
            total += p.getPrice();
        }


        System.out.println("Order Summary:");
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("Total: $" + total);


        Scanner scanner = new Scanner(System.in);
        System.out.print("Confirm order? (y/n): ");
        String confirmation = scanner.nextLine();


        if (confirmation.equalsIgnoreCase("y")) {
            saveReceipt(products, total); // Proceed with saving the receipt
            System.out.println("Receipt saved!");
        } else {
            System.out.println("Order canceled.");
        }
    }


    private void saveReceipt(List<Product> products, double total) {
        StringBuilder receiptContent = new StringBuilder();
        receiptContent.append("Order Summary:\n");

        for (Product p : products) {
            receiptContent.append(p.toString()).append("\n");
        }
        receiptContent.append("Total: $").append(total).append("\n");


        FileManager.saveReceipt(receiptContent.toString());
    }
}


