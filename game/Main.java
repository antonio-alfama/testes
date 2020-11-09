package EdgarGame;

import EdgarGame.Enemies.Enemy;

public class Main {
    public static void main(String[] args) {

        Enemy elf = EnemyFactory.createEnemy("Elf");
        Enemy dwarf = EnemyFactory.createEnemy("Dwarf");
        Enemy human = EnemyFactory.createEnemy("Human");
        Enemy dragon = EnemyFactory.createEnemy("Dragon");

    }
}




