package com.niklas.playing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTests {

    @Test
    public void testPlayerInitialization() {
        Player player = new Player("Test", 10, 10, 10, 100, 0, 1, 2, 0);
        assertEquals("Test", player.getName());
        assertEquals(10, player.getAgility());
        assertEquals(100, player.getHealth());
        assertEquals(0, player.getExperience());
    }

    @Test
    public void testMonsterInitialization() {
        Monster monster = new Monster("Goblin", 30, 4, 20, 5);
        assertEquals("Goblin", monster.getType());
        assertEquals(30, monster.getHealth());
        assertEquals(4, monster.getStrength());
        assertEquals(20, monster.getAgility());
    }

    @Test
    public void testLevelUp() {
        Player player = new Player("Test", 10, 10, 10, 100, 100, 1, 2, 0);
        player.levelUp();
        assertEquals(2, player.getLevel());
        assertEquals(12, player.getAgility());
        assertEquals(12, player.getStrength());
        assertEquals(12, player.getIntelligence());
        assertEquals(0, player.getExperience());
    }

    @Test
    public void testTakeDamage() {
        Player player = new Player("Test", 10, 10, 10, 100, 0, 1, 2, 0);
        player.takeDamage(20);
        assertEquals(80, player.getHealth());
    }

    @Test
    public void testCalculateDamage() {
        Player player = new Player("Test", 10, 10, 10, 150, 0, 1, 2, 0);
        int expectedMinDamage = 2;
        int expectedMaxDamage = 15 + player.getStrength() - 2;
        int actualDamage = player.calculateDamage();
        assertTrue(actualDamage >= expectedMinDamage && actualDamage <= expectedMaxDamage);
    }
}
