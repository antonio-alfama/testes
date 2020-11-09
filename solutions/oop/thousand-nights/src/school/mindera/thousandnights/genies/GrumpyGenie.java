package school.mindera.thousandnights.genies;

public class GrumpyGenie extends Genie {

    public GrumpyGenie(int maxWishes) {
        super(maxWishes);
    }

    @Override
    public void grantWish() {

        System.out.println("Hi. I'm Grumpy.");

        if (super.getWishesGranted() > 0) {
            System.out.println("Meh, nope. I only grant one wish.");
            return;
        }

        super.grantWish();

    }
}
