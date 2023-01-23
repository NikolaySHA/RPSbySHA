import java.util.Random;
import java.util.Scanner;

public class RPSbySHA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] moves = new String[3];
        moves[0] = "Rock";
        moves[1] = "Paper";
        moves[2] = "Scissors";
        int countPlayer = 0;
        int countSHA = 0;
        int countDraw = 0;
        int games = 0;
        String input = "y";
        System.out.println("Hello player, I'm RPSbySHA, a simple console \"Rock, Paper, Scissors\" game.");
        System.out.println("What's your name?");
        String player = scanner.nextLine();
        System.out.printf("OK %s, let's play a game!%n", player);
        while (!"n".equals(input) && !"N".equals(input) && !"No".equals(input) && !"no".equals(input)) {
            System.out.printf("Select one of the following options:%n\"[R]ock\"%n\"[P]aper\"%n" +
                    "\"[S]cissors\"%nPlease write your choice.%n");
            String playerTurn = scanner.nextLine();
            switch (playerTurn) {
                case "Rock", "rock", "R", "r" -> playerTurn = moves[0];
                case "Paper", "paper", "P", "p" -> playerTurn = moves[1];
                case "Scissors", "scissors", "S", "s" -> playerTurn = moves[2];
                default -> {
                    System.out.println("Invalid input.");
                    continue;
                }
            }
            Random random = new Random();
            int index = random.nextInt(moves.length);
            String SHATurn = (moves[index]);
            System.out.printf("Your pick is: %s%nRPSbySHA pick is: %s%n", playerTurn, SHATurn);
            if (playerTurn.equals(moves[0]) && SHATurn.equals(moves[2]) || playerTurn.equals(moves[1]) && SHATurn.equals(moves[0]) ||
                    playerTurn.equals(moves[2]) && SHATurn.equals(moves[1])) {
                countPlayer++;
                System.out.println("Congratulations, you win!");
            }
            else if (playerTurn.equals(moves[2]) && SHATurn.equals(moves[0]) || playerTurn.equals(moves[0]) && SHATurn.equals(moves[1]) ||
                    playerTurn.equals(moves[1]) && SHATurn.equals(moves[2])){
                countSHA++;
                System.out.println("Oh, you lost!");
            }
            else {
                countDraw++;
                System.out.println("The game was a draw!");
            }
            System.out.printf("Do you want to play another round?%n[Y]es or [N]o%nPlease write your choice.%n");
            while (true) {
                input = scanner.nextLine();
                if (input.equals("n") || input.equals("N") || input.equals("no") || input.equals("No") ||
                        input.equals("y") || input.equals("Y") || input.equals("Yes") || input.equals("yes")) {
                    break;
                }
                else {
                    System.out.printf("Invalid input.[Y]es or [N]o%nPlease write your choice.%n");
                }
            } games++;
        }
        if (countPlayer > countSHA) {
            System.out.printf("Congratulations you are the winner!%n%s: %d wins%nRPSbySHA: %d wins%nDraws: %d%n" +
                    "Total games: %d", player, countPlayer, countSHA, countDraw, games);
        }
        else if (countPlayer < countSHA) {
            System.out.printf("I'm sorry but you lost!%n%s: %d wins%nRPSbySHA: %d wins%nDraws:%d%nTotal games: %d"
                    , player, countPlayer, countSHA, countDraw, games);
        }
        else {
            System.out.printf("Wow the game is tie!%n%s: %d wins%nRPSbySHA: %d wins%n%d draws%nTotal games:%d "
                    , player, countPlayer, countSHA, countDraw, games);
        }
    }
}