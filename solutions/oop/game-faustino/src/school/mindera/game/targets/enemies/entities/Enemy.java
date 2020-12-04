package school.mindera.game.targets.enemies.entities;

import school.mindera.game.player.Player;
import school.mindera.game.targets.Hittable;
import school.mindera.game.targets.enemies.EnemyType;

public abstract class Enemy implements Hittable {

    private int health;
    private EnemyType enemyType;

    public Enemy(EnemyType enemyType) {
        this.enemyType = enemyType;
        this.health = enemyType.getHealth();
    }

    protected EnemyType getEnemyType() {
        return enemyType;
    }

    protected int getHealth() {
        return health;
    }
    protected void setHealth(int health) {
        this.health = health;
    }

    public void getHit(int damage) {
        health -= damage - (Math.random() * enemyType.getDefenseFactor());
    }

    public void attack(Player player) {
        player.hit(enemyType.getAttackDamage());
    }

    public boolean isDestroyed() {
        return !(health > 0);
    }

    @Override
    public String state() {
        return "ENEMY" + "\n" + enemyType + "\n" + health;
    }

    @Override
    public void setDamageLeft(int damageLeft) {
        this.health = damageLeft;
    }

    @Override
    public String toString() {
        return enemyType + " | " + (health > 0 ? health + " ❤️" : "💀");
    }
}
