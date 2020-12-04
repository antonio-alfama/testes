package school.mindera.game.targets.enemies.entities;

import school.mindera.game.game.utils.Variables;
import school.mindera.game.player.Player;
import school.mindera.game.targets.enemies.EnemyType;

public class Dwarf extends Enemy {

    private boolean drunk;

    public Dwarf() {
        super(EnemyType.DWARF);
        this.drunk = Math.round(Math.random()) == 0;
    }

    public void drink() {
        this.drunk = true;
    }

    @Override
    public void getHit(int damage) {
        setHealth(getHealth() - damage - (int) (Math.random() * getEnemyType().getDefenseFactor()
                - (drunk ? Variables.DRUNK_DWARF_DEFENSE_FACTOR : 0)));
    }

    @Override
    public void attack(Player player) {
        player.hit(getEnemyType().getAttackDamage() + (drunk ? Variables.DRUNK_DWARF_ATTACK_FACTOR : 0));
    }

    @Override
    public String state() {
        return super.state() + (drunk ? "\n" + "DRUNK" : "");
    }

    @Override
    public String toString() {
        return (drunk ? "DRUNK " : "") + super.toString();
    }
}
