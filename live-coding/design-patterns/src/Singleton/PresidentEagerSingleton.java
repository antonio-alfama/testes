package Singleton;

public class PresidentEagerSingleton {
    private static PresidentEagerSingleton president = new PresidentEagerSingleton();

    private PresidentEagerSingleton() { };

    public static PresidentEagerSingleton getPresident() {
        return president;
    }
}
