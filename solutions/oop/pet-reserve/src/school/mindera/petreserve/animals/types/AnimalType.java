package school.mindera.petreserve.animals.types;

public enum AnimalType {
    LION("RAWWWWRRRR"),
    LEOPARD("MIAAUUU"),
    ELEPHANT("PHAHAH"),
    COCKROACH("TickTickTickTick"),
    RHINOCEROS("RHINO RHINO????"),
    CAPE_BUFFALO("BRRRRRRRUFFFFFFF");

    private String growl;

    AnimalType(String growl) {
        this.growl = growl;
    }

    public String getGrowl() {
        return growl;
    }
}
