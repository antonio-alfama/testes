package Decorator;

public class SugarAddOn extends AddOn {
    public SugarAddOn(Beverage beverage) {
        super(beverage, "Sugar");
    }

    @Override
    public String getName() {
        return beverage.getName() + " with Sugar";
    }

    @Override
    public double getCost() {
        return 1 + beverage.getCost();
    }
}
