package task.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static task.game.Game.fight;
import static task.game.WarriorClasses.*;

class FightTest {

    @Test
    @DisplayName("1. Fight: carl(Warrior) vs jim(Knight); carl lose")
    void test01() {
        Warrior carl = WARRIOR.make();
        Warrior jim = KNIGHT.make();
        assertFalse(fight(carl, jim));
    }

    @Test
    @DisplayName("2. Fight: ramon(Knight) vs slevin(Warrior); ramon win")
    void test02() {
        Warrior ramon = KNIGHT.make();
        Warrior slevin = WARRIOR.make();
        assertTrue(fight(ramon, slevin));
    }

    @Test
    @DisplayName("3. Fight: bob(Warrior) vs mars(Warrior); bob is alive")
    void test03() {
        Warrior bob = WARRIOR.make();
        Warrior mars = WARRIOR.make();
        fight(bob, mars);
        assertTrue(bob.isAlive());
    }

    @Test
    @DisplayName("4. Fight: zeus(Knight) vs godkiller(Warrior); zeus is alive")
    void test04() {
        Warrior zeus = KNIGHT.make();
        Warrior godkiller = WARRIOR.make();
        fight(zeus, godkiller);
        assertTrue(zeus.isAlive());
    }

    @Test
    @DisplayName("5. Fight: husband(Warrior) vs wife(Warrior); wife is not alive")
    void test05() {
        Warrior husband = WARRIOR.make();
        Warrior wife = WARRIOR.make();
        fight(husband, wife);
        assertFalse(wife.isAlive());
    }

    @Test
    @DisplayName("6. Fight: dragon(Warrior) vs knight(Knight); knight is alive")
    void test06() {
        Warrior dragon = WARRIOR.make();
        Warrior knight = KNIGHT.make();
        fight(dragon, knight);
        assertTrue(knight.isAlive());
    }

    @Test
    @DisplayName("7. Fight: unit_1(Warrior) vs unit_2(Knight) ->unit_2(Knight) vs unit_3(Warrior) ; unit_2 is not alive against unit_3")
    void test07() {
        Warrior unit_1 = WARRIOR.make();
        Warrior unit_2 = KNIGHT.make();
        Warrior unit_3 = WARRIOR.make();
        fight(unit_1, unit_2);
        assertFalse(fight(unit_2, unit_3));
    }
    @Test
    @DisplayName("SmokeTestWarDef: Warrior vs Defender; warrior lose, hp warrior=-1, hp defender=9")
    void testSmoke01() {
        Warrior unit_1 = WARRIOR.make();
        Warrior unit_2 = DEFENDER.make();
        assertAll(
                ()->assertFalse(fight(unit_1, unit_2)),
                ()->assertEquals(-1, unit_1.getHealth()),
                ()-> assertEquals(9, unit_2.getHealth())
        );
    }
    @Test
    @DisplayName("8. Fight: Defender vs Rookie; health after fight")
    void test08() {
        var unit1 = DEFENDER.make();
        var unit2 = new Rookie();
        fight(unit1, unit2);
        assertEquals(60, unit1.getHealth());
    }

    @Test
    @DisplayName("9. Fight: Defender vs Rookie; result of the fight with Warrior")
    void test09() {
        var unit1 = DEFENDER.make();
        var unit2 = new Rookie();
        var unit3 = WARRIOR.make();
        fight(unit1, unit2);
        assertTrue(fight(unit1, unit3));
    }

    @Test
    @DisplayName("SmokeTestDefVam: Defender vs Vampire; Defender win, hp defender=22, hp vampire=-1")
    void testSmoke02() {
        Warrior unit_1 = DEFENDER.make();
        Warrior unit_2 = VAMPIRE.make();
        assertAll(
                ()->assertTrue(fight(unit_1, unit_2)),
                ()->assertEquals(22, unit_1.getHealth()),
                ()-> assertEquals(-1, unit_2.getHealth())
        );
    }

    @Test
    void defenderFightSmokeTest() {
        var chuck = WARRIOR.make();
        var bruce = WARRIOR.make();
        var carl = KNIGHT.make();
        var dave = WARRIOR.make();
        var mark = WARRIOR.make();
        var bob = DEFENDER.make();
        var mike = KNIGHT.make();
        var rog = WARRIOR.make();
        var lancelot = DEFENDER.make();
        assertTrue(fight(chuck, bruce));
        assertFalse(fight(dave, carl));
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());
        assertFalse(fight(carl, mark));
        assertFalse(carl.isAlive());
        assertFalse(fight(bob, mike));
        assertTrue(fight(lancelot, rog));
    }
    @Test
    void lancerFightSmokeTest() {
        var chuck = WARRIOR.make();
        var bruce = WARRIOR.make();
        var carl = KNIGHT.make();
        var dave = WARRIOR.make();
        var mark = WARRIOR.make();
        var bob = DEFENDER.make();
        var mike = KNIGHT.make();
        var rog = WARRIOR.make();
        var lancelot = DEFENDER.make();
        var eric = VAMPIRE.make();
        var adam = VAMPIRE.make();
        var richard = DEFENDER.make();
        var ogre = WARRIOR.make();
        var freelancer = LANCER.make();
        var vampire = VAMPIRE.make();
        assertTrue(fight (chuck, bruce));
        assertFalse(fight (dave, carl));
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse (dave.isAlive());
        assertFalse(fight (carl, mark));
        assertFalse(carl.isAlive());
        assertFalse(fight(bob, mike));
        assertTrue(fight (lancelot, rog));
        assertFalse(fight(eric, richard));
        assertTrue(fight (ogre, adam));
        assertTrue(fight (freelancer, vampire));
        assertTrue(freelancer.isAlive());

    }
    private static class Rookie extends AbstractWarrior{
        static final int INITIAL_HEALTH = 50;
        static final int ATTACK = 1;

        public Rookie() {
            super(INITIAL_HEALTH);
        }

        @Override
        public int getAttack() {
            return ATTACK;
        }
    }
}