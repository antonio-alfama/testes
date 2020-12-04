package school.mindera.game.targets.obstacles;

public enum ObstacleType {
    ROCK(20),
    TREE(15);

    private int sustainableDamage;

    ObstacleType(int sustainableDamage) {
        this.sustainableDamage = sustainableDamage;
    }

    public int getSustainableDamage() {
        return sustainableDamage;
    }
}
