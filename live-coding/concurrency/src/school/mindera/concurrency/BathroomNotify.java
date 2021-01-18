package school.mindera.concurrency;

public class BathroomNotify extends Bathroom {

    @Override
    public synchronized void use() throws InterruptedException {

        /* synchronized (this) {
          // ... 🔨
        } */

        while(!clean) {
            System.out.println(Thread.currentThread().getName() + " is dirty, waiting for the cleaning sir! 🚽");
            wait();
        }

        System.out.println(Thread.currentThread().getName() + " is using the bathroom! 💩");
        Thread.sleep(3000);

        System.out.println("I'll notify the next user!");
        notify();

    }

    @Override
    public synchronized void clean() {
        clean = true;

        notify();
    }

}
