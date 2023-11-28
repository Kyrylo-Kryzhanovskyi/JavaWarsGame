package task.game;



public abstract class AbstractWarrior implements Warrior{
    private static int idCounter = 0;
    private int health;
    private final int initialHealth;
    private final int id = ++idCounter;
    public AbstractWarrior(int health) {
        this.health = health;
        this.initialHealth = health;
    }
    public void acceptDamage(int damage){
        setHealth(getHealth()-damage);
    }
    protected void setHealth(int health) {
        this.health = Math.min(initialHealth, health);
    }

    public int getHealth() {
        return health;
    }
    public abstract int getAttack();

    @Override
    public String toString() {
        String name = getClass().getSimpleName();
        name = name.replaceAll("Impl","");
        name = name.toUpperCase();
        return name + "#" + id + "{" +
                "h=" + health + ", a="+ getAttack() +
                '}';
    }
}
