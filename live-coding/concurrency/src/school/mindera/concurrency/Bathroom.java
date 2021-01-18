package school.mindera.concurrency;

public abstract class Bathroom {

    boolean clean;

    public abstract void use() throws InterruptedException;

    public abstract void clean();

}
