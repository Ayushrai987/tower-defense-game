package com.towergame;

public class EnemyWaves {
  public static void main(String[] args) {

    int waveNumber = 1;
    int enemiesPerWave = 10;
    int totalWaves = 5;

    System.out.println("╔════════════════════════════════════╗");
    System.out.println("║       TOWER DEFENSE - WAVES        ║");
    System.out.println("╚════════════════════════════════════╝\n");

    // ===== SPAWN ENEMIES IN CURRENT WAVE =====
    System.out.println("👹 WAVE " + waveNumber + " - SPAWN:");
    for (int i = 1; i <= enemiesPerWave; i++) {
      System.out.println("├─ Enemy " + i + " spawned (Health: 25)");
    }

    // ===== MULTIPLE WAVES =====
    System.out.println("\n📊 ALL WAVES:");
    for (int wave = 1; wave <= totalWaves; wave++) {
      int enemyCount = wave * 5; // Wave increases enemies
      System.out.println("├─ Wave " + wave + ": " + enemyCount + " enemies (Health: " + (20 + wave * 5) + ")");
    }

    // ===== TOWER LEVELS =====
    System.out.println("\n🏹 TOWER UPGRADE LEVELS:");
    for (int level = 1; level <= 5; level++) {
      int damage = 20 * level;
      int cost = 100 * level;
      System.out.println("├─ Level " + level + ": Damage=" + damage + ", Cost=" + cost + " gold");
    }

    // ===== SIMULATE WAVES (while loop) =====
    System.out.println("\n⚔️ WAVE SIMULATION:");
    int currentWave = 1;
    int playerHealth = 100;

    while (currentWave <= 3 && playerHealth > 0) {
      System.out.println("├─ Wave " + currentWave + " attacking...");
      playerHealth = playerHealth - 15; // Each wave damages player
      System.out.println("│  Player Health: " + playerHealth);
      currentWave++;
    }

    if (playerHealth > 0) {
      System.out.println("└─ ✅ Survived!");
    } else {
      System.out.println("└─ ❌ Game Over!");
    }

    System.out.println("\n════════════════════════════════════==");
  }
}