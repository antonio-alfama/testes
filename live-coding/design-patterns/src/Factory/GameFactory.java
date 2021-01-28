package Factory;

import java.util.Random;

public class GameFactory {
    public static Game getGame() {
        if (new Random().nextBoolean()) {
            return new Game("FPS");
        } else {
            return new Game ("RPG");
        }
    }
}
