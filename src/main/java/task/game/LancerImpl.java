package task.game;

public class LancerImpl extends AbstractWarrior{
    static final int ATTACK = 6;
    static final int INITIAL_HEALTH = 50;

    public LancerImpl() {
        super(INITIAL_HEALTH);
    }
    @Override
    public void hit(CanAcceptDamage enemy) {

    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

}
