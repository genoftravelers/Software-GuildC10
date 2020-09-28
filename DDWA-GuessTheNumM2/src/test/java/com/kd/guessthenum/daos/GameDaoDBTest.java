/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kd.guessthenum.daos;

import com.kd.guessthenum.TestApplicationConfiguration;
import com.kd.guessthenum.dtos.Game;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class GameDaoDBTest {

    @Autowired
    GameDao gameDao;

    @Autowired
    RoundsDao roundsDao;

    public GameDaoDBTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        List<Game> games = gameDao.getAllGames();
        for (Game game : games) {
            gameDao.deleteGameById(game.getGameId());
        }
//        List<Rounds> rounds = roundsDao.getAllRounds();
//        for (Rounds round : rounds) {
//            roundsDao.deleteRoundsById(round.getGameId());
//        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addGame method, of class GameDaoDB.
     */
    @Test
    public void testAddGetGame() {
        Game game = new Game();
        game.setAnswer("1234");
        game.setStatus(true);
        game = gameDao.addGame(game);

        Game fromDao = gameDao.getGameById(game.getGameId());
        assertEquals(game, fromDao);
    }

    /**
     * Test of getAllGames method, of class GameDaoDB.
     */
    @Test
    public void testGetAllGames() {
        Game game = new Game();
        game.setAnswer("2431");
        game.setStatus(true);

        gameDao.addGame(game);

        Game game2 = new Game();
        game2.setAnswer("1456");
        game2.setStatus(true);

        gameDao.addGame(game2);

        List<Game> games = gameDao.getAllGames();

        assertEquals(2, games.size());
        assertTrue(games.contains(game));
        assertTrue(games.contains(game2));

    }

    /**
     * Test of updateGame method, of class GameDaoDB.
     */
    @Test
    public void testUpdateGame() {
        Game game = new Game();
        game.setAnswer("9999");
        game.setStatus(true);
        game = gameDao.addGame(game);

        Game fromDao = gameDao.getGameById(game.getGameId());

        assertEquals(game, fromDao);
        game.setAnswer("8888");
        // game.setStatus(true);
        gameDao.updateGame(game);
        fromDao = gameDao.getGameById(game.getGameId());

        assertEquals(game, fromDao);
    }

    /**
     * Test of deleteGameById method, of class GameDaoDB.
     */
    @Test
    public void testDeleteGameById() {
        Game game = new Game();
        game.setAnswer("6666");
        game.setStatus(true);
        game = gameDao.addGame(game);

        //  List<Game> games = new ArrayList<>();
        //   games.add(game);
        gameDao.deleteGameById(game.getGameId());
        Game fromDao = gameDao.getGameById(game.getGameId());

        assertNull(fromDao);

    }

}
