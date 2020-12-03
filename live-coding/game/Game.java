import hittable.Hittable;
import hittable.Hittables;
import hittable.obstacles.Obstacles;
import player.Player;
import player.PlayerInterface;

import java.util.Scanner;

public class Game {
    private boolean status = true;
    private int stage = 0;
    private Hittable currentHittable = null;
    private Hittables[] hittables = new Hittables[8];
    private PlayerInterface p = new Player();

    public void startGame() {
        int countEnemies = 4, countObstacles = 3;
        
        for (int i = 0; i < hittables.length - 1; i++) {
            if (countObstacles > 0 && countEnemies == 0) hittables[i] = Hittables.getRandom(new String[]{"obstacles"});
            if (countObstacles == 0 && countEnemies > 0) hittables[i] = Hittables.getRandom(new String[]{"enemy"});
            hittables[i] = Hittables.getRandom(new String[]{"enemy", "obstacle"});
        }

        hittables[hittables.length - 1] = Hittables.DRAGON;

        currentHittable = HittableFactory.createHittable(hittables[0]);

        round();
    }


    public void printEnemies() {
        System.out.println("##########ENEMIES###########");
        for (int i = 0; i < hittables.length; i++) {
            System.out.println(hittables[i]);
        }
    }

    /* normal attack and special attack */
    public void playerAttack(int attack) {
        currentHittable.getAttacked(attack);

        if (!currentHittable.isAlive()) {
            System.out.println("HURRRRA! YOU KILL " + currentHittable.getType());
            stage++;
            if (stage!=hittables.length){
                currentHittable = HittableFactory.createHittable(hittables[stage]);
            }
            return;
        }

        p.getHitted(currentHittable.attack());
    }

    public void round() {
        while (status) {
            p.printPlayer();
            currentHittable.printEnemy();

            System.out.println("***Option 1***: Attack Enemy");
            System.out.println("***Option 2***: Recharge Health");
            System.out.println("***Option 3***: Use Special Attack");
            System.out.println("***Option 4***: Avoid Enemy");
            System.out.println("***Option 5***: Quit Game");
            Scanner scan = new Scanner(System.in);

            switch (scan.nextLine()) {
                case "1":
                    playerAttack(p.normalAttack());
                    break;
                case "2":
                    p.rechargeHealth(20);
                    break;
                case "3": // Special Attack
                    playerAttack(p.specialAttack());
                    break;
                case "4": // Avoid
                    avoidHittable();
                    break;
                case "5": // Quit Game
                    status = false;
                    System.out.println("Game Over");
                    break;
                default:
                    System.out.println("Wrong Option");
                    break;
            }

            isTheGameOver();
        }
    }

    public void isTheGameOver() {
        if (stage >= hittables.length || !p.isAlive()) {
            status = false;
        }
    }

    private void avoidHittable(){
        if (currentHittable instanceof Obstacles){
            p.getHitted(((Obstacles) currentHittable).getAvoidDamage());
            return;
        }
        p.getHitted(3);
        System.out.println("You can't run away!! (get hit for 3 health)");
    }

}



