package com.towergame.controller;

import com.towergame.model.PlayerEntity;
import com.towergame.model.TowerEntity;
import com.towergame.service.PlayerService;
import com.towergame.service.TowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "*")
public class GameController {

  @Autowired
  private PlayerService playerService;

  @Autowired
  private TowerService towerService;

  // ===== PLAYER ENDPOINTS =====

  @PostMapping("/player/create")
  public ResponseEntity<?> createPlayer(@RequestParam String name) {
    PlayerEntity player = playerService.createPlayer(name, 100, 500);
    Map<String, Object> response = new HashMap<>();
    response.put("success", true);
    response.put("message", "Player created successfully");
    response.put("player", player);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/player/{id}")
  public ResponseEntity<?> getPlayer(@PathVariable Long id) {
    Optional<PlayerEntity> player = playerService.getPlayer(id);
    if (player.isPresent()) {
      return ResponseEntity.ok(player.get());
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found");
  }

  @GetMapping("/player/name/{name}")
  public ResponseEntity<?> getPlayerByName(@PathVariable String name) {
    Optional<PlayerEntity> player = playerService.getPlayerByName(name);
    if (player.isPresent()) {
      return ResponseEntity.ok(player.get());
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found");
  }

  @GetMapping("/players/top")
  public ResponseEntity<?> getTopPlayers() {
    List<PlayerEntity> players = playerService.getTopPlayers();
    Map<String, Object> response = new HashMap<>();
    response.put("count", players.size());
    response.put("players", players);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/player/{id}/spend-gold")
  public ResponseEntity<?> spendGold(@PathVariable Long id, @RequestParam int amount) {
    PlayerEntity player = playerService.spendGold(id, amount);
    if (player != null) {
      Map<String, Object> response = new HashMap<>();
      response.put("success", true);
      response.put("message", "Gold spent successfully");
      response.put("gold", player.getGold());
      return ResponseEntity.ok(response);
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not enough gold");
  }

  @PostMapping("/player/{id}/earn-gold")
  public ResponseEntity<?> earnGold(@PathVariable Long id, @RequestParam int amount) {
    PlayerEntity player = playerService.earnGold(id, amount);
    Map<String, Object> response = new HashMap<>();
    response.put("gold", player.getGold());
    return ResponseEntity.ok(response);
  }

  @PostMapping("/player/{id}/take-damage")
  public ResponseEntity<?> takeDamage(@PathVariable Long id, @RequestParam int damage) {
    PlayerEntity player = playerService.takeDamage(id, damage);
    Map<String, Object> response = new HashMap<>();
    response.put("health", player.getHealth());
    response.put("alive", player.getHealth() > 0);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/player/{id}/level-up")
  public ResponseEntity<?> levelUp(@PathVariable Long id) {
    PlayerEntity player = playerService.levelUp(id);
    Map<String, Object> response = new HashMap<>();
    response.put("level", player.getLevel());
    response.put("health", player.getHealth());
    return ResponseEntity.ok(response);
  }

  @PostMapping("/player/{id}/add-score")
  public ResponseEntity<?> addScore(@PathVariable Long id, @RequestParam int points) {
    PlayerEntity player = playerService.addScore(id, points);
    Map<String, Object> response = new HashMap<>();
    response.put("score", player.getScore());
    return ResponseEntity.ok(response);
  }

  // ===== TOWER ENDPOINTS =====

  @PostMapping("/tower/build")
  public ResponseEntity<?> buildTower(
      @RequestParam String name,
      @RequestParam int damage,
      @RequestParam int range,
      @RequestParam int cost,
      @RequestParam int x,
      @RequestParam int y,
      @RequestParam Long playerId) {
    TowerEntity tower = towerService.buildTower(name, damage, range, cost, x, y, playerId);
    Map<String, Object> response = new HashMap<>();
    response.put("success", true);
    response.put("message", "Tower built successfully");
    response.put("tower", tower);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/tower/{id}")
  public ResponseEntity<?> getTower(@PathVariable Long id) {
    Optional<TowerEntity> tower = towerService.getTower(id);
    if (tower.isPresent()) {
      return ResponseEntity.ok(tower.get());
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tower not found");
  }

  @GetMapping("/player/{playerId}/towers")
  public ResponseEntity<?> getPlayerTowers(@PathVariable Long playerId) {
    List<TowerEntity> towers = towerService.getPlayerTowers(playerId);
    Map<String, Object> response = new HashMap<>();
    response.put("count", towers.size());
    response.put("towers", towers);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/tower/{id}/upgrade")
  public ResponseEntity<?> upgradeTower(@PathVariable Long id) {
    TowerEntity tower = towerService.upgradeTower(id);
    if (tower != null) {
      Map<String, Object> response = new HashMap<>();
      response.put("level", tower.getLevel());
      response.put("damage", tower.getTotalDamage());
      return ResponseEntity.ok(response);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tower not found");
  }

  @PostMapping("/tower/{id}/attack")
  public ResponseEntity<?> attackWithTower(@PathVariable Long id, @RequestParam int enemyX, @RequestParam int enemyY) {
    boolean canAttack = towerService.canAttack(id, enemyX, enemyY);
    int damage = towerService.getTotalDamage(id);

    Map<String, Object> response = new HashMap<>();
    response.put("canAttack", canAttack);
    response.put("damage", damage);
    return ResponseEntity.ok(response);
  }

  // ===== GAME INFO =====

  @GetMapping("/health")
  public ResponseEntity<?> health() {
    Map<String, Object> response = new HashMap<>();
    response.put("status", "OK");
    response.put("message", "Tower Defense API is running");
    response.put("version", "1.0");
    return ResponseEntity.ok(response);
  }
}