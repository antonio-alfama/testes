package school.mindera.thousandnights.genies;

public class Genie {

    private int maxWishes;
    private int wishesGranted;

    public Genie(int maxWishes) {
        this.wishesGranted = 0;
        this.maxWishes = maxWishes;
    }

    public int getWishesGranted() {
        return wishesGranted;
    }

    public void grantWish() {

        if (!hasWishesToGrant()) {
            System.out.println("All wishes are already goddam granted.");
            return;
        }

        System.out.println("Wish granted. Enjoy the infinite supply of beer, ma dude!");
        wishesGranted++;

    }

    public boolean hasWishesToGrant() {
        return wishesGranted < maxWishes;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
