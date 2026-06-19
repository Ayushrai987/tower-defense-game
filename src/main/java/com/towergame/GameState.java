package com.towergame;

import java.util.ArrayList;
import java.util.HashMap;

public class GameState {

  // ArrayList to store multiple towers
  ArrayList<Tower> towers;

  // ArrayList to store multiple enemies
  ArrayList<Enemy> enemies;

  // HashMap to store game stats
  HashMap<String, Integer> stats;

  // Constructor
  public GameState() {
    this.towers = new ArrayList<>();
    this.enemies = new ArrayList<>();
    this.stats = new HashMap<>();
  }

  // Add tower
  public void addTower(Tower tower) {
    this.towers.add(tower);
    System.out.println("├─ Tower added: " + tower.name);
  }

  // Add enemy
  public void addEnemy(Enemy enemy) {
    this.enemies.add(enemy);
    System.out.println("├─ Enemy spawned: " + enemy.name);
  }

  // Remove dead enemies
  public void removeDeadEnemies() {
    this.enemies.removeIf(enemy -> enemy.isDead());
  }

  // Add stat
  public void addStat(String key, int value) {
    this.stats.put(key, value);
  }

  // Get stat
  public int getStat(String key) {
    return this.stats.getOrDefault(key, 0);
  }

  // Display all towers
  public void displayTowers() {
    System.out.println("\n🏰 ALL TOWERS (" + this.towers.size() + "):");
    for (int i = 0; i < this.towers.size(); i++) {
      Tower t = this.towers.get(i);
      System.out
          .println("├─ " + (i + 1) + ". " + t.name + " (Damage: " + t.getTotalDamage() + ", Health: " + t.health + ")");
    }
  }

  // Display all enemies
  public void displayEnemies() {
    System.out.println("\n👹 ALL ENEMIES (" + this.enemies.size() + "):");
    for (int i = 0; i < this.enemies.size(); i++) {
      Enemy e = this.enemies.get(i);
      System.out.println("├─ " + (i + 1) + ". " + e.name + " (Health: " + e.health + "/" + e.maxHealth + ")");
    }
  }

  // Display stats
  public void displayStats() {
    System.out.println("\n📊 GAME STATS:");
    for (String key : this.stats.keySet()) {
      System.out.println("├─ " + key + ": " + this.stats.get(key));
    }
  }
}