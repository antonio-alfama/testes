package hittable.obstacles;

import hittable.Hittable;
import player.Player;
import player.PlayerInterface;

import java.util.Random;

public abstract class Obstacles implements Hittable {
    protected final String type;
    protected int life = 100;

    public Obstacles(String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public double getLife() {
        return life;
    }

    public void getAttacked(int playerAttack) {
        this.life = this.life - playerAttack;
    }

    public boolean isAlive() {
        return life > 0 ? true : false;
    }

    @Override
    public void printEnemy() {
        System.out.println("Type: " + type + "\n Life:" + life);

    }
    @Override
    public int attack() {
        return 0;
    }
    
    public abstract int getAvoidDamage();
    public abstract void reward(Player player);
}
