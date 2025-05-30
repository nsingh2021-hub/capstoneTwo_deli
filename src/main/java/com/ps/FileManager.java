package com.ps;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
    public static void saveReceipt(String order) {
        String folderName = "receipts";
        File folder = new File(folderName);
        if (!folder.exists() || !folder.isDirectory()) {
            boolean created = folder.mkdir();
            if (!created) {
                System.out.println("Failed to create receipts folder.");
                return;
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = folderName + "/" + LocalDateTime.now().format(formatter) + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(order.toString());
            System.out.println("Receipt saved: " + fileName);
        } catch (IOException e) {
            System.out.println("Could not save receipt.");
        }
    }
}


