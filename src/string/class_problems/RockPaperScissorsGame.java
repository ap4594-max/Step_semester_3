package string.class_problems;

import java.util.Random;

/**
 * Problem 1: Rock-Paper-Scissors Game
 * Scenario: The College Coding Arcade
 * 
 * Simulates a multi-round Rock-Paper-Scissors match between a player and the computer.
 * Computes round winners, displays a round-by-round summary table, and calculates
 * the overall scoreboard including wins, losses, draws, and win percentage.
 */
public class RockPaperScissorsGame {

    public static final String ROCK = "Rock";
    public static final String PAPER = "Paper";
    public static final String SCISSORS = "Scissors";

    private static final String[] CHOICES = {ROCK, PAPER, SCISSORS};
    private static final Random RANDOM = new Random();

    /**
     * Determines the winner of a single round of Rock-Paper-Scissors.
     * 
     * @param playerMove   the move made by the player
     * @param computerMove the move made by the computer
     * @return "Player Wins", "Computer Wins", or "Draw"
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            return "Invalid Move";
        }

        String pMove = normalizeMove(playerMove);
        String cMove = normalizeMove(computerMove);

        if (pMove.equalsIgnoreCase(cMove)) {
            return "Draw";
        }

        if ((pMove.equalsIgnoreCase(ROCK) && cMove.equalsIgnoreCase(SCISSORS)) ||
            (pMove.equalsIgnoreCase(PAPER) && cMove.equalsIgnoreCase(ROCK)) ||
            (pMove.equalsIgnoreCase(SCISSORS) && cMove.equalsIgnoreCase(PAPER))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    /**
     * Generates a random move for the computer.
     * 
     * @return "Rock", "Paper", or "Scissors"
     */
    public static String getComputerMove() {
        int index = RANDOM.nextInt(CHOICES.length);
        return CHOICES[index];
    }

    /**
     * Helper method to standardize move names for clean output.
     */
    public static String normalizeMove(String move) {
        if (move == null) return "";
        String trimmed = move.trim();
        if (trimmed.equalsIgnoreCase("rock") || trimmed.equalsIgnoreCase("r")) return ROCK;
        if (trimmed.equalsIgnoreCase("paper") || trimmed.equalsIgnoreCase("p")) return PAPER;
        if (trimmed.equalsIgnoreCase("scissors") || trimmed.equalsIgnoreCase("s")) return SCISSORS;
        return trimmed;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("         College Coding Arcade: Rock-Paper-Scissors");
        System.out.println("==================================================");

        int totalRounds = 5;
        String[] playerMoves = new String[totalRounds];
        String[] computerMoves = new String[totalRounds];
        String[] roundResults = new String[totalRounds];

        // Predefined moves for live demo if no interactive console input is passed
        String[] demoPlayerMoves = {ROCK, PAPER, SCISSORS, ROCK, PAPER};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < totalRounds; i++) {
            playerMoves[i] = demoPlayerMoves[i];
            computerMoves[i] = getComputerMove();
            roundResults[i] = playRound(playerMoves[i], computerMoves[i]);

            if (roundResults[i].equals("Player Wins")) {
                wins++;
            } else if (roundResults[i].equals("Computer Wins")) {
                losses++;
            } else if (roundResults[i].equals("Draw")) {
                draws++;
            }

            System.out.printf("Round %d - Player: %s, Computer: %s -> %s%n", 
                    (i + 1), playerMoves[i], computerMoves[i], roundResults[i]);
        }

        // Summary Table
        System.out.println("\n--------------------------------------------------");
        System.out.printf("%-8s | %-12s | %-14s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-8d | %-12s | %-14s | %-15s%n", 
                    (i + 1), playerMoves[i], computerMoves[i], roundResults[i]);
        }
        System.out.println("--------------------------------------------------");

        // Final Scoreboard
        double winPercentage = (totalRounds > 0) ? ((double) wins / totalRounds) * 100.0 : 0.0;
        System.out.printf("Final Summary (after %d rounds) Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                totalRounds, wins, losses, draws, winPercentage);
        System.out.println("==================================================");
    }
}
