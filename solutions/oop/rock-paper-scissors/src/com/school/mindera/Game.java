package com.school.mindera;

public class Game {

    private int numberOfRounds;
    private Player player1;
    private Player player2;

    public Game(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public void start(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        for (int i = 0; i < numberOfRounds; i++) {
            System.out.println("-- ROUND START " + i + " --");

            playRound();
        }

        while (player1.getWins() == player2.getWins()) {
            playRound();
        }

        System.out.println("-- WINNER --");

        System.out.println(player1.getWins() > player2.getWins()
                ? player1.getName() + " WINS!"
                : player2.getName() + " WINS!");

    }

    private void playRound() {
        GameHand player1Hand = player1.chooseHand();
        GameHand player2Hand = player2.chooseHand();

        System.out.println(player1.getName() + " Hand: " + player1Hand);
        System.out.println(player2.getName() + " Hand: " + player2Hand);

        if (player1Hand == player2Hand) {
            System.out.println("It's a draw!");
            return;
        }

        Player winner = player1;

        if (player2Hand == GameHand.PAPER && player1Hand == GameHand.ROCK
                || player2Hand == GameHand.ROCK && player1Hand == GameHand.SCISSORS
                || player2Hand == GameHand.SCISSORS && player1Hand == GameHand.PAPER) {
            winner = player2;
        }

        winner.addWin();
        System.out.println(winner.getName() + " wins!");

    }


}
