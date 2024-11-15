package com.niklas.playing;

import java.util.List;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the game! Enter your name:");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName, 10, 10, 10, 150, 0, 1, 5, 100);
        List<Monster> monsters = Monster.generateMonsterList();

        boolean gameRunning = true;

        while (gameRunning) {
            System.out.println("Choose an action:");
            System.out.println("1. Fight a monster");
            System.out.println("2. Check status");
            System.out.println("3. Quit game");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Monster currentMonster = monsters.get((int) (Math.random() * monsters.size()));
                    System.out.println("You encounter a " + currentMonster.getType() + "!");
                    fight(player, currentMonster);
                    if (player.getHealth() <= 0) {
                        System.out.println("Game over! You have been defeated.");
                        gameRunning = false;
                    }
                    break;
                case 2:
                    player.getStatus();
                    break;
                case 3:
                    System.out.println("Game is quitting. Thanks for playing!");
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void fight(Player player, Monster monster) {
        Scanner scanner = new Scanner(System.in);

        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            System.out.println("Choose an action:");
            System.out.println("1. Attack");
            System.out.println("2. Flee");
            System.out.println("3. Check status");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    player.attack(monster);
                    if (monster.getHealth() > 0) {
                        monster.attack(player);
                    } else {
                        System.out.println("You defeated the " + monster.getType() + "!");
                        player.gainExperience(monster.getExperienceReward());
                    }
                    break;
                case 2:
                    if (player.tryToFlee(player.getAgility())) {
                        System.out.println("You successfully fled from the " + monster.getType() + "!");
                        return;
                    } else {
                        System.out.println("You failed to flee!");
                        monster.attack(player);
                    }
                    break;
                case 3:
                    player.getStatus();
                    System.out.println(monster.getType() + " Status: Health = " + monster.getHealth());
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
