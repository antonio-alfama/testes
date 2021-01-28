package Decorator;

public abstract class AddOn extends Beverage{
    protected Beverage beverage;

    public AddOn (Beverage beverage, String name) {
        super(name);
        this.beverage = beverage;
    }

    public abstract String getName();
}
