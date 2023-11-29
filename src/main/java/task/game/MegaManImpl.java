package task.game;

public class MegaManImpl extends HealerImpl implements  HasDefence, CanHitAndReportMixin{
    static final int ATTACK = 4;
    private static final int HEAL_POWER = 3;
    static final int VAMPIRISM = 30;
    static final int DEFENCE = 4;
    @Override
    public void acceptDamage(int damage) {
        int reducedDamage = Math.max(0,damage-getDefence());
        super.acceptDamage(reducedDamage);
    }

    @Override
    public void hit(CanAcceptDamage enemy) {
        var damageDealt = hitAndReportDealtDamage(enemy);
        var healing = damageDealt * getVampirism() / 100;
        setHealth(getHealth() + healing);
    }

    public int getVampirism() {
        return VAMPIRISM;
    }
    @Override
    public int getAttack() {
        return ATTACK;
    }
    @Override
    public int getDefence() {
        return DEFENCE;
    }
    @Override
    public int getHealPower() {
        return HEAL_POWER;
    }
}
