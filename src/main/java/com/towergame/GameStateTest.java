package com.towergame;

public class GameStateTest {
  public static void main(String[] args) {

    System.out.println("╔════════════════════════════════════╗");
    System.out.println("║   TOWER DEFENSE - COLLECTIONS     ║");
    System.out.println("╚════════════════════════════════════╝");

    // Create game state
    GameState game = new GameState();

    // Add multiple towers
    System.out.println("\n🏗️ BUILDING TOWERS:");
    game.addTower(new Tower("Archer", 20, 5, 100, 0, 0));
    game.addTower(new Tower("Cannon", 50, 3, 250, 5, 5));
    game.addTower(new Tower("Ice", 15, 6, 150, 10, 10));
    game.displayTowers();

    // Spawn multiple enemies
    System.out.println("\n\n👹 SPAWNING ENEMIES:");
    game.addEnemy(new Enemy("Goblin", 30, 1, 20, 15, 0));
    game.addEnemy(new Enemy("Orc", 50, 2, 50, 18, 0));
    game.addEnemy(new Enemy("Troll", 80, 1, 100, 20, 0));
    game.displayEnemies();

    // Add game stats
    System.out.println("\n\n📊 ADDING STATS:");
    game.addStat("Wave", 1);
    game.addStat("Score", 0);
    game.addStat("Gold Earned", 0);
    game.addStat("Enemies Defeated", 0);
    game.displayStats();

    // Simulate enemies taking damage
    System.out.println("\n\n⚔️ COMBAT:");
    System.out.println("enemies.get(0) takes 20 damage:");
    game.enemies.get(0).takeDamage(20);

    System.out.println("\nenemies.get(1) takes 35 damage:");
    game.enemies.get(1).takeDamage(35);

    System.out.println("\nenemies.get(2) takes 50 damage:");
    game.enemies.get(2).takeDamage(50);

    // Remove dead enemies
    System.out.println("\n\nRemoving dead enemies...");
    game.removeDeadEnemies();
    game.displayEnemies();

    // Update stats
    System.out.println("\n\nUpdating stats...");
    game.addStat("Score", game.getStat("Score") + 150);
    game.addStat("Enemies Defeated", game.getStat("Enemies Defeated") + 1);
    game.displayStats();

    System.out.println("\n════════════════════════════════════");
  }
}