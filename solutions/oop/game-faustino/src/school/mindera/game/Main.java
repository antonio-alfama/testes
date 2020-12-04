package school.mindera.game;

import school.mindera.game.game.Controller;
import school.mindera.game.game.Game;

public class Main {

    public static void main(String[] args) {
        new Controller(new Game()).start();
    }

}
