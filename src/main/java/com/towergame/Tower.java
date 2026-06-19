package com.towergame;

public class Tower {

  // Properties
  String name;
  int damage;
  int range;
  int cost;
  int level;
  int health;
  int x, y; // Position

  // Constructor
  public Tower(String name, int damage, int range, int cost, int x, int y) {
    this.name = name;
    this.damage = damage;
    this.range = range;
    this.cost = cost;
    this.level = 1;
    this.health = 100;
    this.x = x;
    this.y = y;
  }

  // Upgrade tower
  public void upgrade() {
    this.level++;
    this.damage = this.damage + 10;
    this.health = 100;
    System.out.println("├─ " + this.name + " upgraded to level " + this.level);
  }

  // Take damage
  public void takeDamage(int damage) {
    this.health -= damage;
    if (this.health < 0)
      this.health = 0;
  }

  // Check if can attack enemy at distance
  public boolean canAttack(int enemyX, int enemyY) {
    int distance = Math.abs(this.x - enemyX) + Math.abs(this.y - enemyY);
    return distance <= this.range;
  }

  // Get total damage (damage * level)
  public int getTotalDamage() {
    return this.damage * this.level;
  }

  // Display tower info
  public void displayInfo() {
    System.out.println("\n🏹 " + this.name);
    System.out.println("├─ Level: " + this.level);
    System.out.println("├─ Damage: " + this.getTotalDamage());
    System.out.println("├─ Range: " + this.range);
    System.out.println("├─ Health: " + this.health);
    System.out.println("└─ Position: (" + this.x + ", " + this.y + ")");
  }
}