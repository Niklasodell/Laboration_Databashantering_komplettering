package com.niklas.playing;

public class Player {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;
    private int experience;
    private int level;
    private int damage;
    private int maxHealth;

    public Player(String name, int strength, int agility, int intelligence, int health, int experience, int level, int damage, int maxHealth) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = health;
        this.experience = experience;
        this.level = level;
        this.damage = damage;
        this.maxHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public int getDamage() {
        return damage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }


    public void attack(Monster monster) {
        int damage = calculateDamage();
        monster.setHealth(monster.getHealth() - damage);
        System.out.println("You attacked the " + monster.getType() + " for " + damage + " damage.");
    }

    public int calculateDamage() {
        int maxDamage = Math.min(7, strength);
        return maxDamage + (int) (Math.random() * (15 - maxDamage));
    }

    public boolean didDodge() {
        int dodgeChance = (int) (Math.random() * 100);
        return dodgeChance <= agility;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println("You took " + damage + " damage.");
    }

    public boolean tryToFlee(int playerAgility) {
        int fleeChance = (int) (Math.random() * 100);
        return fleeChance <= (playerAgility / 2);
    }

    public void gainExperience(int exp) {
        experience += exp;
        System.out.println("You gained " + exp + " experience points.");
        levelUp();
    }

    protected void levelUp() {
        int expThreshold = level * 100;
        if (experience >= expThreshold) {
            level++;
            experience -= expThreshold;
            strength += 2;
            agility += 2;
            intelligence += 2;
            maxHealth += 10;
            health = maxHealth;
            System.out.println("Congratulations! You leveled up to level " + level + "!");
        }
    }

    public void getStatus() {
        System.out.println("Player Status:");
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Strength: " + strength);
        System.out.println("Agility: " + agility);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Experience: " + experience);
    }
}
