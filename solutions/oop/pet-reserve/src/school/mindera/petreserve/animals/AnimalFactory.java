package school.mindera.petreserve.animals;

import school.mindera.petreserve.animals.types.*;

public class AnimalFactory {


    public static Animal createAnimal() {

        AnimalType type = AnimalType.values()[(int) (Math.random() * AnimalType.values().length)];

        switch (type) {
            case LION:
                return new Lion();
            case LEOPARD:
                return new Leopard();
            case ELEPHANT:
                return new Elephant();
            case RHINOCEROS:
                return new Rhinoceros();
            case COCKROACH:
                return new Cockroach();
            default:
                return new CapeBuffalo();
        }
    }
}
