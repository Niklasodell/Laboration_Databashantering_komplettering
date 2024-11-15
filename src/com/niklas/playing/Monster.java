package com.niklas.playing;

import java.util.ArrayList;
import java.util.List;

public class Monster {
    private String type;
    private int health;
    private int strength;
    private int agility;
    private int experienceReward;

    public Monster(String type, int health, int strength, int agility, int experienceReward) {
        this.type = type;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.experienceReward = experienceReward;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getExperienceReward() {
        return experienceReward;
    }

    public void attack(Player player) {
        if (player.didDodge()) {
            System.out.println("You dodged the attack!");
        } else {
            int damage = calculateDamage();
            player.takeDamage(damage);
            System.out.println("The " + type + " attacked you for " + damage + " damage.");
        }
    }

    public int calculateDamage() {
        int maxDamage = Math.min(7, strength);
        return maxDamage + (int) (Math.random() * (15 - maxDamage));
    }


    public boolean didDodge() {
        int dodgeChance = (int) (Math.random() * 100);
        return dodgeChance <= agility;
    }

    public boolean tryToFlee(int playerAgility) {
        int fleeChance = (int) (Math.random() * 100);
        return fleeChance <= (playerAgility / 2);
    }

    public static List<Monster> generateMonsterList() {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Goblin", 20, 5, 5, 20));
        monsters.add(new Monster("Orc", 40, 10, 3, 30));
        monsters.add(new Monster("Dragon", 55, 15, 10, 50));
        return monsters;
    }
}
