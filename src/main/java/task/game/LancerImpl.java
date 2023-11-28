package task.game;

public class LancerImpl extends AbstractWarrior
implements CanHitAndReportMixin{
    static final int ATTACK = 6;
    static final int INITIAL_HEALTH = 50;
    static final int PENETRATION = 50;

    public LancerImpl() {
        super(INITIAL_HEALTH);
    }
    @Override
    public void hit(CanAcceptDamage enemy) {
        var damageDealt = hitAndReportDealtDamage(enemy);
        if(enemy instanceof  WarriorInArmy warriorInArmy) {
            var nextBehind = warriorInArmy.getWarriorBehind();
            if (nextBehind.isPresent()) {
                int secondDamage = damageDealt * PENETRATION / 100;
                nextBehind.get().acceptDamage(secondDamage);
            }
        }
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

}
