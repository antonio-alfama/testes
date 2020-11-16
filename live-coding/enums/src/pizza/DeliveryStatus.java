package pizza;

public enum DeliveryStatus {
    ORDERED(5) {

        @Override
        public boolean isOrdered() {
            return true;
        }
    },
    READY(2) {

        @Override
        public boolean isReady() {
            return true;
        }
    },
    DELIVERED(0) {
        @Override
        public boolean isDelivered() {
            return true;
        }
    };

    private int timeOfDelivery;

    DeliveryStatus(int timeOfDelivery) {
        this.timeOfDelivery = timeOfDelivery;
    }

    public void printTime() {
        System.out.println(this.timeOfDelivery);
    }

    public boolean isOrdered() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public boolean isDelivered() {
        return false;
    }
}
