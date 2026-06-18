package com.towergame;

public class Player {
    
    // ===== PROPERTIES (Variables) =====
    String name;
    int health;
    int gold;
    int level;
    int score;
    
    // ===== CONSTRUCTOR (Initialize object) =====
    public Player(String name, int health, int gold) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.level = 1;
        this.score = 0;
    }
    
    // ===== METHODS (Actions) =====
    
    // Method 1: Take damage
    public void takeDamage(int damage) {
        this.health = this.health - damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println("├─ " + this.name + " took " + damage + " damage! Health: " + this.health);
    }
    
    // Method 2: Heal
    public void heal(int amount) {
        this.health = this.health + amount;
        if (this.health > 100) {
            this.health = 100;
        }
        System.out.println("├─ " + this.name + " healed " + amount + "! Health: " + this.health);
    }
    
    // Method 3: Spend gold
    public boolean spendGold(int amount) {
        if (this.gold >= amount) {
            this.gold = this.gold - amount;
            System.out.println("├─ " + this.name + " spent " + amount + " gold! Remaining: " + this.gold);
            return true;
        } else {
            System.out.println("├─ " + this.name + " not enough gold! Need: " + amount);
            return false;
        }
    }
    
    // Method 4: Earn gold
    public void earnGold(int amount) {
        this.gold = this.gold + amount;
        System.out.println("├─ " + this.name + " earned " + amount + " gold! Total: " + this.gold);
    }
    
    // Method 5: Level up
    public void levelUp() {
        this.level = this.level + 1;
        this.health = 100;  // Full health on level up
        System.out.println("├─ " + this.name + " leveled up to " + this.level + "!");
    }
    
    // Method 6: Add score
    public void addScore(int points) {
        this.score = this.score + points;
        System.out.println("├─ " + this.name + " earned " + points + " points! Total: " + this.score);
    }
    
    // Method 7: Check if alive
    public boolean isAlive() {
        return this.health > 0;
    }
    
    // Method 8: Display stats
    public void displayStats() {
        System.out.println("\n📊 " + this.name + "'s STATS:");
        System.out.println("├─ Health: " + this.health);
        System.out.println("├─ Gold: " + this.gold);
        System.out.println("├─ Level: " + this.level);
        System.out.println("├─ Score: " + this.score);
        System.out.println("└─ Status: " + (this.isAlive() ? "ALIVE ✅" : "DEAD ❌"));
    }
}