package school.mindera.petreserve.animals;

import school.mindera.petreserve.animals.types.AnimalType;

public abstract class Animal {

    private AnimalType type;
    private boolean patronized;

    public Animal(AnimalType type) {
        this.type = type;
    }

    public AnimalType getType() {
        return type;
    }

    public String getGrowl() {
        return type.getGrowl();
    }

    public void patronize() {
        patronized = true;
    }

    public boolean isPatronized() {
        return patronized;
    }
}
