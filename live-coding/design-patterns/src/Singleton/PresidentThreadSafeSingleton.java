package Singleton;

public class PresidentThreadSafeSingleton {
    private static PresidentThreadSafeSingleton president = null;

    private PresidentThreadSafeSingleton() {};

    public static PresidentThreadSafeSingleton getPresident() {
        if (president == null) {
            synchronized (PresidentThreadSafeSingleton.class) {
                if (president == null) {
                    president = new PresidentThreadSafeSingleton();
                }
            }
        }
        return president;
    };
}
