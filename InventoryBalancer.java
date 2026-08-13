import java.util.Scanner;
public class InventoryBalancer {
    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);
    }
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int n = sectionA.length;
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < n; i++) {
            sumA = sumA + sectionA[i];
            sumB = sumB + sectionB[i];
        }
        String status;
        if (sumA == sumB) {
            status = "Balanced";
        } else {
            status = "Not Balanced";
        }
        int max = sectionA[0];
        String maxSection = "Section A";
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (sectionA[i] > max) {
                max = sectionA[i];
                maxSection = "Section A";
                maxIndex = i;
            }
            if (sectionB[i] > max) {
                max = sectionB[i];
                maxSection = "Section B";
                maxIndex = i;
            }
        }
        System.out.println("Section A Total: " + sumA);
        System.out.println("Section B Total: " + sumB);
        System.out.println("Status: " + status);
        System.out.println("Highest Quantity: " + max + " (" + maxSection + ", Item " + (maxIndex + 1) + ")");
    }
}