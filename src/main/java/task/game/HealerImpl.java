package task.game;

public class HealerImpl extends AbstractWarrior implements CanHeal {
    private static final int HEAL_POWER = 2;
    private static final int INITIAL_HEALTH = 60;

    public HealerImpl() {
        super(INITIAL_HEALTH);
    }
    public int getHealPower() {
        return HEAL_POWER;
    }
    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public void heal(HasHealth patient) {
        if (patient instanceof AbstractWarrior abstractWarrior) {
            abstractWarrior.setHealth(abstractWarrior.getHealth() + getHealPower());
        }
    }
}
