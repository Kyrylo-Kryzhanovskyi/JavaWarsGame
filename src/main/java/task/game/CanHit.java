package task.game;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface CanHit extends HasAttack{
    Logger log = LoggerFactory.getLogger(CanHit.class);
    default void hit(CanAcceptDamage enemy){
        log.info("Warrior {} hits {}", this, enemy);
        enemy.acceptDamage(getAttack());
    }

}
