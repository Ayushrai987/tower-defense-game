package com.towergame;

public class Enemy {

  // Properties
  String name;
  int health;
  int maxHealth;
  int speed;
  int reward; // Gold reward
  int x, y; // Position

  // Constructor
  public Enemy(String name, int health, int speed, int reward, int x, int y) {
    this.name = name;
    this.health = health;
    this.maxHealth = health;
    this.speed = speed;
    this.reward = reward;
    this.x = x;
    this.y = y;
  }

  // Take damage
  public void takeDamage(int damage) {
    this.health -= damage;
    if (this.health < 0)
      this.health = 0;
    System.out.println("├─ " + this.name + " took " + damage + " damage! Health: " + this.health);
  }

  // Move enemy
  public void move() {
    this.x += this.speed;
    System.out.println("├─ " + this.name + " moved to (" + this.x + ", " + this.y + ")");
  }

  // Check if dead
  public boolean isDead() {
    return this.health <= 0;
  }

  // Get health percentage
  public int getHealthPercent() {
    return (this.health * 100) / this.maxHealth;
  }

  // Display enemy info
  public void displayInfo() {
    System.out.println("\n👹 " + this.name);
    System.out.println("├─ Health: " + this.health + "/" + this.maxHealth + " (" + this.getHealthPercent() + "%)");
    System.out.println("├─ Speed: " + this.speed);
    System.out.println("├─ Reward: " + this.reward + " gold");
    System.out.println("└─ Position: (" + this.x + ", " + this.y + ")");
  }
}