import Decorator.Beverage;
import Decorator.ChocolateSprinklesAddOn;
import Decorator.SpecialCoffee;
import Decorator.SugarAddOn;
import Factory.Game;
import Factory.GameFactory;
import Singleton.PresidentLazySingleton;

public class Main {
    public static void main(String[] args) {
        Game myGame = GameFactory.getGame();
        System.out.println("I'm playing a " + myGame.getGameType());

        PresidentLazySingleton myPresident = PresidentLazySingleton.getPresident();
        PresidentLazySingleton yourPresident = PresidentLazySingleton.getPresident();
        System.out.println("My president is " + System.identityHashCode(myPresident) +
                " and your president is " + System.identityHashCode(yourPresident));

        Beverage myBeverage = new SpecialCoffee();
        Beverage myBeverageWithSugar = new SugarAddOn((myBeverage));
        Beverage myBeverageWithSugarAndChocolate = new ChocolateSprinklesAddOn((myBeverageWithSugar));
        System.out.println("I will have a " + myBeverageWithSugarAndChocolate.getName() +
                " for " + myBeverageWithSugarAndChocolate.getCost());
    }
}
