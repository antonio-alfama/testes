package school.mindera.thousandnights.genies;

public class RecyclableDemon extends Genie {

    private boolean recycled;

    public RecyclableDemon(int maxWish) {
        super(maxWish);
        this.recycled = false;
    }

    public boolean isRecycled() {
        return recycled;
    }

    public void recycle() {
        this.recycled = true;
    }

    @Override
    public boolean hasWishesToGrant() {
        return !recycled;
    }

    @Override
    public void grantWish() {

        System.out.println("Sup! Demon here.");

        if (recycled) {
            System.out.println("No can do. I'm already recycled, man.");
            return;
        }

        super.grantWish();

    }
}
