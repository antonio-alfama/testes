package school.mindera.petreserve;

import school.mindera.petreserve.animals.Animal;
import school.mindera.petreserve.animals.types.AnimalType;

public class Patron {

    private String name;
    private AnimalType preferredAnimal;

    public Patron(String name) {
        this.name = name;
        this.preferredAnimal = AnimalType.values()[(int) (Math.random() * AnimalType.values().length)];
    }

    public void patronize(Animal animal) {
        if (animal.getType() == preferredAnimal) {
            animal.patronize();
        }
    }

    public AnimalType getPreferredAnimal() {
        return preferredAnimal;
    }

    public String getName() {
        return name;
    }
}
