package com.unity.game.controller;

import com.unity.game.gameService.GameService;
import com.unity.game.resources.CategoryListRsrc;
import com.unity.game.resources.GamesListRsrc;
import com.unity.game.resources.GamesRsrc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class GamesController {

	@Autowired
	private GameService gamesService;

	@GetMapping(path= "/game", consumes = "application/json", produces = "application/json")
	public GamesRsrc getGame(@RequestParam(value = "gameId", required = false) String gameId,@RequestParam(value = "title", required = false) String title) {
		try {
			GamesRsrc game = this.gamesService.getGame(gameId, title);
			return game;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong on server: "+e,e);
		}
	}

	@PostMapping(path="/game",consumes = "application/json", produces = "application/json") 
	public @ResponseBody GamesRsrc addNewGame (@RequestBody GamesRsrc game) {


		GamesRsrc result = null;
		try {
			result = this.gamesService.addGames(game);
			return result;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong on server: "+e,e);
		}
		
	}

	@GetMapping(path="/games", produces = "application/json")
	public @ResponseBody GamesListRsrc getAllGames(@RequestParam(value = "premium", required = false) String premium) {
		try {
			return this.gamesService.getGamesList(premium);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong on server: "+e,e);
		}
	}

	@GetMapping(path="/categories",produces = "application/json")
	public @ResponseBody CategoryListRsrc getAllCategories() {
		try{
			return this.gamesService.getCategoryList();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong on server: "+e,e);
		}
	}
}
