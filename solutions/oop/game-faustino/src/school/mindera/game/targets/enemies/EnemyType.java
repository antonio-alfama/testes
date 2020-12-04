package school.mindera.game.targets.enemies;

public enum EnemyType {
    ELF(12, 12, 50),
    DWARF(3, 13, 100),
    HUMAN(8, 9, 120),
    DRAGON(20, 20, 420);

    private int defenseFactor;
    private int attackDamage;
    private int health;

    EnemyType(int defenseFactor, int attackFactor, int health) {
        this.defenseFactor = defenseFactor;
        this.attackDamage = attackFactor;
        this.health = health;
    }

    public int getDefenseFactor() {
        return defenseFactor;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getHealth() {
        return health;
    }
}
