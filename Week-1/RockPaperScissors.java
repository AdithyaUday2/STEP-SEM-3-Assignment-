import java.util.*;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove))
            return "Draw";

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        String[][] table = new String[5][3];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Round " + (i + 1) + " - Enter Rock, Paper or Scissors: ");
            String player = sc.next();

            String computer = moves[random.nextInt(3)];
            String result = playRound(player, computer);

            table[i][0] = player;
            table[i][1] = computer;
            table[i][2] = result;

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        System.out.println("\nFinal Summary");
        System.out.println("Round\tPlayer\tComputer\tResult");

        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "\t" + table[i][0] + "\t" +
                               table[i][1] + "\t\t" + table[i][2]);
        }

        double winPercentage = (wins / 5.0) * 100;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");
    }
}
