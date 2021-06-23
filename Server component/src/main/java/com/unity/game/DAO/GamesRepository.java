package com.unity.game.DAO;

import java.util.List;

import com.unity.game.model.Games;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface GamesRepository extends CrudRepository<Games, String> {

    Games findByTitle(String title);

    Games findByGameId(Integer gameId);

    @Query(value="select * from games r where r.is_premium IS NULL", nativeQuery = true)
    public List<Games> findNonPremium();
}
