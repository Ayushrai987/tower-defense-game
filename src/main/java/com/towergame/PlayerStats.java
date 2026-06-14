package com.towergame;

public class PlayerStats {
    public static void main(String[] args) {
        
        String playerName = "Ayush";
        int playerHealth = 100;
        int playerGold = 500;
        int playerLevel = 1;
        boolean isAlive = true;
        double attackDamage = 15.5;
        
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║     TOWER DEFENSE GAME - START     ║");
        System.out.println("╚════════════════════════════════════╝");
        
        System.out.println("\n📊 PLAYER STATS:");
        System.out.println("├─ Name: " + playerName);
        System.out.println("├─ Health: " + playerHealth + " HP");
        System.out.println("├─ Gold: " + playerGold + " 💰");
        System.out.println("├─ Level: " + playerLevel);
        System.out.println("├─ Attack Damage: " + attackDamage);
        System.out.println("└─ Status: " + (isAlive ? "ALIVE ✅" : "DEAD ❌"));
        
        System.out.println("\n════════════════════════════════════");
    }
}