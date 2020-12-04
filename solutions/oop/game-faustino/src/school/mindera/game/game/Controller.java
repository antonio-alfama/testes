package school.mindera.game.game;

import school.mindera.game.exceptions.LoadException;
import school.mindera.game.game.utils.Messages;
import school.mindera.game.game.utils.SaveManager;
import school.mindera.game.player.roles.Druid;
import school.mindera.game.player.roles.Hunter;
import school.mindera.game.player.roles.Mage;
import school.mindera.game.player.roles.Warrior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    private Game game;
    private BufferedReader in;

    public Controller(Game game) {
        this.game = game;
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() {
        System.out.println(Messages.START_MESSAGE);
        System.out.println(Messages.START_OPTIONS);

        switch (this.getInput()) {
            case 1:
                this.playerSelect();
                break;
            case 2:
                this.loadGame();
                break;
            case 3:
                this.exit();
            default:
                System.err.println(Messages.OPTION_ERROR);
                this.start();
        }
    }

    private void loadGame() {
        try {
            System.out.println(Messages.LOAD_GAME);
            game.init(SaveManager.load());
            System.out.println(Messages.LOAD_SUCCESS);
            this.play();
        } catch (LoadException e) {
            System.err.println(e.getMessage() + e.getCause());
            this.start();
        }
    }

    private void playerSelect() {
        System.out.println(Messages.PLAYER_SELECT_MESSAGE);
        System.out.println(Messages.PLAYER_SELECT_OPTIONS);

        switch (this.getInput()) {
            case 1:
                this.game.setPlayer(new Mage());
                break;
            case 2:
                this.game.setPlayer(new Druid());
                break;
            case 3:
                this.game.setPlayer(new Hunter());
                break;
            case 4:
                this.game.setPlayer(new Warrior());
                break;
            default:
                System.err.println(Messages.OPTION_ERROR);
                this.playerSelect();
        }

        game.init();
        this.play();
    }

    private void play() {
        while (this.game.isPlaying()) {
            this.round();
        }

        this.exit();
    }

    private void round() {
        System.out.println(game);
        System.out.println(Messages.ROUND_OPTIONS);

        switch (this.getInput()) {
            case 1:
                game.round(ActionType.ATTACK);
                break;
            case 2:
                game.round(ActionType.CAST_SPELL);
                break;
            case 3:
                game.round(ActionType.HEAL);
                break;
            case 4:
                game.round(ActionType.SPECIAL_ATTACK);
                break;
            case 5:
                game.round(ActionType.RUN);
                break;
            case 6:
                System.out.println(Messages.SAVE_GAME);
                SaveManager.save(game.state());
                break;
            case 7:
                this.exit();
            default:
                System.err.println(Messages.OPTION_ERROR);
                this.round();
        }
    }

    private void exit() {
        System.out.println(Messages.EXIT_MESSAGE);
        System.exit(0);
    }

    private int getInput() {
        System.out.println();

        int option = 0;

        try {
            option = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Please enter a option number.\n");
        }

        return option;
    }

}
