package lw01.prelab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
    Scanner input = new Scanner (Main.class.getResourceAsStream("jobs.txt"));
    List<PrintJob> JobList = new ArrayList<>(); 
    
    while (input.hasNext()) {
        String type = input.next();
        String id = input.next();
        int pages = input.nextInt();

        PrintJob job; 

        if (type.equals("MONO")) {
            job = new MonoPrint(id, pages);
        } else {
            job = new ColourPrint(id, pages);
        }

        JobList.add(job);
   }

   for (PrintJob job :JobList) {
    System.out.println(job.summary());

   }
   input.close();  
   

}


}






