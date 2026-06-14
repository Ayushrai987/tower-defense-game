package com.towergame;

public class TowerInventory {
  public static void main(String[] args) {

    String tower1Name = "Archer Tower";
    int tower1Damage = 20;
    int tower1Range = 5;
    int tower1Cost = 100;
    double tower1FireRate = 1.5;

    String tower2Name = "Cannon Tower";
    int tower2Damage = 50;
    int tower2Range = 3;
    int tower2Cost = 250;
    double tower2FireRate = 0.8;

    String tower3Name = "Ice Tower";
    int tower3Damage = 15;
    int tower3Range = 6;
    int tower3Cost = 150;
    double tower3FireRate = 2.0;

    System.out.println("========== TOWER INVENTORY ==========");

    System.out.println("\n1. " + tower1Name);
    System.out.println("   Damage: " + tower1Damage);
    System.out.println("   Range: " + tower1Range);
    System.out.println("   Cost: " + tower1Cost + " gold");
    System.out.println("   Fire Rate: " + tower1FireRate);

    System.out.println("\n2. " + tower2Name);
    System.out.println("   Damage: " + tower2Damage);
    System.out.println("   Range: " + tower2Range);
    System.out.println("   Cost: " + tower2Cost + " gold");
    System.out.println("   Fire Rate: " + tower2FireRate);

    System.out.println("\n3. " + tower3Name);
    System.out.println("   Damage: " + tower3Damage);
    System.out.println("   Range: " + tower3Range);
    System.out.println("   Cost: " + tower3Cost + " gold");
    System.out.println("   Fire Rate: " + tower3FireRate);

    System.out.println("\n=====================================");
  }
}