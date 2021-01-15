package school.mindera.concurrency;

public class User implements Runnable {

    private Bathroom bathroom;

    public User(Bathroom bathroom) {
        this.bathroom = bathroom;
    }

    @Override
    public void run() {
        try {
            bathroom.use();
        } catch (InterruptedException e) {
            // hello darkness...
        }
    }
}
