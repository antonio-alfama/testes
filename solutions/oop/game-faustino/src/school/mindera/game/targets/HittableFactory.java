package school.mindera.game.targets;

import school.mindera.game.targets.enemies.EnemyType;
import school.mindera.game.targets.enemies.entities.Dragon;
import school.mindera.game.targets.enemies.entities.Dwarf;
import school.mindera.game.targets.enemies.entities.Elf;
import school.mindera.game.targets.enemies.entities.Human;
import school.mindera.game.targets.obstacles.ObstacleType;
import school.mindera.game.targets.obstacles.entities.Rock;
import school.mindera.game.targets.obstacles.entities.Tree;

public class HittableFactory {

    public static Hittable getHittable() {
        return Math.round(Math.random()) == 0 ? getEnemy() : getObstacle();
    }

    private static Hittable getEnemy() {
        EnemyType enemyType = EnemyType.values()[(int) (Math.random() * EnemyType.values().length)];

        return switch (enemyType) {
            case ELF -> new Elf();
            case DWARF -> new Dwarf();
            default -> new Human();
        };
    }

    public static Hittable getEnemy(EnemyType type) {
        return switch (type) {
            case ELF -> new Elf();
            case DWARF -> new Dwarf();
            case DRAGON -> new Dragon();
            default -> new Human();
        };
    }

    private static Hittable getObstacle() {
        ObstacleType obstacleType = ObstacleType.values()[(int) (Math.random() * ObstacleType.values().length)];

        return getObstacle(obstacleType);
    }

    public static Hittable getObstacle(ObstacleType type) {
        return switch (type) {
            case ROCK -> new Rock();
            default -> new Tree();
        };
    }

    public static Hittable getDragon() {
        return new Dragon();
    }

}
