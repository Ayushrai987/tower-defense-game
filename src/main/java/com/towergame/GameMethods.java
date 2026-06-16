package com.towergame;

public class GameMethods {

  // ===== METHOD 1: Calculate tower damage =====
  public static int calculateDamage(int baseDamage, int towerLevel) {
    return baseDamage * towerLevel;
  }

  // ===== METHOD 2: Check if can build tower =====
  public static boolean canBuildTower(int playerGold, int towerCost) {
    return playerGold >= towerCost;
  }

  // ===== METHOD 3: Update player health =====
  public static int updateHealth(int currentHealth, int damageReceived) {
    int newHealth = currentHealth - damageReceived;
    if (newHealth < 0) {
      newHealth = 0; // Health can't go below 0
    }
    return newHealth;
  }

  // ===== METHOD 4: Calculate gold after purchase =====
  public static int spendGold(int playerGold, int towerCost) {
    if (playerGold >= towerCost) {
      return playerGold - towerCost;
    } else {
      return playerGold; // Can't spend if not enough
    }
  }

  // ===== METHOD 5: Check enemy status =====
  public static String getEnemyStatus(int enemyHealth) {
    if (enemyHealth > 50) {
      return "STRONG";
    } else if (enemyHealth > 20) {
      return "DAMAGED";
    } else if (enemyHealth > 0) {
      return "CRITICAL";
    } else {
      return "DEAD";
    }
  }

  // ===== METHOD 6: Calculate wave difficulty =====
  public static int getWaveDifficulty(int waveNumber) {
    int baseEnemies = 5;
    int enemiesPerWave = baseEnemies * waveNumber;
    return enemiesPerWave;
  }

  // ===== MAIN METHOD =====
  public static void main(String[] args) {

    System.out.println("╔════════════════════════════════════╗");
    System.out.println("║       TOWER DEFENSE - METHODS      ║");
    System.out.println("╚════════════════════════════════════╝\n");

    // ===== TEST METHOD 1: calculateDamage =====
    System.out.println("🏹 TOWER DAMAGE CALCULATION:");
    int damage1 = calculateDamage(20, 1);
    int damage2 = calculateDamage(20, 2);
    int damage3 = calculateDamage(20, 3);
    System.out.println("├─ Level 1: " + damage1 + " damage");
    System.out.println("├─ Level 2: " + damage2 + " damage");
    System.out.println("└─ Level 3: " + damage3 + " damage");

    // ===== TEST METHOD 2: canBuildTower =====
    System.out.println("\n🏗️ CAN BUILD TOWER?");
    boolean canBuild1 = canBuildTower(500, 250);
    boolean canBuild2 = canBuildTower(100, 250);
    System.out.println("├─ With 500 gold (cost 250): " + canBuild1);
    System.out.println("└─ With 100 gold (cost 250): " + canBuild2);

    // ===== TEST METHOD 3: updateHealth =====
    System.out.println("\n❤️ PLAYER HEALTH UPDATE:");
    int health1 = updateHealth(100, 25);
    int health2 = updateHealth(50, 30);
    int health3 = updateHealth(20, 50); // Damage exceeds health
    System.out.println("├─ 100 HP - 25 damage = " + health1);
    System.out.println("├─ 50 HP - 30 damage = " + health2);
    System.out.println("└─ 20 HP - 50 damage = " + health3);

    // ===== TEST METHOD 4: spendGold =====
    System.out.println("\n💰 SPEND GOLD:");
    int gold1 = spendGold(500, 250);
    int gold2 = spendGold(100, 250);
    System.out.println("├─ 500 gold - 250 cost = " + gold1);
    System.out.println("└─ 100 gold - 250 cost = " + gold2 + " (not enough)");

    // ===== TEST METHOD 5: getEnemyStatus =====
    System.out.println("\n👹 ENEMY STATUS:");
    String status1 = getEnemyStatus(75);
    String status2 = getEnemyStatus(40);
    String status3 = getEnemyStatus(10);
    String status4 = getEnemyStatus(0);
    System.out.println("├─ 75 HP: " + status1);
    System.out.println("├─ 40 HP: " + status2);
    System.out.println("├─ 10 HP: " + status3);
    System.out.println("└─ 0 HP: " + status4);

    // ===== TEST METHOD 6: getWaveDifficulty =====
    System.out.println("\n📊 WAVE DIFFICULTY:");
    for (int wave = 1; wave <= 5; wave++) {
      int enemies = getWaveDifficulty(wave);
      System.out.println("├─ Wave " + wave + ": " + enemies + " enemies");
    }

    // ===== COMBINED TEST =====
    System.out.println("\n⚔️ GAME SCENARIO:");
    int playerGold = 500;
    int playerHealth = 100;
    int towerCost = 150;
    int towerDamage = 30;
    int towerLevel = 2;

    System.out.println("├─ Initial: Gold=" + playerGold + ", Health=" + playerHealth);

    // Build tower
    if (canBuildTower(playerGold, towerCost)) {
      playerGold = spendGold(playerGold, towerCost);
      System.out.println("├─ Tower built! Gold left=" + playerGold);
    }

    // Attack enemy
    int totalDamage = calculateDamage(towerDamage, towerLevel);
    System.out.println("├─ Tower damage=" + totalDamage);

    // Enemy attacks back
    int damageToPlayer = 20;
    playerHealth = updateHealth(playerHealth, damageToPlayer);
    System.out.println("├─ Player attacked! Health=" + playerHealth);

    System.out.println("└─ Final: Gold=" + playerGold + ", Health=" + playerHealth);

    System.out.println("\n════════════════════════════════════");
  }
}