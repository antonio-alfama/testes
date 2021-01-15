package school.mindera.concurrency;

public class BathroomNotifyAll extends Bathroom {

    @Override
    public synchronized void use() throws InterruptedException {

        while (!clean) {
            System.out.println(Thread.currentThread().getName() + " is dirty, waiting for the cleaning sir! 🚽");
            wait();
        }

        System.out.println(Thread.currentThread().getName() + " is using the bathroom! 💩");
        Thread.sleep(3000);

    }

    @Override
    public synchronized void clean() {
        clean = true;

        notifyAll();
    }
}
