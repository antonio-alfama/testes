package school.mindera.thousandnights;

import school.mindera.thousandnights.genies.Genie;
import school.mindera.thousandnights.genies.GrumpyGenie;
import school.mindera.thousandnights.genies.HappyGenie;
import school.mindera.thousandnights.genies.RecyclableDemon;

public class Lamp {

    private int capacity;
    private int timesRubbed;
    private int timesRecycled;

    public Lamp(int capacity) {
        this.timesRubbed = 0;
        this.timesRecycled = 0;
        this.capacity = capacity;
    }

    public Genie rub() {

        System.out.println("*** rub ***");
        timesRubbed++;

        int randomNumWishes = (int) ((Math.random() * 10) + 1);

        if (!hasGenies()) {
            return new RecyclableDemon(randomNumWishes);
        }

        return isEven() ? new HappyGenie(randomNumWishes) : new GrumpyGenie(randomNumWishes);

    }

    public void recharge(Genie genie) {

        if (!(genie instanceof RecyclableDemon)) {
            System.out.println("I'm no demon, man. I'm a " + genie + ".");
            return;
        }

        RecyclableDemon demon = (RecyclableDemon) genie;

        if (demon.isRecycled()) {
            System.out.println("No can do. " + demon + " was already recycled.");
            return;
        }

        demon.recycle();
        timesRecycled++;
        timesRubbed = 0;
        System.out.println("The lamp is being recycled by a " + demon + ".");

    }

    private boolean hasGenies() {
        return timesRubbed <= capacity;
    }

    private boolean isEven() {
        return timesRubbed % 2 == 0;
    }

    public boolean equals(Lamp lamp) {
        return this.capacity == lamp.capacity
                && this.timesRubbed == lamp.timesRubbed
                && this.timesRecycled == lamp.timesRecycled;
    }
}
