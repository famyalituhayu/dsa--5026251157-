package lw03.Unguided;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> enrollments = new HashMap<>();
        List<String> courseOrder = new ArrayList<>();
        List<String> checkResults = new ArrayList<>();
        int rejected = 0;

        // Cara lebih aman: cari file di folder yang sama dengan Main.class
        Scanner scanner = new Scanner(
            new File(Main.class.getResource("enrollment.txt").toURI())
        );

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ");
            String operation = parts[0];

            if (operation.equals("REGISTER")) {
                String course = parts[1];
                int count = Integer.parseInt(parts[2]);

                if (count <= 0) {
                    rejected++;
                    continue;
                }

                if (!enrollments.containsKey(course)) {
                    enrollments.put(course, count);
                    courseOrder.add(course);
                } else {
                    int current = enrollments.get(course);
                    enrollments.put(course, current + count);
                }

            } else if (operation.equals("WITHDRAW")) {
                String course = parts[1];
                int count = Integer.parseInt(parts[2]);

                if (count <= 0) {
                    rejected++;
                    continue;
                }

                if (!enrollments.containsKey(course) || enrollments.get(course) < count) {
                    rejected++;
                    continue;
                }

                int current = enrollments.get(course);
                enrollments.put(course, current - count);

            } else if (operation.equals("CHECK")) {
                String course = parts[1];

                if (enrollments.containsKey(course)) {
                    checkResults.add(course + ": " + enrollments.get(course) + " students");
                } else {
                    checkResults.add(course + ": Not found");
                }
            }
        }
        scanner.close();

        // ===== Output =====
        System.out.println("===== Enrollment Checks =====");
        for (int i = 0; i < checkResults.size(); i++) {
            System.out.println(checkResults.get(i));
        }

        System.out.println();
        System.out.println("===== Final Enrollment =====");
        for (int i = 0; i < courseOrder.size(); i++) {
            String course = courseOrder.get(i);
            System.out.println(course + ": " + enrollments.get(course) + " students");
        }

        System.out.println();
        System.out.println("Rejected operations: " + rejected);
    }
}