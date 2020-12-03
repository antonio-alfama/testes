package player;

public class Player implements PlayerInterface {
    private int health = 100;
    private int normalAttack = 20;
    private int specialAttack = 50;
    private int healthRechargeCounter = 3;
    private int specialAttackCounter = 3;

    public boolean isAlive() {
        if (health <= 0) {
            return false;
        }
        return true;
    }

    public int getHealth() {
        return this.health;
    }

    public int getSpecialAttackCounter() {
        return specialAttackCounter;
    }

    public int getHealthRechargeCounter() {
        return healthRechargeCounter;
    }

    @Override
    public void printPlayer() {
        System.out.println("Your health: " + getHealth());
        System.out.println("Your recharges: " + getHealthRechargeCounter());
        System.out.println("Your special attacks: " + getSpecialAttackCounter());
    }

    @Override
    public void getHitted(double hit) {
        this.health -= hit;
    }

    @Override
    public int rechargeHealth(int health) {
        if (healthRechargeCounter != 0) {
            this.health += health;
            if (this.health > 100) {
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
        System.out.println("0 pah!");
        return 0;
    }

    public void addHealthRechargeCounter() {
        if (healthRechargeCounter != 3) {
            healthRechargeCounter++;
        }
    }

    public void addSpecialAttackCounter() {
        if (specialAttackCounter != 3) {
            specialAttackCounter++;
        }
    }

    public void changeHealthByAmount(int value) {
        this.health += value;
        if (this.health > 100) {
            this.health = 100;
        }
    }
}
