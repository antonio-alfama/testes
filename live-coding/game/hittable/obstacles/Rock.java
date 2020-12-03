package hittable.obstacles;

import player.Player;

import java.util.Random;

public class Rock extends Obstacles{
    private int avoidDamage = 1;

    public int getAvoidDamage() {
        return avoidDamage;
    }
    
    public Rock(){
        super("Rock");
    }

    @Override
    public void reward(Player player) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(3);

        switch (randomNumber){
            case 0:
                player.changeHealthByAmount(2);
                System.out.println("Congratulations you won more 2 life");
                break;
            case 1:
                player.addHealthRechargeCounter();
                System.out.println("Congratulations you won more 1 Health Recharge");
                break;
            case 2:
                player.changeHealthByAmount(-3);
                System.out.println("Ohhhhh -3 life | Don't cry babyyyy");
                break;
            default:
                System.out.println("ERROR!");
        }
    }
}
