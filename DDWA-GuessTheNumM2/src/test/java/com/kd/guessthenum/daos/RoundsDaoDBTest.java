/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kd.guessthenum.daos;

import com.kd.guessthenum.TestApplicationConfiguration;
import com.kd.guessthenum.dtos.Game;
import com.kd.guessthenum.dtos.Rounds;
import java.time.LocalDateTime;
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
public class RoundsDaoDBTest {

    @Autowired
    GameDao gameDao;

    @Autowired
    RoundsDao roundsDao;

    public RoundsDaoDBTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addRounds method, of class RoundsDaoDB.
     */
    @Test
    public void testAddGetRounds() {
        Game game = new Game();
        game.setAnswer("7777");
        game.setStatus(true);

        game = gameDao.addGame(game);

        Rounds rounds = new Rounds();

        rounds.setGameId(game.getGameId());
        rounds.setGuess("some");
        rounds.setTime(LocalDateTime.now().withNano(0));
        rounds.setResult("somethi");
        rounds = roundsDao.addRounds(rounds);

        Rounds fromDao = roundsDao.getRoundsById(rounds.getRoundId());
        assertEquals(rounds, fromDao);
    }

    /**
     * Test of getAllRounds method, of class RoundsDaoDB.
     */
    @Test
    public void testGetAllRounds() {
        Game game = new Game();
        game.setAnswer("0000");
        game.setStatus(true);

        game = gameDao.addGame(game);

        Rounds round = new Rounds();
        round.setGuess("test");
        round.setTime(LocalDateTime.now().withNano(0));
        round.setResult("testres");
        round.setGameId(game.getGameId());

        round = roundsDao.addRounds(round);

        Rounds round2 = new Rounds();
        round2.setGuess("tes2");
        round2.setTime(LocalDateTime.now().withNano(0));
        round2.setResult("testre2");
        round2.setGameId(game.getGameId());
        round2 = roundsDao.addRounds(round2);

        List<Rounds> rounds = roundsDao.getAllRounds(game);

        assertEquals(2, rounds.size());
        assertTrue(rounds.contains(round));
        assertTrue(rounds.contains(round2));

    }

    /**
     * Test of updateRounds method, of class RoundsDaoDB.
     */
    @Test
    public void testUpdateRounds() {

        Game game = new Game();
        game.setAnswer("1111");
        game.setStatus(true);

        game = gameDao.addGame(game);

        Rounds rounds = new Rounds();
        rounds.setGuess("1234");
        rounds.setTime(LocalDateTime.now().withNano(0));
        rounds.setResult("result");
        rounds.setGameId(game.getGameId());
        
        rounds = roundsDao.addRounds(rounds);

        Rounds fromDao = roundsDao.getRoundsById(rounds.getRoundId());

        assertEquals(rounds, fromDao);
        rounds.setGuess("4567");
        roundsDao.updateRounds(rounds);
        fromDao = roundsDao.getRoundsById(rounds.getRoundId());

        assertEquals(rounds, fromDao);

    }

    /**
     * Test of deleteRoundsById method, of class RoundsDaoDB.
     */
    @Test
    public void testDeleteRoundsById() {
        Game game = new Game();
        game.setAnswer("2345");
        game.setStatus(true);

        game = gameDao.addGame(game);
        
        Rounds rounds = new Rounds();
        rounds.setGuess("1234");
        rounds.setTime(LocalDateTime.now().withNano(0));
        rounds.setResult("result");
        rounds.setGameId(game.getGameId());
        
        rounds = roundsDao.addRounds(rounds);
        
        roundsDao.deleteRoundsById(rounds.getRoundId());
        Rounds fromDao = roundsDao.getRoundsById(rounds.getRoundId());
        
        assertNull(fromDao);
        
        
        
    }

}
