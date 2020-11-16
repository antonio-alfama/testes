package pizza;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza(DeliveryStatus.ORDERED);
        System.out.println(pizza.getPizzaStatus().isOrdered());
        pizza.getPizzaStatus().printTime();

        pizza.setStatus(DeliveryStatus.READY);

        System.out.println(pizza.getPizzaStatus().isReady());
        pizza.getPizzaStatus().printTime();
    }
}
