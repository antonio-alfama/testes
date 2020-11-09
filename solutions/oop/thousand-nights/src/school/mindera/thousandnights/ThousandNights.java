package school.mindera.thousandnights;

import school.mindera.thousandnights.genies.Genie;

public class ThousandNights {

    public static void main(String[] args) {

        Lamp aladdin = new Lamp(3);

        Genie[] genies = new Genie[5];

        // after this we populate our array by rubbing the lamp
        System.out.println("\n----- Created a lamp, now rubbing it -----"
                + "\n====================================================");

        for (int i = 0; i < genies.length; i++) {
            genies[i] = aladdin.rub();
        }

        for (Genie genie : genies) {
            aladdin.recharge(genie);
        }

        System.out.println("\n----- Creating a new lamp -----"
                + "\n====================================================");

        // instantiate another lamp
        Lamp willSmith = new Lamp(1);

        // compare the lamps
        System.out.println("The lamps are equal: " + willSmith.equals(aladdin) + "!");

    }

}
