package school.mindera.game.targets.enemies.entities;

import school.mindera.game.game.utils.Variables;
import school.mindera.game.player.Player;
import school.mindera.game.targets.enemies.EnemyType;

public class Elf extends Enemy {

    private boolean magic;

    public Elf() {
        super(EnemyType.ELF);
        this.magic = Math.round(Math.random()) == 0;
    }

    public void learnMagic() {
        this.magic = true;
    }

    @Override
    public void getHit(int damage) {
        setHealth(getHealth() - damage - (int) (Math.random() * getEnemyType().getDefenseFactor()
                - (magic ? Variables.MAGIC_ELF_DEFENSE_FACTOR : 0)));
    }

    @Override
    public void attack(Player player) {
        player.hit(getEnemyType().getAttackDamage() + (magic ? Variables.MAGIC_ELF_ATTACK_FACTOR : 0));
    }

    @Override
    public String state() {
        return super.state() + (magic ? "\n" + "MAGIC" : "");
    }

    @Override
    public String toString() {
        return (magic ? "MAGIC " : "") + super.toString();
    }
}
