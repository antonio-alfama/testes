package hittable.enemies;

public class Enemy {
    protected String type;
    protected double life = 100.00;
    protected final int defenseMax;
    protected final int attackMax;

    public Enemy(String type, int defenseMax, int attackMax){
        this.type = type;
        this.defenseMax = defenseMax;
        this.attackMax = attackMax;
    }


    public void printEnemy(){
        System.out.println("Type: " + type + "\n Life:" + life);
    }

    public String getType(){
        return this.type;
    }

    public int attack() { /* 0 a attackFactor */
        return (int) (Math.random() * attackMax);
    }

    public double getAttacked (int damage) {
        int batatas = (int) (Math.random() * defenseMax); /* 0 a defenseFactor */
        this.life = this.life - damage + batatas;
        return life;
     }


     public boolean isAlive (){
        return life > 0 ? true : false;
     }






}


