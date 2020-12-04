package school.mindera.game.exceptions;

import school.mindera.game.game.utils.Messages;

public class LoadException extends GameException {

    public LoadException(Throwable cause) {
        super(Messages.LOAD_EXCEPTION, cause);
    }

}
