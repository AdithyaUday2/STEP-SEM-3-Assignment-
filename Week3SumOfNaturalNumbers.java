import java.util.Scanner;

public class Week3SumOfNaturalNumbers {

    static void sumOfNaturalNumbers(int n) {
        int counter = 1;
        int total = 0;
        while (counter <= n) {
            total = total + counter;
            counter++;
        }
        System.out.println("Sum of numbers from 1 to " + n + " = " + total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        sumOfNaturalNumbers(n);
        sc.close();
    }
}
