package task.game;

public class WitchImpl extends AbstractWarrior implements CanHitAndReportMixin{ // во время удара кидает зелье которое наносит всем в армии атаку
    static final int ATTACK = 2;
    static final int INITIAL_HEALTH = 30;
    public WitchImpl() {
        super(INITIAL_HEALTH);
    }
    @Override
    public void hit(CanAcceptDamage enemy) {
        super.hit(enemy);
        if(enemy instanceof  WarriorInArmy warriorInArmy) {
            var nextBehind = warriorInArmy.getWarriorBehind();
            if (nextBehind.isPresent()) {
                hit(nextBehind.get());
            }
        }
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

}
