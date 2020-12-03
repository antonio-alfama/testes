import hittable.Hittable;
import hittable.Hittables;
import hittable.enemies.*;
import hittable.obstacles.*;
import java.util.Random;

public class HittableFactory {

    public static Hittable createHittable(Hittables enemy) {
        Random rnd = new Random();
        int rndNum = rnd.nextInt(2);

        switch (enemy) {
            case ELF:
                if(rndNum == 1){
                return new Elf("Elf", 12, 12);
                }
                return new Elf("Magical Elf", 13,13);
            case DWARF:
                if(rndNum == 1){
                    return new Dwarf("Dwarf", 3, 13);
                }
                return new Dwarf("Drunk Dwarf", 2, 12);
            case HUMAN:
                return new Human(8, 9);
            case ROCK:
                return new Rock();
            case TREE:
                return new Tree();
            default:
                return new Dragon(20, 20);
        }
    }


}