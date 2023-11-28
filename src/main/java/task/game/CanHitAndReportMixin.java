package task.game;

public interface CanHitAndReportMixin extends CanHit{
    default int hitAndReportDealtDamage(CanAcceptDamage enemy){
        var healthBefore = enemy.getHealth();
        CanHit.super.hit(enemy);
        var healthAfter = enemy.getHealth();
        var damageDealt = healthBefore - healthAfter;
        return damageDealt;
    }
}
