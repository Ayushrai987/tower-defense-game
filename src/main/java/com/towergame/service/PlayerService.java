package com.towergame.service;

import com.towergame.model.PlayerEntity;
import com.towergame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

  @Autowired
  private PlayerRepository playerRepository;

  // Create new player
  public PlayerEntity createPlayer(String name, int health, int gold) {
    PlayerEntity player = new PlayerEntity(name, health, gold);
    return playerRepository.save(player);
  }

  // Get player by ID
  public Optional<PlayerEntity> getPlayer(Long id) {
    return playerRepository.findById(id);
  }

  // Get player by name
  public Optional<PlayerEntity> getPlayerByName(String name) {
    return playerRepository.findByName(name);
  }

  // Update player gold
  public PlayerEntity spendGold(Long playerId, int amount) {
    Optional<PlayerEntity> player = playerRepository.findById(playerId);
    if (player.isPresent() && player.get().getGold() >= amount) {
      PlayerEntity p = player.get();
      p.setGold(p.getGold() - amount);
      return playerRepository.save(p);
    }
    return null;
  }

  // Earn gold
  public PlayerEntity earnGold(Long playerId, int amount) {
    Optional<PlayerEntity> player = playerRepository.findById(playerId);
    if (player.isPresent()) {
      PlayerEntity p = player.get();
      p.setGold(p.getGold() + amount);
      return playerRepository.save(p);
    }
    return null;
  }

  // Take damage
  public PlayerEntity takeDamage(Long playerId, int damage) {
    Optional<PlayerEntity> player = playerRepository.findById(playerId);
    if (player.isPresent()) {
      PlayerEntity p = player.get();
      p.setHealth(Math.max(0, p.getHealth() - damage));
      return playerRepository.save(p);
    }
    return null;
  }

  // Level up
  public PlayerEntity levelUp(Long playerId) {
    Optional<PlayerEntity> player = playerRepository.findById(playerId);
    if (player.isPresent()) {
      PlayerEntity p = player.get();
      p.setLevel(p.getLevel() + 1);
      p.setHealth(100);
      return playerRepository.save(p);
    }
    return null;
  }

  // Add score
  public PlayerEntity addScore(Long playerId, int points) {
    Optional<PlayerEntity> player = playerRepository.findById(playerId);
    if (player.isPresent()) {
      PlayerEntity p = player.get();
      p.setScore(p.getScore() + points);
      return playerRepository.save(p);
    }
    return null;
  }

  // Get top players
  public List<PlayerEntity> getTopPlayers() {
    return playerRepository.findTopPlayers();
  }

  // Delete player
  public void deletePlayer(Long id) {
    playerRepository.deleteById(id);
  }

  // Get all players
  public List<PlayerEntity> getAllPlayers() {
    return playerRepository.findAll();
  }
}