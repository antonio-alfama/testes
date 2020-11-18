package school.mindera.petreserve;

import school.mindera.petreserve.animals.AnimalFactory;
import school.mindera.petreserve.animals.types.AnimalType;

public class Main {

    public static void main(String[] args) {

        PetHouse petHouse = new PetHouse(100);
        petHouse.populate();

        Patron rafa = new Patron("Rafa");
        Patron samuel = new Patron("Samuel");
        Patron tojo = new Patron("Tojo");
        Patron alfama = new Patron("Alfama");

        petHouse.patronize(rafa);

        petHouse.status();

        petHouse.patronize(samuel);

        petHouse.status();

        petHouse.patronize(tojo);

        petHouse.status();

        petHouse.patronize(rafa);

        petHouse.status();

        petHouse.patronize(alfama);

        petHouse.status();
    }

}
