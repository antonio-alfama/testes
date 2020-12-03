package player;

public class Player implements PlayerInterface {
    private int health = 100;
    private int normalAttack = 20;
    private int specialAttack = 50;
    private int healthRechargeCounter = 3;
    private int specialAttackCounter = 3;


    public boolean isAlive(){
        if (health<=0){
            return false;
        }
        return true;
    }

    public int getHealth(){
        return this.health;
    }

    @Override
    public void getHitted(double hit) {
        this.health -= hit;
    }

    @Override
    public int rechargeHealth(int health) {
        if (healthRechargeCounter != 0) {
            this.health += health;
            if ( this.health > 100) {
                this.health = 100;
            }
            healthRechargeCounter--;
        }
        return this.health;
    }

    @Override
    public int normalAttack() {
        return normalAttack;
    }

    @Override
    public int specialAttack() {
        if (specialAttackCounter != 0) {
            specialAttackCounter--;
            return specialAttack;
        }
        return 0;
    }
}
