package Decorator;

public class HouseCoffee extends Beverage {
    public HouseCoffee () {
        super("House Coffee");
    }

    @Override
    public double getCost() {
        return 5;
    }
}