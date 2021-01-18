package school.mindera.concurrency;

public class BathroomRacing {

    public static void main(String[] args) throws InterruptedException {

        Bathroom bathroom = new BathroomNotify();
        // Bathroom bathroom = new BathroomNotifyAll();

        new Thread(new User(bathroom), "Daniel").start();
        new Thread(new User(bathroom), "Vítor").start();
        new Thread(new User(bathroom), "Diogo").start();
        new Thread(new User(bathroom), "Lia").start();
        new Thread(new User(bathroom), "Alfama").start();
        new Thread(new User(bathroom), "Samuel").start();
        new Thread(new User(bathroom), "Luís").start();
        new Thread(new User(bathroom), "Faustino").start();
        new Thread(new User(bathroom), "Tojó").start();

        Thread.sleep(1000);
        System.out.println("\n");
        bathroom.clean();
    }

}
