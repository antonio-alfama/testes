package hittable;

public interface Hittable {
    public String getType();
    public void getAttacked (int damage);
    public boolean isAlive();
    public void printEnemy();
    public int attack();
}
