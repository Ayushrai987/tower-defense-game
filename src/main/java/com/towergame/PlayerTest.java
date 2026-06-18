package com.towergame;

public class PlayerTest {
  public static void main(String[] args) {

    System.out.println("╔════════════════════════════════════╗");
    System.out.println("║     TOWER DEFENSE - OOP DEMO       ║");
    System.out.println("╚════════════════════════════════════╝");

    // ===== CREATE PLAYER OBJECT =====
    System.out.println("\n🎮 CREATE PLAYER:");
    Player player = new Player("Umesh", 100, 500);
    player.displayStats();

    // ===== PLAYER TAKES DAMAGE =====
    System.out.println("\n⚔️ ENEMY ATTACKS:");
    player.takeDamage(25);
    player.takeDamage(15);

    // ===== PLAYER HEALS =====
    System.out.println("\n💊 PLAYER HEALS:");
    player.heal(30);

    // ===== PLAYER BUILDS TOWER (spends gold) =====
    System.out.println("\n🏗️ BUILD TOWER:");
    boolean built = player.spendGold(250);
    if (built) {
      System.out.println("└─ Tower built successfully!");
    }

    // ===== PLAYER EARNS GOLD =====
    System.out.println("\n💰 DEFEAT ENEMY:");
    player.earnGold(50);

    // ===== PLAYER ADDS SCORE =====
    System.out.println("\n⭐ SCORE UPDATE:");
    player.addScore(100);

    // ===== PLAYER LEVELS UP =====
    System.out.println("\n🚀 LEVEL UP:");
    player.levelUp();

    // ===== FINAL STATS =====
    player.displayStats();

    // ===== CREATE MULTIPLE PLAYERS =====
    System.out.println("\n\n👥 MULTIPLE PLAYERS:");
    Player player2 = new Player("Raj", 80, 300);
    Player player3 = new Player("Priya", 120, 700);

    player2.displayStats();
    player3.displayStats();

    // ===== SIMULATE GAME =====
    System.out.println("\n\n⚔️ GAME SIMULATION:");
    System.out.println("player vs player2:");
    player2.takeDamage(player.level * 20); // player attacks
    player2.earnGold(30);

    if (player2.isAlive()) {
      System.out.println("└─ player2 survived!");
    } else {
      System.out.println("└─ player2 defeated!");
    }

    System.out.println("\n════════════════════════════════════");
  }
}