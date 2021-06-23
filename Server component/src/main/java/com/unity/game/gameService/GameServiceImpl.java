package com.unity.game.gameService;

import java.util.ArrayList;
import java.util.List;

import com.unity.game.DAO.CategoryRepository;
import com.unity.game.DAO.GamesRepository;
import com.unity.game.DAO.ImageRepository;
import com.unity.game.DAO.TagRepository;
import com.unity.game.factories.CategoryRsrcFactory;
import com.unity.game.factories.GamesRsrcFactory;
import com.unity.game.model.Category;
import com.unity.game.model.Games;
import com.unity.game.model.Image;
import com.unity.game.model.Tag;
import com.unity.game.resources.CategoryListRsrc;
import com.unity.game.resources.GamesListRsrc;
import com.unity.game.resources.GamesRsrc;
import com.unity.game.resources.ImageRsrc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    private GamesRepository gamesRepository;
    @Autowired
    private GamesRsrcFactory gamesRsrcFactory;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryRsrcFactory categoryRsrcFactory;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public GamesRsrc getGame(String gameId, String title) {
        GamesRsrc result = new GamesRsrc();
        Games game = null;
        if(gameId != null) {
            game = this.gamesRepository.findByGameId(Integer.valueOf(gameId));
        } else if (title != null){
            game = this.gamesRepository.findByTitle(title);
        }

        result = gamesRsrcFactory.populate(game, result);
        return result;
    }

    @Override
    public GamesListRsrc getGamesList(String premium) {
        List<Games> gameList = new ArrayList<Games>();
        GamesListRsrc result = new GamesListRsrc();
        if(premium != null && premium.equals("true")){
            this.gamesRepository.findAll().forEach(gameList::add);
        } else {
            this.gamesRepository.findNonPremium().forEach(gameList::add);
        }
        result = gamesRsrcFactory.populateGamesList(gameList,result);
        return result;
    }

    @Override
    public GamesRsrc addGames(GamesRsrc gameRsrc) throws Exception {
        Games game = new Games();
        game = this.gamesRepository.findByTitle(gameRsrc.getTitle());
        if (game != null) {
            throw new Exception("Game already exists");
        }
        if(gameRsrc.getCategory() != null && this.categoryRepository.findByCategory(gameRsrc.getCategory()).size() == 0) {
            throw new Exception("Category doesnt exist");
        } 

        game = new Games();

        game = gamesRsrcFactory.applyModel(game, gameRsrc);
        game = this.gamesRepository.save(game);
        if(gameRsrc.getTags() != null && gameRsrc.getTags().size() > 0) {
            for(String tagString : gameRsrc.getTags()){
                Tag tag = new Tag();
                tag.setTagText(tagString);
                tag.setGame(game);
                this.tagRepository.save(tag);
            }           
        }
        if(gameRsrc.getImages() != null && gameRsrc.getImages().size() > 0) {
            for(ImageRsrc imageRsrc : gameRsrc.getImages()){
                Image image = new Image();
                image.setUrl(imageRsrc.getUrl());
                image.setType(imageRsrc.getType());
                image.setGame(game);
                this.imageRepository.save(image);
            }          
        }
        gameRsrc = gamesRsrcFactory.populate(game, gameRsrc);
        return gameRsrc;
        
    }

    @Override
    public CategoryListRsrc getCategoryList() {
        List<Category> categoryList = new ArrayList<Category>();
        CategoryListRsrc result = new CategoryListRsrc();
        this.categoryRepository.findAll().forEach(categoryList::add);
        result = categoryRsrcFactory.populateCategoriesList(categoryList,result);
        return result;
    }
    
}
