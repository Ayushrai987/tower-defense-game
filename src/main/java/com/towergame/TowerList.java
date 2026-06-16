package com.towergame;

public class TowerList {
  public static void main(String[] args) {

    // ===== ARRAY 1: Tower Names =====
    String[] towerNames = { "Archer", "Cannon", "Ice", "Fire", "Lightning" };

    // ===== ARRAY 2: Tower Damage =====
    int[] towerDamage = { 20, 50, 15, 35, 40 };

    // ===== ARRAY 3: Tower Cost =====
    int[] towerCost = { 100, 250, 150, 200, 300 };

    // ===== ARRAY 4: Tower Health =====
    int[] towerHealth = { 100, 80, 120, 90, 110 };

    System.out.println("╔════════════════════════════════════╗");
    System.out.println("║       TOWER INVENTORY - ARRAYS     ║");
    System.out.println("╚════════════════════════════════════╝\n");

    // ===== DISPLAY ALL TOWERS (using for loop) =====
    System.out.println("🏰 ALL TOWERS:");
    for (int i = 0; i < towerNames.length; i++) {
      System.out.println("├─ " + (i + 1) + ". " + towerNames[i]);
      System.out.println("│  ├─ Damage: " + towerDamage[i]);
      System.out.println("│  ├─ Cost: " + towerCost[i] + " gold");
      System.out.println("│  └─ Health: " + towerHealth[i]);
    }

    // ===== FIND STRONGEST TOWER =====
    System.out.println("\n⚡ STRONGEST TOWER:");
    int maxDamage = towerDamage[0];
    int strongestIndex = 0;

    for (int i = 1; i < towerDamage.length; i++) {
      if (towerDamage[i] > maxDamage) {
        maxDamage = towerDamage[i];
        strongestIndex = i;
      }
    }

    System.out.println("├─ Name: " + towerNames[strongestIndex]);
    System.out.println("├─ Damage: " + towerDamage[strongestIndex]);
    System.out.println("└─ Cost: " + towerCost[strongestIndex] + " gold");

    // ===== FIND CHEAPEST TOWER =====
    System.out.println("\n💰 CHEAPEST TOWER:");
    int minCost = towerCost[0];
    int cheapestIndex = 0;

    for (int i = 1; i < towerCost.length; i++) {
      if (towerCost[i] < minCost) {
        minCost = towerCost[i];
        cheapestIndex = i;
      }
    }

    System.out.println("├─ Name: " + towerNames[cheapestIndex]);
    System.out.println("├─ Damage: " + towerDamage[cheapestIndex]);
    System.out.println("└─ Cost: " + towerCost[cheapestIndex] + " gold");

    // ===== TOTAL HEALTH =====
    System.out.println("\n❤️ TOTAL TOWER HEALTH:");
    int totalHealth = 0;
    for (int health : towerHealth) {
      totalHealth = totalHealth + health;
    }
    System.out.println("├─ Total: " + totalHealth);
    System.out.println("└─ Average: " + (totalHealth / towerHealth.length));

    // ===== TOWERS ABOVE 100 DAMAGE =====
    System.out.println("\n🔥 HIGH DAMAGE TOWERS (>30 damage):");
    for (int i = 0; i < towerDamage.length; i++) {
      if (towerDamage[i] > 30) {
        System.out.println("├─ " + towerNames[i] + " (" + towerDamage[i] + " damage)");
      }
    }

    // ===== ARRAY MODIFICATION =====
    System.out.println("\n🛠️ TOWER UPGRADE:");
    System.out.println("├─ Before: " + towerNames[0] + " Health = " + towerHealth[0]);
    towerHealth[0] = towerHealth[0] + 20; // Upgrade health
    System.out.println("└─ After: " + towerNames[0] + " Health = " + towerHealth[0]);

    System.out.println("\n════════════════════════════════════");
  }
}