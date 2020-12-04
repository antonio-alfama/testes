package school.mindera.game.player;

import school.mindera.game.game.utils.Variables;
import school.mindera.game.targets.Hittable;

public abstract class Player {

    private int health;
    private int numberOfHeals;
    private int numberOfSpecialAttacks;
    private final PlayerType playerType;

    public Player(PlayerType playerType) {
        this.playerType = playerType;
        this.health = playerType.getHealth();
        this.numberOfHeals = playerType.getNumberOfHeals();
        this.numberOfSpecialAttacks = playerType.getNumberOfSpecialAttacks();
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setNumberOfHeals(int numberOfHeals) {
        this.numberOfHeals = numberOfHeals;
    }

    public void setNumberOfSpecialAttacks(int numberOfSpecialAttacks) {
        this.numberOfSpecialAttacks = numberOfSpecialAttacks;
    }

    public void hit(int damage) {
        this.health -= damage;
    }

    public void heal() {
        if(numberOfHeals < 0) {
            return;
        }

        this.health = this.playerType.getHealth();

        this.numberOfHeals--;
    }

    public void heal(int amount) {
        this.health += amount;
    }

    public void attack(Hittable hittable) {
        hittable.getHit(this.playerType.getAttackDamage());
    }

    public void castSpell(Hittable hittable) {
        hittable.getHit(this.playerType.getSpellDamage());
    }

    public void specialAttack(Hittable hittable) {
        if(numberOfSpecialAttacks < 0) {
            return;
        }

        hittable.getHit(this.playerType.getAttackDamage() > this.playerType.getSpellDamage()
                ? this.playerType.getAttackDamage() * Variables.SPECIAL_ATTACK_FACTOR
                : this.playerType.getSpellDamage() * Variables.SPECIAL_ATTACK_FACTOR);

        this.numberOfSpecialAttacks--;
    }

    public void rechargeHeal() {
        numberOfHeals++;
    }

    public void rechargeSpecialAttack() {
        numberOfSpecialAttacks++;
    }

    public String state() {
        return playerType + "\n" + health + "\n" + numberOfHeals + "\n" + numberOfSpecialAttacks;
    }

    @Override
    public String toString() {
        return isAlive() ? playerType + " | " + health + " ❤️ | Heals Remaining: "
                + numberOfHeals + " | " + "Special Attacks: "
                + numberOfSpecialAttacks : "-- Player is 💀 --";
    }


}
