package task.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static task.game.Game.fight;
import static task.game.Game.straightFight;
import static task.game.WarriorClasses.*;

public class ArmyTest {
    @Test
    @DisplayName("1. Army: army of 1 warrior vs army of 2 warriors; first lose")
    void test01() {
        var army1 = new Army()
            .addUnits(WARRIOR,1);
        var army2 = new Army()
            .addUnits(WARRIOR,2);
        assertFalse(fight(army1, army2));
    }

    @Test
    @DisplayName("2. Army: army of 2 warriors vs army of 3 warriors; first lose")
    void test02() {
        var army1 = new Army()
                .addUnits(WARRIOR, 2);
        var army2 = new Army()
                .addUnits(WARRIOR, 3);
        assertFalse(fight(army1, army2));
    }

    @Test
    @DisplayName("3. Army: army of 5 warriors vs army of 7 warriors; first lose")
    void test03() {
        var army1 = new Army()
                .addUnits(WARRIOR, 5);
        var army2 = new Army()
                .addUnits(WARRIOR, 7);
        assertFalse(fight(army1, army2));
    }

    @Test
    @DisplayName("4. Army: army of 20 warriors vs army of 21 warriors; first win")
    void test04() {
        var army1 = new Army()
                .addUnits(WARRIOR, 20);
        var army2 = new Army()
                .addUnits(WARRIOR, 21);
        assertTrue(fight(army1, army2));
    }

    @Test
    @DisplayName("5. Army: army of 10 warriors vs army of 11 warriors; first win")
    void test05() {
        var army1 = new Army()
                .addUnits(WARRIOR, 10);
        var army2 = new Army()
                .addUnits(WARRIOR, 11);
        assertTrue(fight(army1, army2));
    }

    @Test
    @DisplayName("6. Army: army of 11 warriors vs army of 7 warriors; first win")
    void test06() {
        var army1 = new Army()
                .addUnits(WARRIOR, 11);
        var army2 = new Army()
                .addUnits(WARRIOR, 7);
        assertTrue(fight(army1, army2));
    }
    @Test
    @DisplayName("7. Battle: army with 5 warriors, 4 defenders, and 5 defenders vs army with 4 warriors; first win")
    void test07() {
        var army1 = new Army()
                .addUnits(WARRIOR, 5)
                .addUnits(DEFENDER, 4)
                .addUnits(DEFENDER, 5);
        var army2 = new Army()
                .addUnits(WARRIOR, 4);
        assertTrue(fight(army1, army2));
    }

    @Test
    @DisplayName("8. Battle: army with 5 defenders, 20 warriors, and 4 defenders vs army with 21 warriors; first win")
    void test08() {
        var army1 = new Army()
                .addUnits(DEFENDER, 5)
                .addUnits(WARRIOR, 20)
                .addUnits(DEFENDER, 4);
        var army2 = new Army()
                .addUnits(WARRIOR, 21);
        assertTrue(fight(army1, army2));
    }

    @Test
    @DisplayName("9. Battle: army with 10 warriors, 5 defenders, and 10 defenders vs army with 5 warriors; first win")
    void test09() {
        var army1 = new Army()
                .addUnits(WARRIOR, 10)
                .addUnits(DEFENDER, 5)
                .addUnits(DEFENDER, 10);
        var army2 = new Army()
                .addUnits(WARRIOR, 5);
        assertTrue(fight(army1, army2));
    }

    @Test
    @DisplayName("10. Battle: army with 2 defenders, 1 warrior, and 1 defender vs army with 5 warriors; first lose")
    void test10() {
        var army1 = new Army()
                .addUnits(DEFENDER, 2)
                .addUnits(WARRIOR, 1)
                .addUnits(DEFENDER, 1);
        var army2 = new Army()
                .addUnits(WARRIOR, 5);
        assertFalse(fight(army1, army2));
    }
    @Test
    @DisplayName("11. Battle: armies with Defenders, Vampires, and Warriors; first lose")
    void test11() {
        var army1 = new Army()
                .addUnits(DEFENDER, 5)
                .addUnits(VAMPIRE, 6)
                .addUnits(WARRIOR, 7);
        var army2 = new Army()
                .addUnits(WARRIOR, 6)
                .addUnits(DEFENDER, 6)
                .addUnits(VAMPIRE, 6);
        assertFalse(fight(army1, army2));
    }

    @Test
    @DisplayName("12. Battle: armies with 2 Defenders, 3 Vampires, and 4 Warriors vs armies with 4 Warriors, 4 Defenders, and 3 Vampires; first lose")
    void test12() {
        var army1 = new Army()
                .addUnits(DEFENDER, 2)
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 4);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(VAMPIRE, 3);
        assertFalse(fight(army1, army2));
    }

    @Test
    @DisplayName("13. Battle: armies with 11 Defenders, 3 Vampires, and 4 Warriors vs armies with 4 Warriors, 4 Defenders, and 13 Vampires; first win")
    void test13() {
        var army1 = new Army()
                .addUnits(DEFENDER, 11)
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 4);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(VAMPIRE, 13);
        assertTrue(fight(army1, army2));
    }

    @Test
    @DisplayName("14. Battle: armies with 9 Defenders, 3 Vampires, and 8 Warriors vs armies with 4 Warriors, 4 Defenders, and 13 Vampires; first win")
    void test14() {
        var army1 = new Army()
                .addUnits(DEFENDER, 9)
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 8);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(VAMPIRE, 13);
        assertTrue(fight(army1, army2));
    }
    @Test
    @DisplayName("15. Battle: army of 5 Lancers, 3 Vampires, 4 Warriors, 2 Defenders vs army of 4 Warriors, 4 Defenders,6 Vampires, 5 Lancers; first lose")
    void test15() {
        var army1 = new Army()
                .addUnits(LANCER, 5)
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 2);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(VAMPIRE, 6)
                .addUnits(LANCER, 5);
        assertFalse(fight(army1, army2));
    }

    @Test
    @DisplayName("16. Battle: army of 7 Lancers, 3 Vampires, 4 Warriors, 2 Defenders vs army of 4 Warriors, 4 Defenders,6 Vampires, 4 Lancers ; first win")
    void test16() {
        var army1 = new Army()
                .addUnits(LANCER, 7)
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 2);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(VAMPIRE, 6)
                .addUnits(LANCER, 4);
        assertTrue(fight(army1, army2));
    }

    @Test
    @DisplayName("17. Battle: army of 2 Warriors vs army of 1 Lancer, 1 Warrior; first lose")
    void test17() {
        var armyWarrior = new Army()
                .addUnits(WARRIOR, 2);
        var armyLancer = new Army()
                .addUnits(LANCER, 1)
                .addUnits(WARRIOR, 1);
        assertFalse(fight(armyWarrior, armyLancer));
    }
//"18. Battle": [
//    prepare_test(middle_code='''army_1 = Army()
//            army_2 = Army()
//army_1.add_units(Lancer, 1)
//            army_1.add_units(Warrior, 3)
//            army_1.add_units(Healer, 1)
//            army_1.add_units(Warrior, 4)
//            army_1.add_units(Healer, 1)
//            army_1.add_units(Knight, 2)
//            army_2.add_units(Warrior, 4)
//            army_2.add_units(Defender, 4)
//            army_2.add_units(Healer, 1)
//            army_2.add_units(Vampire, 6)
//            army_2.add_units(Lancer, 4)
//    battle = Battle()''',
//    test="battle.fight(army_1, army_2)",
//    answer=False)
//            ]
@Test
@DisplayName("18. Battle: army of 3 Warriors,1 Healer, 4 Warriors, 1 Healer, 2 Knights vs army of 4 Warriors, 4 Defenders, 1 Healer, 6 Vampire, 4 Lancer  ; first win")
void test18() {
    var army_1 = new Army()
            .addUnits(WARRIOR, 3)
            .addUnits(HEALER, 1)
            .addUnits(WARRIOR, 4)
            .addUnits(HEALER, 1)
            .addUnits(KNIGHT, 2);
    var army_2 = new Army()
            .addUnits(WARRIOR, 4)
            .addUnits(DEFENDER, 4)
            .addUnits(HEALER, 1)
            .addUnits(VAMPIRE, 6)
            .addUnits(LANCER, 4);
    assertFalse(fight(army_1, army_2));
}
    @Test
    @DisplayName("19. Battle_StraightFight: army of 5 Lancer, 3 Vampire, 4 Warriors, 2 Defenders vs army of 4 Warriors, 4 Defenders,  6 Vampire, 5 Lancer; first lose")
    void test19() {
        var army1 = new Army()
                .addUnits(LANCER, 5)
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 2);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(VAMPIRE, 6)
                .addUnits(LANCER, 5);
        assertFalse(straightFight(army1, army2));
    }

    @Test
    @DisplayName("20. Battle_StraightFight: army of 7 Lancer, 3 Vampire, 4 Warriors, 2 Defenders vs army of 4 Warriors, 4 Defenders,  6 Vampire, 4 Lancer; first win")
    void test20() {
        var army1 = new Army()
                .addUnits(LANCER, 7)
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 2);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(VAMPIRE, 6)
                .addUnits(LANCER, 4);
        assertTrue(straightFight(army1, army2));
    }

    @Test
    @DisplayName("21. Battle_StraightFight: army of 7 Lancer, 3 Vampire, 1 healer, 4 Warriors, 1 healer, 2 Defenders vs army of 4 Warriors, 4 Defenders, 1 healer,  6 Vampire, 4 Lancer; first lose")
    void test21() {
        var army1 = new Army()
                .addUnits(LANCER, 7)
                .addUnits(VAMPIRE, 3)
                .addUnits(HEALER, 1)
                .addUnits(WARRIOR, 4)
                .addUnits(HEALER, 1)
                .addUnits(DEFENDER, 2);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(HEALER, 1)
                .addUnits(VAMPIRE, 6)
                .addUnits(LANCER, 4);
        assertFalse(straightFight(army1, army2));
    }

    @Test
    @DisplayName("22. Battle_StraightFight:army of 4 Lancer, 3 Warriors, 1 healer, 4 Warriors, 1 healer, 2 Knights vs army of 4 Warriors, 4 Defenders, 1 healer,  2 Vampire, 4 Lancer; first win")
    void test22() {
        var army1 = new Army()
                .addUnits(LANCER, 4)
                .addUnits(WARRIOR, 3)
                .addUnits(HEALER, 1)
                .addUnits(WARRIOR, 4)
                .addUnits(HEALER, 1)
                .addUnits(KNIGHT, 2);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(HEALER, 1)
                .addUnits(VAMPIRE, 2)
                .addUnits(LANCER, 4);
        assertTrue(straightFight(army1, army2));
    }
    @Test
    @DisplayName("23. Battle:army of 1 MegaMan vs army of 4 Warriors, 4 Defenders, 1 healer,  2 Vampire, 4 Lancer; first win")
    void test23() {
        var army1 = new Army()
                .addUnits(MEGAMAN, 1);

        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(HEALER, 1)
                .addUnits(VAMPIRE, 2)
                .addUnits(LANCER, 4);
        assertTrue(fight(army1, army2));
    }
    @Test
    @DisplayName("24. Battle:army1 vs army2 ; first lose")
    void test24() {
        var army1 = new Army()
                .addUnits(WARRIOR, 2)
                .addUnits(MEGAMAN, 1)
                .addUnits(HEALER, 1);

        var army2 = new Army()
                .addUnits(LANCER, 1)
                .addUnits(HEALER, 1)
                .addUnits(KNIGHT, 5)
                .addUnits(HEALER, 1);
        assertFalse(fight(army1, army2));
    }
    @Test
    @DisplayName("25. Battle:army1 vs army2 ; first win")
    void test25() {
        var army1 = new Army()
                .addUnits(WARRIOR, 3)
                .addUnits(HEALER, 1)
                .addUnits(VAMPIRE, 2)
                .addUnits(MEGAMAN, 1);

        var army2 = new Army()
                .addUnits(LANCER, 1)
                .addUnits(HEALER, 1)
                .addUnits(KNIGHT, 5)
                .addUnits(HEALER, 1);
        assertTrue(fight(army1, army2));
    }
    @Test
    @DisplayName("26. Battle:army1 vs army2 ; first win")
    void test26() {
        var army1 = new Army()
                .addUnits(WARRIOR,1)
                .addUnits(WITCH, 3);

        var army2 = new Army()
                .addUnits(WARRIOR, 1)
                .addUnits(WITCH, 1);

        assertTrue(fight(army1, army2));
    }
    @Test
    void lancerArmySmokeTest() {
        var my_army = new Army ()
                .addUnits(DEFENDER, 2)
                .addUnits(VAMPIRE, 2)
                .addUnits(LANCER, 4)
                .addUnits(WARRIOR, 1);
        var enemy_army = new Army ()
                .addUnits(WARRIOR, 2)
                .addUnits(LANCER, 2)
                .addUnits(DEFENDER, 2)
                .addUnits(VAMPIRE, 3);
        var army_3 = new Army()
                .addUnits(WARRIOR, 1)
                .addUnits(LANCER, 1)
                .addUnits(DEFENDER, 2);
        var army_4 = new Army ()
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 1)
                .addUnits(LANCER, 2);
        assertTrue(fight(my_army, enemy_army));
        assertFalse(fight(army_3, army_4));
    }
    @Test
    void defenderArmySmokeTest() {
        var my_army = new Army().addUnits(DEFENDER, 1);
        var enemy_army = new Army()
                .addUnits(WARRIOR, 2);
        var army_3 = new Army()
                .addUnits(WARRIOR, 1)
                .addUnits(DEFENDER, 1);
        var army_4 = new Army().addUnits(WARRIOR, 2);

        assertFalse(fight(my_army, enemy_army));
        assertTrue(fight(army_3, army_4));
    }
}
