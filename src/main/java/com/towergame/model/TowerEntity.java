package com.towergame.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "towers")
public class TowerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "damage")
  private int damage;

  @Column(name = "range")
  private int range;

  @Column(name = "cost")
  private int cost;

  @Column(name = "level")
  private int level;

  @Column(name = "health")
  private int health;

  @Column(name = "x_position")
  private int x;

  @Column(name = "y_position")
  private int y;

  @Column(name = "player_id")
  private Long playerId;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // Constructors
  public TowerEntity() {
    this.createdAt = LocalDateTime.now();
  }

  public TowerEntity(String name, int damage, int range, int cost, int x, int y) {
    this.name = name;
    this.damage = damage;
    this.range = range;
    this.cost = cost;
    this.level = 1;
    this.health = 100;
    this.x = x;
    this.y = y;
    this.createdAt = LocalDateTime.now();
  }

  // Methods
  public int getTotalDamage() {
    return this.damage * this.level;
  }

  public boolean canAttack(int enemyX, int enemyY) {
    int distance = Math.abs(this.x - enemyX) + Math.abs(this.y - enemyY);
    return distance <= this.range;
  }

  public void upgrade() {
    this.level++;
    this.damage = this.damage + 10;
    this.health = 100;
  }

  // Getters & Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public int getRange() {
    return range;
  }

  public void setRange(int range) {
    this.range = range;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(Long playerId) {
    this.playerId = playerId;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
}