package com.towergame.service;

import com.towergame.model.TowerEntity;
import com.towergame.repository.TowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TowerService {

  @Autowired
  private TowerRepository towerRepository;

  // Build tower
  public TowerEntity buildTower(String name, int damage, int range, int cost, int x, int y, Long playerId) {
    TowerEntity tower = new TowerEntity(name, damage, range, cost, x, y);
    tower.setPlayerId(playerId);
    return towerRepository.save(tower);
  }

  // Get tower by ID
  public Optional<TowerEntity> getTower(Long id) {
    return towerRepository.findById(id);
  }

  // Get towers by player
  public List<TowerEntity> getPlayerTowers(Long playerId) {
    return towerRepository.findByPlayerId(playerId);
  }

  // Get active towers
  public List<TowerEntity> getActiveTowers(Long playerId) {
    return towerRepository.findActiveByPlayerId(playerId);
  }

  // Upgrade tower
  public TowerEntity upgradeTower(Long towerId) {
    Optional<TowerEntity> tower = towerRepository.findById(towerId);
    if (tower.isPresent()) {
      TowerEntity t = tower.get();
      t.upgrade();
      return towerRepository.save(t);
    }
    return null;
  }

  // Tower takes damage
  public TowerEntity takeDamage(Long towerId, int damage) {
    Optional<TowerEntity> tower = towerRepository.findById(towerId);
    if (tower.isPresent()) {
      TowerEntity t = tower.get();
      t.setHealth(Math.max(0, t.getHealth() - damage));
      return towerRepository.save(t);
    }
    return null;
  }

  // Check if tower can attack
  public boolean canAttack(Long towerId, int enemyX, int enemyY) {
    Optional<TowerEntity> tower = towerRepository.findById(towerId);
    return tower.map(t -> t.canAttack(enemyX, enemyY)).orElse(false);
  }

  // Get total damage
  public int getTotalDamage(Long towerId) {
    Optional<TowerEntity> tower = towerRepository.findById(towerId);
    return tower.map(TowerEntity::getTotalDamage).orElse(0);
  }

  // Delete tower
  public void deleteTower(Long id) {
    towerRepository.deleteById(id);
  }

  // Get all towers
  public List<TowerEntity> getAllTowers() {
    return towerRepository.findAll();
  }
}