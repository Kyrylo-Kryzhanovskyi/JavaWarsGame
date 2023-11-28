package task.game;

public class DefenderImpl extends AbstractWarrior implements HasDefence{
    static final int ATTACK = 3;
    static final int INITIAL_HEALTH = 60;
    static final int DEFENCE = 2;

    public DefenderImpl() {
        super(INITIAL_HEALTH);
    }

//    @Override
//    protected void setHealth(int health) {    //Інший спосіб застосування Defence для Defendera, при використанні потрібно закоментувати acceptDamage нижче, та
//        super.setHealth(getHealth()-Math.max(0,(getHealth()-health)-DEFENSE));
//    }

    @Override
    public void acceptDamage(int damage) {   //Закоментувати при перевірки іншого способа застосування Defence для Defendera
        int reducedDamage = Math.max(0,damage-getDefence());
        super.acceptDamage(reducedDamage);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }


    @Override
    public int getDefence() {
        return DEFENCE;
    }
}
