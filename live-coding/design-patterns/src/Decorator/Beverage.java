package Decorator;

public abstract class Beverage {
    private String name;

    public Beverage (String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getCost();
}