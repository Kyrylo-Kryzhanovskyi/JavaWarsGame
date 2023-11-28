package task.game;

public class HealerImpl extends AbstractWarrior implements CanHeal {
    private static final int HEAL_POWER = 2;
    private static final int INITIAL_HEALTH = 50;

    public HealerImpl() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public void heal(HasHealth patient) {

    }
}
