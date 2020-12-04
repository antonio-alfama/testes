package school.mindera.game.targets.obstacles.entities;

import school.mindera.game.targets.Hittable;
import school.mindera.game.targets.obstacles.ObstacleType;

public abstract class Obstacle implements Hittable {

    private int sustainableDamage;
    private ObstacleType obstacleType;

    public Obstacle(ObstacleType obstacleType) {
        this.obstacleType = obstacleType;
        sustainableDamage = obstacleType.getSustainableDamage();
    }

    @Override
    public boolean isDestroyed() {
        return sustainableDamage <= 0;
    }

    @Override
    public void getHit(int damage) {
        sustainableDamage -= damage;
    }

    @Override
    public String state() {
        return "OBSTACLE" + "\n" + obstacleType + "\n" + sustainableDamage;
    }

    @Override
    public String toString() {
        return obstacleType + " | " + (sustainableDamage > 0 ? sustainableDamage + " 🚧️" : "💥");
    }

    @Override
    public void setDamageLeft(int damageLeft) {
        this.sustainableDamage = damageLeft;
    }
}
