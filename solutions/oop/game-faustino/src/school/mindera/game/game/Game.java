package school.mindera.game.game;

import school.mindera.game.exceptions.LoadException;
import school.mindera.game.game.utils.Variables;
import school.mindera.game.player.Player;
import school.mindera.game.player.PlayerType;
import school.mindera.game.player.roles.Druid;
import school.mindera.game.player.roles.Hunter;
import school.mindera.game.player.roles.Mage;
import school.mindera.game.player.roles.Warrior;
import school.mindera.game.targets.Hittable;
import school.mindera.game.targets.HittableFactory;
import school.mindera.game.targets.enemies.EnemyType;
import school.mindera.game.targets.enemies.entities.Dwarf;
import school.mindera.game.targets.enemies.entities.Elf;
import school.mindera.game.targets.enemies.entities.Enemy;
import school.mindera.game.targets.obstacles.ObstacleType;
import school.mindera.game.targets.obstacles.entities.Obstacle;
import school.mindera.game.targets.obstacles.entities.Rock;
import school.mindera.game.targets.obstacles.entities.Tree;

import java.util.Arrays;

public class Game {

    private boolean playing;
    private int numberOfRounds;
    private int currentHittableIndex;

    private Player player;
    private Hittable[] hittables;

    public Game() {
        this.playing = false;
        this.numberOfRounds = 1;
        this.currentHittableIndex = 0;
        this.hittables = new Hittable[Variables.NUMBER_OF_HITTABLES];
    }

    protected boolean isPlaying() {
        return playing;
    }

    protected void setPlayer(Player player) {
        this.player = player;
    }

    protected void init() {
        this.playing = true;

        for (int i = 0; i < this.hittables.length; i++) {
            this.hittables[i] = HittableFactory.getHittable();
        }

        this.hittables[this.hittables.length - 1] = HittableFactory.getDragon();
    }

    public void init(String loadedSave) throws LoadException {

        int currentIndex = 0;
        String[] data = loadedSave.split("\\r?\\n");

        this.playing = true;

        try {
            for (int i = 0; i < data.length; i++) {
                switch (data[i]) {
                    case "ROUND" -> {
                        this.numberOfRounds = Integer.parseInt(data[i + 1]);

                        i++;
                    }
                    case "PLAYER" -> {
                        switch (PlayerType.valueOf(data[i + 1])) {
                            case MAGE -> player = new Mage();
                            case DRUID -> player = new Druid();
                            case HUNTER -> player = new Hunter();
                            case WARRIOR -> player = new Warrior();
                        }
                        player.setHealth(Integer.parseInt(data[i + 2]));
                        player.setNumberOfHeals(Integer.parseInt(data[i + 3]));
                        player.setNumberOfSpecialAttacks(Integer.parseInt(data[i + 4]));

                        i += 4;
                    }
                    case "OBSTACLE" -> hittables[currentIndex] =
                            HittableFactory.getObstacle(ObstacleType.valueOf(data[i + 1]));
                    case "ENEMY" -> {
                        hittables[currentIndex] = HittableFactory.getEnemy(EnemyType.valueOf(data[i + 1]));

                        if (i + 3 < hittables.length - 1 && (data[i + 3].equals("MAGIC") || data[i + 3].equals("DRUNK"))) {
                            if (hittables[currentIndex] instanceof Elf) {
                                ((Elf) hittables[currentIndex]).learnMagic();
                            }

                            if (hittables[currentIndex] instanceof Dwarf) {
                                ((Dwarf) hittables[currentIndex]).drink();
                            }
                        }
                    }
                }

                if (currentIndex < hittables.length && hittables[currentIndex] != null) {
                    hittables[currentIndex].setDamageLeft(Integer.parseInt(data[i + 2]));
                    currentIndex++;
                }
            }
        } catch (Exception ex) {
            throw new LoadException(ex);
        }

        for (Hittable hittable : hittables) {
            if (hittable.isDestroyed()) {
                currentHittableIndex++;
            }
        }
    }

    protected void round(ActionType actionType) {
        numberOfRounds++;

        switch (actionType) {
            case ATTACK -> player.attack(hittables[currentHittableIndex]);
            case CAST_SPELL -> player.castSpell(hittables[currentHittableIndex]);
            case SPECIAL_ATTACK -> player.specialAttack(hittables[currentHittableIndex]);
            case HEAL -> player.heal();
            case RUN -> {
                handleAttemptToRun();
                return;
            }
        }

        if (hittables[currentHittableIndex].isDestroyed()) {
            System.out.println(hittables[currentHittableIndex] + "\n");

            if (currentHittableIndex == hittables.length - 1) {
                System.out.println("-- Player WINS! --");
                this.playing = false;
                return;
            }

            if (hittables[currentHittableIndex] instanceof Obstacle) {
                handleObstacleDestruction();
            }

            currentHittableIndex++;
            return;
        }

        if (hittables[currentHittableIndex] instanceof Enemy) {
            ((Enemy) hittables[currentHittableIndex]).attack(player);
        }


        if (!(player.isAlive())) {
            System.out.println(player);
            this.playing = false;
        }

    }

    private void handleAttemptToRun() {
        if (hittables[currentHittableIndex] instanceof Enemy) {
            player.hit(Variables.RUN_FROM_ENEMY_DAMAGE);
        }

        if (hittables[currentHittableIndex] instanceof Tree) {
            player.hit(Variables.RUN_FROM_TREE_DAMAGE);
        }

        if (hittables[currentHittableIndex] instanceof Rock) {
            player.hit(Variables.RUN_FROM_ROCK_DAMAGE);
        }
    }

    private void handleObstacleDestruction() {
        boolean shouldReceiveBonus = Math.round(Math.random()) == 1;

        if (hittables[currentHittableIndex] instanceof Tree) {
            if (!shouldReceiveBonus) {
                player.hit(Variables.TREE_DESTRUCTION_HEALTH_PENALTY);
                return;
            }

            player.heal(Variables.TREE_DESTRUCTION_HEALTH_BONUS);
            player.rechargeSpecialAttack();
        }

        if (hittables[currentHittableIndex] instanceof Rock) {
            if (!shouldReceiveBonus) {
                player.hit(Variables.ROCK_DESTRUCTION_HEALTH_PENALTY);
                return;
            }

            player.heal(Variables.ROCK_DESTRUCTION_HEALTH_BONUS);
            player.rechargeHeal();
        }
    }

    public String state() {
        StringBuilder state = new StringBuilder("ROUND")
                .append("\n")
                .append(this.numberOfRounds)
                .append("\n")
                .append("PLAYER")
                .append("\n")
                .append(player.state())
                .append("\n");

        for (Hittable hittable : hittables) {
            state.append(hittable.state()).append("\n");
        }

        return state.toString();
    }

    @Override
    public String toString() {
        return "Current Round: " + numberOfRounds + " | " + Arrays.toString(hittables)
                + "\n\nPlayer Status: " + player
                + "\nCurrent Target Status: " + hittables[currentHittableIndex] + "\n";
    }


}
