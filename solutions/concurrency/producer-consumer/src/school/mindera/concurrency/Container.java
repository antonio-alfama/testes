package school.mindera.concurrency;

import java.util.Deque;
import java.util.LinkedList;

// Our own take on a blocking queue
public class Container<T> {

    final private int limit;

    // Using the interface and not the implementation 👇
    final private Deque<T> list;

    public Container(int limit) {
        this.limit = limit;
        list = new LinkedList<>();
    }

    public synchronized void offer(T i) {

        // Make sure to call wait() when the container is full
        while (list.size() == limit) {

            try {
                wait();
            } catch (InterruptedException e) {
                // thread.interrupt called, no handling needed
            }

        }

        // Add element to the container
        list.add(i);
        System.out.println("## Element added, queue size is " + list.size() + " ##");

        // Notify other threads
        notifyAll();

    }

    public synchronized T poll() {

        // Make sure to call wait() when the container is empty
        while (list.size() == 0) {

            try {
                wait();
            } catch (InterruptedException e) {
                // thread.interrupt called, no handling needed
            }

        }

        // Remove item from the container
        T value = list.removeFirst();
        System.out.println("## Element removed, queue size is " + list.size() + " ##");

        // Notify other threads
        notifyAll();

        return value;

    }

    public synchronized int getSize() {
        return list.size();
    }

    public int getLimit() {
        return limit;
    }

}
