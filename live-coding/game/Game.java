import hittable.enemies.Enemy;

import player.PlayerInterface;
import player.Player;

import java.util.Scanner;

public class Game{
    private boolean status = true;
    private int stage = 0;/* REPRESENTA O INIMIGO QUE ESTAMOS A ENFRENTAR */
    private String[] enemyTypes = new String[] {"Elf", "Dwarf", "Human"};
    private Enemy[] enemies = new Enemy[6];
    private PlayerInterface p = new Player();

    public void startGame(){

        for(int i = 0; i < this.enemies.length - 1; i++){
            int randomNumber = (int) (Math.random() * 3);

            this.enemies[i] = EnemyFactory.createEnemy(enemyTypes[randomNumber]);
        }

        this.enemies[this.enemies.length - 1] = EnemyFactory.createEnemy("Dragon");
        this.printEnemies();

    }

    public void printEnemies(){
        System.out.println("##########ENEMIES###########");
        for(int i = 0; i < enemies.length; i++){
            System.out.println(enemies[i].getType());
        }
    }

    public void playerAttack(int attack){
        enemies[stage].getAttacked(attack);

        if(!enemies[stage].isAlive()){
            System.out.println("HURRRRA! YOU KILL " + enemies[stage].getType());
            stage++;
            return;
        }

        p.getHitted(enemies[stage].attack());
    }

    public void round(){
        while(status){
            System.out.println("***Option 1***: Attack Enemy");
            System.out.println("***Option 2***: Recharge Health");
            System.out.println("***Option 3***: Use Special Attack");
            System.out.println("***Option 4***: Avoid Enemy");
            System.out.println("***Option 5***: Quit Game");
            Scanner scan = new Scanner(System.in);

            switch(scan.nextLine()){
                case "1":
                   this.playerAttack(p.normalAttack());
                   break;
                case "2:":
                    p.rechargeHealth(20);
                    break;

                case "3": // Special Attack
                    break;

                case "4": // Avoid
                    break;

                case "5": // Quit Game
                    status = false;
                    System.out.println("Game Over");
                    break;

                default:
                    System.out.println("Wrong Option");
                    break;
            }

            this.isTheGameOver();
    }
}

    public void isTheGameOver(){
        if(stage >= enemies.length || p.isAlive()){
            status = false;
        }
    }

}



