package com.unity.game.factories;

import java.util.List;

import com.unity.game.model.Games;
import com.unity.game.resources.GamesListRsrc;
import com.unity.game.resources.GamesRsrc;

public interface GameResourceFactory {
    public GamesRsrc populate(Games gamesDto, GamesRsrc resource) ;
    public Games applyModel(Games gamesDto, GamesRsrc resource);

    public GamesListRsrc populateGamesList(List<Games> gamesListDto, GamesListRsrc resource);
}
