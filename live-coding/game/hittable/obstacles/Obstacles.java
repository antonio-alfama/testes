package hittable.obstacles;

public class Obstacles {
    protected final String type;
    protected double life = 100.00;
    protected final int defenseFactor;
    protected final int attackFactor;

    public Obstacles(String type, int defenseFactor, int attackFactor){
        this.type = type;
        this.defenseFactor = defenseFactor;
        this.attackFactor = attackFactor;
    }

    public void getAttacked(int playerAttack){
        this.life = this.life - playerAttack;
    }
}
