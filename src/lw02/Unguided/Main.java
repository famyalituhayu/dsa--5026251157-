package lw02.Unguided;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> request = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        
        Stack<String[]> failed = new Stack<>();
        LinkedList<String[]> successful = new LinkedList<>();

        final int MAX_BORROW = 2;

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        while (scanner.hasNext()) {
            String[] req = new String[2];
            req[0] = scanner.next();
            req[1] = scanner.next();
            request.add(req);
        }
        scanner.close();

        books.add(new String []{"Kalkulus", "2"});
        books.add(new String []{"Fisika", "1"});
        books.add(new String []{"Statistika", "2"});

        for (String[] req : request) {
                String name = req[0];
                boolean exists = false;

                for (String[] member : members) {
                    if (member[0].equals(name)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    members.add(new String[]{name, "0"});
                }
            }
            for (String[] req : request) {
                queue.add(req);
            }   

            while (!queue.isEmpty()) {
                String[] current = queue.poll();
                String name = current[0];
                String bookTitle = current[1];

                String[] book = null;
                for (String[] b : books) {
                    if (b[0].equals(bookTitle)) {
                        book = b;
                        break;
                    }
                }
                String[] member = null;
                for (String[] m : members) {
                    if (m[0].equals(name)) {
                        member = m;
                        break;
                    }
                }
                int stock = Integer.parseInt(book[1]);
                int borrowed = Integer.parseInt(member[1]);

                if (stock > 0 && borrowed < MAX_BORROW) {
                    book[1] = String.valueOf(stock - 1);
                    member[1] = String.valueOf(borrowed + 1);
                    successful.add(current);
                } else {
                    failed.push(current);
                }
            }
            System.out.println ("=== Successfully Processed Requests ===");
                for (String[] baik : successful) {
                    System.out.println (baik[0] + " " + baik[1]);
                }
             System.out.println ("=== Remaining Book Stock ===");
                for (String[] ok : books) {
                    System.out.println (ok[0] + " " + ok[1]);
                }
             System.out.println("=== Failed Requests ===");
            while (!failed.isEmpty()) {
                String[] ohno = failed.pop();
                System.out.println(ohno[0] + " " + ohno[1]);
            }
        }
    }

