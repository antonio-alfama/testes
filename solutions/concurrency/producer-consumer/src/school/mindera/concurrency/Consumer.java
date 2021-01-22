package school.mindera.concurrency;

public class Consumer implements Runnable {

    private int consumedElements;
    private final Container<Integer> queue;

    Consumer(Container<Integer> queue, int consumedElements) {
        this.queue = queue;
        this.consumedElements = consumedElements;
    }

    @Override
    public void run() {

        while (consumedElements > 0) {

            synchronized (queue) {

                // Thread will be blocked until the element is removed from container
                int elem = queue.poll();

                System.out.println("Thread " + Thread.currentThread().getName() + " consumed element " + elem);

                if (queue.getSize() == 0) {
                    System.out.println(Thread.currentThread().getName() + " left the queue empty");
                }

            }

            --consumedElements;

            try {
                Thread.sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                // thread.interrupt called, no handling needed
            }

        }

    }
}
