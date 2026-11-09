package lw04.Unguided;
import java.util.*;


public class Main {

    static void sortCards(int[] arr, int passes) {
        for (int i = 0; i < passes; i++) { 
            int minIdx = i; 
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int tempt = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tempt;
        }
    }

    static int findCard(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
   public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));

        int n = sc.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();

        sortCards(cards, 2);

        for (int i = 0; i < n; i++){
            if (i>0) 
                System.out.print(" ");
            System.out.print(cards[i]);
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            int idx = findCard(cards, targets[i]);
            if (idx != -1) {
                System.out.println(targets[i] + ": found at index " + idx);
            } else {
                System.out.println(targets[i] + ": not found");
            }
        }
    }
    
}
