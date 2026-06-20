package com.towergame.repository;

import com.towergame.model.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

  Optional<PlayerEntity> findByName(String name);

  @Query("SELECT p FROM PlayerEntity p ORDER BY p.score DESC")
  List<PlayerEntity> findTopPlayers();

  @Query("SELECT p FROM PlayerEntity p WHERE p.score > :score ORDER BY p.score DESC")
  List<PlayerEntity> findPlayersAboveScore(int score);
}