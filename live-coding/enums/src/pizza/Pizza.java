package pizza;

public class Pizza {

    private DeliveryStatus status;


    public Pizza(DeliveryStatus status){
        this.status = status;
    }

    public void setStatus(DeliveryStatus status){
        this.status = status;
    }


    public DeliveryStatus getPizzaStatus() {
        return this.status;
    }

}