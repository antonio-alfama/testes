package hittable;

import java.util.ArrayList;
import java.util.Arrays;

public enum Hittables {
    DRAGON("boss"),
    HUMAN("enemy"),
    DWARF("enemy"),
    ELF("enemy"),
    ROCK("obstacle"),
    TREE("obstacle");

    private final String type;

    Hittables(String type) {
        this.type = type;
    }

    public static Hittables getRandom(String[] type) {
        Hittables[] random = getAllByType(type);

        return random[(int) (Math.random() * random.length)];
    }

    public static Hittables[] getAllByType(String[] types) {
        ArrayList<Hittables> enemies = new ArrayList<>();
        for (Hittables e : Hittables.values()) {
            if (Arrays.asList(types).contains(e.type)) {
                enemies.add(Hittables.valueOf(e.name()));
            }
        }
        return enemies.toArray(new Hittables[0]);
    }

}
