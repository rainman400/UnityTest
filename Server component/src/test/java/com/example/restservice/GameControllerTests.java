/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.restservice;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.unity.game.RestServiceApplication;
import com.unity.game.DAO.GamesRepository;
import com.unity.game.controller.GamesController;
import com.unity.game.factories.GamesRsrcFactory;
import com.unity.game.model.Games;
import com.unity.game.resources.GamesListRsrc;
import com.unity.game.resources.GamesRsrc;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RestServiceApplication.class)
public class GameControllerTests {


	@Autowired
	private GamesController gamesController;
	@Autowired
	private GamesRepository gamesRepository;
	@Autowired
	private GamesRsrcFactory gamesRsrcFactory;

	@Test
	public void TestGetEndpoint() throws Exception {
		assertNotNull(gamesController);

		GamesListRsrc listRsrc = gamesController.getAllGames("false");
		assertNotNull(listRsrc);
		assertNotNull(listRsrc.getListings());
		assertNotEquals(listRsrc.getListings().size(), 0);

		GamesRsrc gameRsrc = listRsrc.getListings().get(0);
		GamesRsrc check = gamesController.getGame(gameRsrc.getGameId().toString(),"");
		assertNotNull(check);
		assertEquals(gameRsrc.getSubtitle(), check.getSubtitle());
		assertEquals(gameRsrc.getAuthor(), check.getAuthor());
		assertEquals(gameRsrc.getCategory(), check.getCategory());
		assertEquals(gameRsrc.getReplayBundleUrl(), check.getReplayBundleUrl());
		assertEquals(gameRsrc.getTitle(), check.getTitle());

		GamesRsrc addGame = new GamesRsrc();

		assertThrows(Exception.class, ()->{gamesController.addNewGame(addGame);});
		double rand = Math.random();
		addGame.setTitle(String.valueOf(rand));
		assertDoesNotThrow(()->{gamesController.addNewGame(addGame);});
		assertThrows(Exception.class, ()->{gamesController.addNewGame(addGame);});

		Games addGameDto = new Games();
		gamesRsrcFactory.applyModel(addGameDto, addGame);
		gamesRepository.delete(addGameDto);
		 		
	}


}
