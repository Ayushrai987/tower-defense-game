package com.towergame;

public class Game {

    // Game state
    Player player;
    Tower tower1, tower2;
    Enemy enemy1, enemy2;
    int waveNumber;
    boolean gameRunning;

    // Constructor
    public Game() {
        this.player = new Player("Umesh", 100, 500);
        this.tower1 = new Tower("Archer", 20, 5, 100, 0, 0);
        this.tower2 = new Tower("Cannon", 50, 3, 250, 5, 5);
        this.enemy1 = new Enemy("Goblin", 30, 1, 20, 10, 0);
        this.enemy2 = new Enemy("Orc", 50, 2, 50, 12, 0);
        this.waveNumber = 1;
        this.gameRunning = true;
    }

    // Start game
    public void startGame() {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║   TOWER DEFENSE GAME - COMPLETE    ║");
        System.out.println("╚════════════════════════════════════╝");

        this.player.displayStats();
        this.tower1.displayInfo();
        this.tower2.displayInfo();
        this.enemy1.displayInfo();
        this.enemy2.displayInfo();
    }

    // Simulate battle
    public void simulateBattle() {
        System.out.println("\n\n⚔️ BATTLE SIMULATION - WAVE " + this.waveNumber);

        // Enemy 1 attacks tower 1
        System.out.println("\n👹 Goblin attacks Archer Tower:");
        this.tower1.takeDamage(10);

        // Tower 1 attacks enemy 1
        System.out.println("\n🏹 Archer Tower attacks Goblin:");
        if (this.tower1.canAttack(this.enemy1.x, this.enemy1.y)) {
            this.enemy1.takeDamage(this.tower1.getTotalDamage());
        } else {
            System.out.println("├─ Out of range!");
        }

        // Enemy moves
        System.out.println("\n📍 Enemies move:");
        this.enemy1.move();
        this.enemy2.move();

        // Check if enemy defeated
        if (this.enemy1.isDead()) {
            System.out.println("\n✅ Goblin defeated!");
            this.player.earnGold(this.enemy1.reward);
            this.player.addScore(100);
        }

        // Player takes damage from enemy 2
        System.out.println("\n💥 Orc attacks player:");
        this.player.takeDamage(15);

        // Tower upgrade
        System.out.println("\n🚀 Upgrade tower:");
        this.tower1.upgrade();
    }

    // Check game status
    public void checkGameStatus() {
        System.out.println("\n\n📊 GAME STATUS:");
        if (!this.player.isAlive()) {
            System.out.println("❌ GAME OVER - Player defeated!");
            this.gameRunning = false;
        } else if (this.enemy1.isDead() && this.enemy2.isDead()) {
            System.out.println("✅ WAVE " + this.waveNumber + " WON!");
            System.out.println("🌊 Moving to next wave...");
            this.waveNumber++;
        } else {
            System.out.println("⚔️ Battle ongoing...");
        }
        this.player.displayStats();
    }

    // Main game loop
    public void run() {
        this.startGame();
        this.simulateBattle();
        this.checkGameStatus();
        this.simulateBattle();
        this.checkGameStatus();

        System.out.println("\n════════════════════════════════════");
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}