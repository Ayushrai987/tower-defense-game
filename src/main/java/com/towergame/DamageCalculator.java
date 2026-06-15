package com.towergame;

public class DamageCalculator {
  public static void main(String[] args) {

    int towerDamage = 20;
    int towerLevel = 1;

    int enemyHealth = 50;

    int playerGold = 1000;
    int towerCost = 150;

    int totalDamage = towerDamage * towerLevel;
    int damageToEnemy = enemyHealth - totalDamage;
    int remainingGold = playerGold - towerCost;
    boolean canAfford = playerGold >= towerCost;

    System.out.println("=== TOWER DAMAGE CALCULATOR ===\n");

    System.out.println("Tower Stats:");
    System.out.println("├─ Base Damage: " + towerDamage);
    System.out.println("├─ Level: " + towerLevel);
    System.out.println("└─ Total Damage: " + totalDamage);

    System.out.println("\nEnemy Attack:");
    System.out.println("├─ Enemy Health: " + enemyHealth);
    System.out.println("├─ Damage Dealt: " + totalDamage);
    System.out.println("└─ Remaining Health: " + damageToEnemy);

    System.out.println("\nGold System:");
    System.out.println("├─ Your Gold: " + playerGold);
    System.out.println("├─ Tower Cost: " + towerCost);
    System.out.println("├─ Remaining Gold: " + remainingGold);
    System.out.println("└─ Can Afford: " + canAfford);

    System.out.println("\n════════════════════════════════");

  }
}