package school.mindera.concurrency;

public class Producer implements Runnable {

    private int elementsToProduce;
    private final Container<Integer> queue;

    Producer(Container<Integer> queue, int elementsToProduce) {
        this.queue = queue;
        this.elementsToProduce = elementsToProduce;
    }

    @Override
    public void run() {

        while (elementsToProduce > 0) {

            int elem = (int) (Math.random() * 9);

            synchronized (queue) {

                System.out.println("Thread " + Thread.currentThread().getName() + " added element " + elem);

                // Thread will be blocked until element is added to container
                queue.offer(elem);

                if (queue.getSize() == queue.getLimit()) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " left the queue full");
                }

            }

            --elementsToProduce;

            try {
                Thread.sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                // thread.interrupt called, no handling needed
            }

        }

    }
}
