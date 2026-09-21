package lw01.Unguided;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
    Scanner scanner = new Scanner (Main.class.getResourceAsStream("rentals.txt"));
    int n = scanner.nextInt();
    Rental[] rentals = new Rental[n];
    
    for (int i = 0; i < n; i++) {
        String type = scanner.next();
        String id = scanner.next();
        int days = scanner.nextInt();
        int units = scanner.nextInt();
       
        Rental rental; 
        if (type.equals("LAPTOP")) {
            rental = new LaptopRental(id, days);
        } else {
            rental = new ProjectorRental(id, days);
        }
        scanner.close();
   } catch (FileNotFoundException e) {
        System.out.println("File rentals.txt tidak ditemukan!");
    }
}
}

