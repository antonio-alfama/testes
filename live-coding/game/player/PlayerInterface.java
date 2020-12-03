package player;

public interface PlayerInterface {

    void getHitted(double hit);

    int rechargeHealth(int health);

    int normalAttack();

    int specialAttack();

    boolean isAlive();

    int getHealth();

    void printPlayer();
}
