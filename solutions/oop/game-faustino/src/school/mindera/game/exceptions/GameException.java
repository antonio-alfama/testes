package school.mindera.game.exceptions;

public abstract class GameException extends Exception {

    public GameException(String message, Throwable cause) {
        super(message, cause);
    }
}
