package com.school.mindera;

public class Main {

    public static void main(String[] args) {

        Player player1 = new Player("Ricky");
        Player player2 = new Player("Julian");

        Game game = new Game(6);

        game.start(player1, player2);

        // new Game(6).start(new Player("Diogo Chega Tarde"), new Player("Turma Chega Cedo"));

    }

}
