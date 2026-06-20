package com.towergame.repository;

import com.towergame.model.TowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TowerRepository extends JpaRepository<TowerEntity, Long> {

  List<TowerEntity> findByName(String name);

  List<TowerEntity> findByPlayerId(Long playerId);

  @Query("SELECT t FROM TowerEntity t WHERE t.playerId = :playerId AND t.health > 0")
  List<TowerEntity> findActiveByPlayerId(Long playerId);
}