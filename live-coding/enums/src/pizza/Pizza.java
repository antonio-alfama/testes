package pizza;

public class Pizza {

    private PizzaStatus status;

    public enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }

    public Pizza(){
    }


    public PizzaStatus getPizzaStatus(){
        return this.status;
    }

}
