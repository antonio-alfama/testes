package Decorator;

public class SpecialCoffee extends Beverage{
    public SpecialCoffee () {
        super("Special Coffee");
    }

    @Override
    public double getCost() {
        return 7.5;
    }
}
