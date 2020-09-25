/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kd.guessthenum.service;

import com.kd.guessthenum.TestApplicationConfiguration;
import com.kd.guessthenum.daos.GameDao;
import com.kd.guessthenum.daos.RoundsDao;
import com.kd.guessthenum.dtos.Game;
import com.kd.guessthenum.dtos.Rounds;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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
public class GuessNumServiceImplTest {

    @Autowired
    GameDao gameDao;

    @Autowired
    RoundsDao roundsDao;

    @Autowired
    GuessNumService testService;

    @Autowired
    GuessNumServiceImpl testHelper;

    public GuessNumServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
//        List<Rounds> rounds = roundsDao.getAllRounds();
//        for (Rounds round : rounds) {
//            roundsDao.deleteRoundsById(round.getRoundId());
//        }

        List<Game> games = gameDao.getAllGames();
        for (Game game : games) {
            gameDao.deleteGameById(game.getGameId());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addGame method, of class ServiceImpl.
     */
    @Test//you shouldn't be setting the status and answer explicitely, that should automatically be done in service.
    public void testAddGetGame() {//service to create new game not Dao.

        Game game = testService.generateNum();

//       
        //arrange
        Game fromService = testService.getGameById(game.getGameId());

        assertEquals(game, fromService);

    }

    /**
     * Test of getAllGames method, of class ServiceImpl.
     */
    @Test
    public void testAddGetAllGames() throws Exception {
        //arrange
        Game game1 = testService.generateNum();

        Game game2 = testService.generateNum();

        //act
        List<Game> allGames = testService.getAllGames();
        //assert
        assertEquals(2, allGames.size());
        assertTrue(allGames.contains(game1));
        assertTrue(allGames.contains(game2));

    }

    /**
     * Test of getAllRounds method, of class ServiceImpl.
     */
    @Test
    public void testGetAllRounds() throws Exception {

        Game game = testService.generateNum();

        Rounds round = new Rounds();
        round.setGuess("1234");
        round.setTime(LocalDateTime.now().withNano(0));
        round.setResult("e:1:p:0");
        round.setGameId(game.getGameId());

        round = testService.calculateResult(round);

        Rounds round2 = new Rounds();
        round2.setGuess("1287");
        round2.setTime(LocalDateTime.now().withNano(0));
        round2.setResult("e:2:p:0");
        round2.setGameId(game.getGameId());
        // by Calculating the  result it would add the round to the game.
        round2 = testService.calculateResult(round2);

        List<Rounds> rounds = testService.getAllRounds(game.getGameId());

        assertEquals(2, rounds.size());
        assertTrue(rounds.contains(round));
        assertTrue(rounds.contains(round2));

    }

    /**
     * Test of addRounds method, of class ServiceImpl.
     */
    @Test
    public void testAddGetRounds() throws Exception {
        Game game = testService.generateNum();

        Rounds rounds = new Rounds();
        rounds.setGameId(game.getGameId());
        rounds.setGuess("1234");
        rounds.setTime(LocalDateTime.now().withNano(0));
        rounds.setResult("e:2:p:2");
        rounds = testService.calculateResult(rounds);

        Rounds fromService = testService.getRoundsById(rounds.getRoundId());
        assertEquals(rounds, fromService);

    }

    @Test
    public void testGenerateNum() {//-> combine generate num and add game
        /*You essentially want to make sure that the number that you generate satisfies the requirements that they gave: 
        (1) non-repeating digits and  (2) four-digits long. For test (1) you can use  regex to easily check for repeats.
         For test (2), if you do it T's way, this will be tested at the same time...
        If his regex string has * at the end, you may have to change it to {4}. I can't remember what he ended with now.*/
        //ARRANGE
        Game testGame = testService.generateNum();

        String answer = testGame.getAnswer();

        //ACT
        boolean pattern = answer.matches("[0-9]{4}");// true pattern.

        //length has to be four, if duplicated, counter won't count
        // goes through each character, counts them and then checks if it is distinct and if so, it will count otherwise it will not count.
        boolean counter = (answer.length() == answer.chars().distinct().count());

        //ASSERT
        assertEquals(answer.length(), 4);
        assertTrue(counter);// non repeating
        assertTrue(pattern);// non repeating
    }

    @Test
    public void testCalculateResult() throws Exception {//
        /*
    For the calculate result, you just want to make sure that you get the right calculation
    based on the guess that you give it, so maybe you want to try out a few combos where
    you can get (1) all exact matches, (2) all partial, (3) some partial, some exact,
    maybe 2 of these, and maybe (4) no partial and no exact. So you would need to
    create a game and add it to the DB. Then go peek at the DB to see what the answer
    is and just make a bunch of rounds with those above options and see if the "result" 
    will match what you expected it to be.
         */
        //arrange
        Game gameTest = testService.generateNum();

        Rounds exactRounds = new Rounds();
        exactRounds.setGameId(gameTest.getGameId());

        //all exact 
        exactRounds.setGuess(gameTest.getAnswer());
        //Act
        Rounds rounding = testService.calculateResult(exactRounds);
        String result = rounding.getResult();

        Game gameAfterUpdate = testService.getGameById(gameTest.getGameId());
        //ASSERT
        assertEquals(result, "e:4:p:0");
        assertTrue(gameAfterUpdate.isStatus());

    }

    @Test
    public void validateGuessNum() throws Exception {

        String userGuess = "123";

        try {
            testService.validateGuessNum(userGuess);
            fail("This should throw exception");

        } catch (Exception e) {
            return;
        }

    }

    @Test
    public void validateCorrectDigit() throws Exception {
        String fourDigits = "1234";

        try {
            testService.validateGuessNum(fourDigits);

        } catch (Exception e) {
            fail("No Exceptions should be thrown.");

        }

    }

    @Test
    public void validateNonDigits() throws Exception {
        String letterDigits = "abcd";
        try {
            testService.validateGuessNum(letterDigits);
            fail("This should throw exceptions");
        } catch (Exception e) {

        }

        //partial match
    }

    @Test
    public void validateDuplicateDigit() throws Exception {
        String duplicateDigits = "1233";

        try {
            testService.validateGuessNum(duplicateDigits);
            fail("Duplicate exception should be thrown.");

//          
        } catch (Exception e) {

        }
    }

}
