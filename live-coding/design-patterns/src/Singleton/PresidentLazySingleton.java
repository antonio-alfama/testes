package Singleton;

public class PresidentLazySingleton {
    private static PresidentLazySingleton president = null;

    private PresidentLazySingleton() {};

    public static PresidentLazySingleton getPresident() {
        if (president == null) {
            president = new PresidentLazySingleton();
        }

        return president;
    };
}
