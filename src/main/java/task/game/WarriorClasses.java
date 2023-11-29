package task.game;

public enum WarriorClasses {
    WARRIOR, KNIGHT, DEFENDER, VAMPIRE, LANCER, HEALER, MEGAMAN, WITCH;

    public static Warrior factory(WarriorClasses warriorClasses) {
        return switch (warriorClasses){
            case WARRIOR -> new WarriorImpl();
            case KNIGHT -> new KnightImpl();
            case DEFENDER -> new DefenderImpl();
            case VAMPIRE -> new VampireImpl();
            case LANCER -> new LancerImpl();
            case HEALER -> new HealerImpl();
            case MEGAMAN -> new MegaManImpl();
            case WITCH -> new WitchImpl();
        };
    }
    public Warrior make(){
        return factory(this);
    }

}
