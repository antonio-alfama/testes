package school.mindera.petreserve;

import school.mindera.petreserve.animals.Animal;
import school.mindera.petreserve.animals.AnimalFactory;

public class PetHouse {

    private Animal[] animals;

    public PetHouse(int capacity) {
        this.animals = new Animal[capacity];
    }

    public void populate() {
        for (int i = 0; i < animals.length; i++) {
            animals[i] = AnimalFactory.createAnimal();
        }
    }

    public void patronize(Patron patron) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i].isPatronized()) {
                continue;
            }
            if (animals[i].getType() != patron.getPreferredAnimal()) {
                continue;
            }

            System.out.println(patron.getName() + " patronized a " + animals[i].getType().name());
            System.out.println(animals[i].getGrowl() + "\n");

            patron.patronize(animals[i]);
            return;
        }
    }

    public void status() {
        int counter = 0;

        for (int i = 0; i < animals.length; i++) {
            if (animals[i].isPatronized()) {
                counter ++;
            }
        }

        System.out.println("-- " + counter + " animal" + (counter > 1 ? "s" : "") + " patronized --");
    }
}
