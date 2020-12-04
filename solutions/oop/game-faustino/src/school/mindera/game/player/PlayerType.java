package school.mindera.game.player;

public enum PlayerType {
    MAGE(80, 10, 50, 2, 5),
    DRUID(120, 20, 30, 6, 2),
    HUNTER(150, 40, 10, 2, 3),
    WARRIOR(200, 50, 5, 1, 3);

    private int health;
    private int attackDamage;
    private int spellDamage;
    private int numberOfHeals;
    private int numberOfSpecialAttacks;

    PlayerType(int health, int attack, int spell, int numberOfHeals, int numberOfSpecialAttacks) {
        this.health = health;
        this.attackDamage = attack;
        this.spellDamage = spell;
        this.numberOfHeals = numberOfHeals;
        this.numberOfSpecialAttacks = numberOfSpecialAttacks;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getSpellDamage() {
        return spellDamage;
    }

    public int getNumberOfHeals() {
        return numberOfHeals;
    }

    public int getNumberOfSpecialAttacks() {
        return numberOfSpecialAttacks;
    }
}
