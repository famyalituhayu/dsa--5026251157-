package lw03.prelab;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        problem1();
        problem2();
        problem3();
    }

    static void problem1() throws Exception {
        System.out.println("===== Problem 1 =====");
        List<String> playlist = new ArrayList<>();

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            if (line.startsWith("ADD ")) {
                String song = line.substring(4).trim();
                playlist.add(song);
            } else if (line.startsWith("INSERT ")) {
                String[] parts = line.split(" ", 3);
                int index = Integer.parseInt(parts[1]);
                String song = parts[2].trim();
                playlist.add(index, song);
            } else if (line.startsWith("REMOVE ")) {
                String song = line.substring(7).trim();
                playlist.remove(song);
            }
        }
        scanner.close();

        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
        System.out.println();
    }

    static void problem2() throws Exception {
        System.out.println("===== Problem 2 =====");
        Set<String> participants = new LinkedHashSet<>();
        int duplicate = 0;

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        while (scanner.hasNextLine()) {
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) continue;

            if (!participants.add(name)) {
                duplicate++;
            }
        }
        scanner.close();

        System.out.println("Unique participants: " + participants.size());
        int no = 1;
        for (String name : participants) {
            System.out.println(no + ". " + name);
            no++;
        }
        System.out.println("Duplicate registrations: " + duplicate);
        System.out.println();
    }

    static void problem3() throws Exception {
        System.out.println("===== Problem 3 =====");
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ");
            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (type.equals("ADD")) {
                inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
            } else if (type.equals("SELL")) {
                if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                    inventory.put(product, inventory.get(product) - quantity);
                } else {
                    failedSales++;
                }
            }
        }
        scanner.close();

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + failedSales);
    }
}
