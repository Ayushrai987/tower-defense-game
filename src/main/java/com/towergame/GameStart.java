package com.towergame;

public class GameStart {
  public static void main(String[] args) {

    String playerName = "Ayush";
    int playerHealth = 100;
    int playerGold = 1000;
    int playerLevel = 1;

    int waveNumber = 1;
    int enemyCount = 10;
    int enemyHealth = 25;

    System.out.println("╔════════════════════════════════════╗");
    System.out.println("║   TOWER DEFENSE GAME - START      ║");
    System.out.println("╚════════════════════════════════════╝");

    System.out.println("\n📊 PLAYER:");
    System.out.println("├─ Name: " + playerName);
    System.out.println("├─ Health: " + playerHealth);
    System.out.println("├─ Gold: " + playerGold);
    System.out.println("└─ Level: " + playerLevel);

    System.out.println("\n👹 WAVE " + waveNumber + ":");
    System.out.println("├─ Enemies: " + enemyCount);
    System.out.println("└─ Enemy Health: " + enemyHealth);

    System.out.println("\n🎮 GAME STARTED!");
    System.out.println("════════════════════════════════════");
  }
}
