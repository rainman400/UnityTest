package com.unity.game.gameService;

import com.unity.game.resources.CategoryListRsrc;
import com.unity.game.resources.GamesListRsrc;
import com.unity.game.resources.GamesRsrc;

public interface GameService {
    
    public GamesRsrc getGame(String gameId, String title);
    
    public GamesListRsrc getGamesList(String premium);

    public GamesRsrc addGames(GamesRsrc game) throws Exception;

    public CategoryListRsrc getCategoryList();

}
