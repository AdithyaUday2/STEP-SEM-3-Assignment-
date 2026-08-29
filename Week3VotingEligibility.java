import java.util.Scanner;

public class Week3VotingEligibility {

    static void checkVotingEligibility(int age) {
        boolean canVote = age >= 18;
        if (canVote) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        checkVotingEligibility(age);
        sc.close();
    }
}
