package com.niklas.playing;

public interface ICombat {
    void fight(Player player, Monster monster);
    boolean tryToFlee(int agility);
}
