1)CREATE ABSTRACT CLASS ENEMY
    Properties:
         - type, life, defenseFactor, attackFactor;
    Methods:
        -printEnemy

2) Create 4 new subclasses from enemy class:
    - Elf (defenseFactor: 12,  attackFactor:12)
    - Dwarf (defenseFactor: 3,  attackFactor:13)
    - Human (defenseFactor: 8,  attackFactor:9)
    - Dragon (defenseFactor: 20,  attackFactor:20)

3) Create EnemyConstructor class. This class will have a function that receives a type of Enemy and will return that Enemy object created with all the information necessary.

4) Create a class Game with the following properties.
    - status (this property represent if game is running or not);
    - stage (each time an enemy is killed the game upgrades this property);
    - enemyTypes (with value: {"Elf", "Dwarf", "Human"});
    - enemies (an array of Enemy type)

5) Add to class Game a startGame function:

    public void startGame();

    This function should populate the enemies property (with size 6) in a random order, but the last enemy should be the dragon (The boss).

6) Create a new class Player with the following properties: health(100), normalAttack(20), specialAttack(50), healthRechargeCounter(3), specialAttackCounter (3),

7) Class Player should implement the following interface:

    public interface PlayerInterface {
        public void getHitted(double hit); //the player is hit and loses health points
        public int rechargeHealth(int health);  //returns player life after recharge and updates healthRechargeCounter
        public int normalAttack();  //returns normalAttack
        public int specialAttack(); // return specialAttack and updates specialAttackCounter
    }

8) Update class game to receive a Player property.

9) Create in class game a function round(). Each round the user can select one off this 5 options (But don't worry about Avoid Enemy for now):

      1: to Attack enemy
      2: to recharge,
      3: to Special Attack
      4: Avoid Enemy
      5: Quit Game

10) Implement the logic where user select Attack option.
    - Enemy loses health points
    - Don't forget about defenseFactor (the enemy can defend partially the hit, for example if user gives a 20 hit, and elf can defend until 12, a dwarf until 3, a human until 8 and a dragon can defend completely the hit, but this must be random)
    - If enemy health life is 0 or less than 0 than player defeat enemy and got a new one (stage property in class game should be updated)
    - Otherwise the enemy is still alive and hit the player (an elf can hit until 12, a dwarf until 13, a human 9 e a dragon until 20)

11) Implement logic where user select recharge

12) The game can end in one off these 3 situations:
    1) User gave up
    2) Players life is 0
    3) Player defeat all enemies


-----------------------------------------------------

1) Create new characters on game: Obstacles
    - Three
    - Rock

2) Obstacles also have a life and can suffer an attack, however an obstacle cannot attack the player.

3) Create a the avoid functionality on the game:
    - If its an enemy then the user receives a messages saying that you cannot avoid the enemy and loses 3 health points
    - If its an obstacle the user avoid the obstacle but loses 1 point for a rock obstacle and 2 health points for a three

4) Create an interface (Hittable) for Obstacles and Enemies

5) Refactor factory to return a Hittable instead of an Enemy

6) If an obstacle is destructed user can receive a bonus or lose health points

    Rock:
       - User wins 2 health points
       - User wins extra health recharge
       - User lost 3 health points

    Three:
       - User wins 4 health points
       - User wins extra special attack recharge
       - User lost 6 health points

7) Change the start game function to create an array of Hittables instead of Enemies. It should be 8 Hittables (3 Objects and 5 Enemies) and the last one should be the dragon.

8) Add the logic to the game to have a magic elf and a drunk dwarf (This should be random)!
    - Drunk dwarfs have a reduction of one point to the attack and defense factor.
    - Magical elf's have an increase of one point to the attack and defense factor.

    Don't forget to change the print function to add this information!


