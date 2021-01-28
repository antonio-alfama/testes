package Decorator;

public class ChocolateSprinklesAddOn extends AddOn{
    public ChocolateSprinklesAddOn(Beverage beverage) {
        super(beverage, "Chocolate Sprinkles");
    }

    @Override
    public double getCost() {
        return 3 + beverage.getCost();
    }

    @Override
    public String getName() {
        return beverage.getName() + " with Chocolate Sprinkles";
    }
}
