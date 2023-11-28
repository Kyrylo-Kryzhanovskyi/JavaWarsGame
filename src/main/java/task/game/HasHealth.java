package task.game;

public interface HasHealth {
    int getHealth();
    default boolean isAlive(){
        return getHealth() > 0;
    }
}
