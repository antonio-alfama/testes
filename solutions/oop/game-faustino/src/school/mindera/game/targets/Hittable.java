package school.mindera.game.targets;

public interface Hittable {

    boolean isDestroyed();

    void getHit(int damage);

    void setDamageLeft(int damageLeft);

    String state();

}
