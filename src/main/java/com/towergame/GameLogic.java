package com.towergame;

public class GameLogic {
  public static void main(String[] args) {

    // Player Stats
    int playerHealth = 75;
    int playerGold = 300;
    int playerLevel = 2;

    // Tower Stats
    int towerCost = 250;
    int towerDamage = 35;

    // Enemy Stats
    int enemyHealth = 60;

    System.out.println("╔════════════════════════════════════╗");
    System.out.println("║       TOWER DEFENSE - LOGIC        ║");
    System.out.println("╚════════════════════════════════════╝");

    // ===== DECISION 1: Can build tower? =====
    System.out.println("\n🏗️ CAN BUILD TOWER?");
    if (playerGold >= towerCost) {
      System.out.println("✅ YES! Gold sufficient!");
      System.out.println("├─ Your Gold: " + playerGold);
      System.out.println("└─ Cost: " + towerCost);

      playerGold = playerGold - towerCost;
      System.out.println("├─ Gold after: " + playerGold);
      System.out.println("└─ Tower Built!");
    } else {
      System.out.println("❌ NO! Not enough gold!");
      System.out.println("├─ Your Gold: " + playerGold);
      System.out.println("└─ Need: " + towerCost);
    }

    // ===== DECISION 2: Tower vs Enemy =====
    System.out.println("\n⚔️ TOWER ATTACK:");
    int damageToEnemy = towerDamage;
    enemyHealth = enemyHealth - damageToEnemy;

    if (enemyHealth <= 0) {
      System.out.println("✅ ENEMY DEFEATED!");
      System.out.println("├─ Enemy Health: 0");
      System.out.println("└─ Gold Reward: +50");
      playerGold = playerGold + 50;
    } else {
      System.out.println("⚠️ Enemy Still Alive!");
      System.out.println("├─ Damage Dealt: " + damageToEnemy);
      System.out.println("└─ Remaining Health: " + enemyHealth);
    }

    // ===== DECISION 3: Is player alive? =====
    System.out.println("\n💪 PLAYER STATUS:");
    if (playerHealth > 50) {
      System.out.println("✅ HEALTHY!");
      System.out.println("├─ Health: " + playerHealth);
      System.out.println("└─ Status: STRONG");
    } else if (playerHealth > 0) {
      System.out.println("⚠️ LOW HEALTH!");
      System.out.println("├─ Health: " + playerHealth);
      System.out.println("└─ Status: CRITICAL");
    } else {
      System.out.println("❌ GAME OVER!");
      System.out.println("├─ Health: 0");
      System.out.println("└─ You Lost!");
    }

    // ===== FINAL STATS =====
    System.out.println("\n📊 FINAL STATS:");
    System.out.println("├─ Health: " + playerHealth);
    System.out.println("├─ Gold: " + playerGold);
    System.out.println("├─ Level: " + playerLevel);
    System.out.println("└─ Status: GAME ACTIVE");

    System.out.println("\n════════════════════════════════════");
  }
}