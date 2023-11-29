package task.game;

import java.util.*;
import java.util.function.Supplier;

public class Army implements Iterable<Warrior> {
    private static int idCounter;
    private final Deque<WarriorInArmyImpl> troops = new ArrayDeque<>();
    private final int id = ++idCounter;

    public Army addUnits(WarriorClasses warriorClasses, int quantity) {
        return addUnits(warriorClasses::make, quantity);
    }
    public Army addUnits(Supplier<Warrior> warriorFactory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Warrior warrior = warriorFactory.get();
            var warriorInArmy = new WarriorInArmyImpl(warrior);
            var last = troops.peekLast();
            if (last != null) last.setWarriorBehind(warriorInArmy);
            troops.add(warriorInArmy);
        }
        return this;
    }
//    void removeDeads(){
//
//        var it = troops.iterator();
//        while (it.hasNext()) {
//            if (!it.next().isAlive()){
//                it.remove();
//            }
//        }
//    }
    public boolean isEmpty(){
        return !new FirstAliveIterator().hasNext();
    }
    @Override
    public String toString() {
        return "Army#" + id +
                "{"+ troops +
                '}';
    }

    @Override
    public Iterator<Warrior> iterator() {
        return troops.stream().filter(Warrior::isAlive).map(WarriorInArmyImpl::unwrap).iterator();
    }

    public Iterator<Warrior> firstAliveIterator() {
        return new FirstAliveIterator();
    }
    private class FirstAliveIterator implements Iterator<Warrior> {

        @Override
        public boolean hasNext() {
            while(!troops.isEmpty() && !troops.peek().isAlive()){
                troops.poll();
            }
            return !troops.isEmpty();
        }

        @Override
        public Warrior next() {
            if(!hasNext()) throw new NoSuchElementException();
            return troops.peek();
        }
    }

    enum  ChampionDealsHit implements Command {
       INSTANCE
    }
    private static class WarriorInArmyImpl implements WarriorInArmy{
        final Warrior warrior;
        WarriorInArmy warriorBehind;
        public WarriorInArmyImpl(Warrior warrior) {
            this.warrior = Objects.requireNonNull(warrior);
        }
        private void setWarriorBehind(WarriorInArmy warriorBehind) {
            this.warriorBehind = Objects.requireNonNull(warriorBehind);
        }
        @Override
        public Optional<WarriorInArmy> getWarriorBehind() {
            return Optional.ofNullable(warriorBehind);
        }
        Warrior unwrap(){
            return warrior;
        }
        @Override
        public void acceptDamage(int damage) {
            warrior.acceptDamage(damage);
        }

        void passCommand(Command command, WarriorInArmy passer){
            if(passer != this){
                if(command instanceof ChampionDealsHit &&
                        warrior instanceof CanHeal healer){
                    healer.heal(passer);
                }
            }
            getWarriorBehind().ifPresent(
                    w -> ((WarriorInArmyImpl) w).passCommand(command, this)
            );
        }
        @Override
        public void hit(CanAcceptDamage enemy) {
            warrior.hit(enemy);
            passCommand(ChampionDealsHit.INSTANCE, this);
        }

        @Override
        public int getAttack() {
            return warrior.getAttack();
        }

        @Override
        public int getHealth() {
            return warrior.getHealth();
        }

        @Override
        public boolean isAlive() {
            return warrior.isAlive();
        }

        @Override
        public String toString() {
            return warrior.toString();
        }
    }
}
