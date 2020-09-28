/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kd.guessthenum.service;

import org.springframework.stereotype.Service;
import com.kd.guessthenum.daos.GameDao;
import com.kd.guessthenum.daos.RoundsDao;
import com.kd.guessthenum.dtos.Game;
import com.kd.guessthenum.dtos.Rounds;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@Service
public class GuessNumServiceImpl implements GuessNumService {

    @Autowired
    RoundsDao roundsDao;

    @Autowired
    GameDao gameDao;

   // @Override
    private Game addGame(Game game) {
        return gameDao.addGame(game);
    }

   // @Override
    private Rounds addRounds(Rounds round) {
        return roundsDao.addRounds(round);
    }

    @Override
    public Game getGameById(int gameId) {
        Game game = gameDao.getGameById(gameId);

        return game;
    }

    @Override
    public List<Game> getAllGames() throws NotFoundException {
        List<Game> listOfGame = gameDao.getAllGames();

        return listOfGame;
    }

    @Override
    public List<Rounds> getAllRounds(int gameId) throws NotFoundException {
        //getting the game for the gameId thats passed in
        Game game = gameDao.getGameById(gameId);

        // Then pass in that game to get all the rounds for it
        List<Rounds> listOfRounds = roundsDao.getAllRounds(game);
        return listOfRounds;
    }

    @Override
    public Rounds getRoundsById(int gameId) {
        return roundsDao.getRoundsById(gameId);
    }

    @Override
    public Game generateNum() {
        Game newGame = new Game();

        Random rm = new Random();

        Set<Integer> answer1 = new HashSet<>(); //generating random numbers of 4.

        while (answer1.size() < 4) {

            answer1.add(rm.nextInt(10));
        }
        String gNum = "";

        for (Integer integer : answer1) { //go through each integer inside answer and add on it.
            gNum += integer;
        }
        newGame.setAnswer(gNum);

        newGame = addGame(newGame); //newGame includes the new data.

        return newGame;

    }

    @Override
    public Rounds calculateResult(Rounds rounds) throws Exception {
        String guess = rounds.getGuess();

        validateGuessNum(guess);

        Game game = gameDao.getGameById(rounds.getGameId());

        if (game.getAnswer().equals(rounds.getGuess())) {
            game.setStatus(true);
            rounds.setResult("e:4:p:0");

        } else {
            int exactC = 0;
            int partialC = 0;
            for (int i = 0; i < guess.length(); i++) {
                if (guess.charAt(i) == game.getAnswer().charAt(i)) {
                    exactC++;
                } else if (guess.contains(String.valueOf(game.getAnswer().charAt(i)))
                        && guess.charAt(i) != game.getAnswer().charAt(i)) {
                    partialC++;
                }
            }

            rounds.setResult("e:" + exactC + ":p:" + partialC);

        }
        rounds.setTime(LocalDateTime.now().withNano(0));
        Rounds nextRound = roundsDao.addRounds(rounds);
        gameDao.updateGame(game);

        return nextRound;
    }

    @Override
    public String validateGuessNum(String guess) throws Exception {

        if (!guess.matches("[0-9]{4}")) {
            throw new InvalidNumException("Only 4 digits allowed from 0-9.");
        }

        //  return guess;
        Set<Integer> guessSet = new TreeSet<>();
        for (int i = 0; i < guess.length(); i++) {
            guessSet.add(Integer.valueOf(guess.charAt(i)));
        }

        if (guessSet.size() != 4) {
            throw new InvalidNumException("Generated values should not have duplicated values.");
        } else {
            return guess;
        }

//        Set<Character> characters = new HashSet<>();
//        // loop all characters in string
//      
//        for (int i = 0; i < guess.length(); i++) {   // 1134    //1+
//             // construct a object (may be use internal JDK cache)
//            Character c = guess.charAt(i);
//            
//             if (!characters.contains(c)) {
//                characters.add(c);
//            } 
//           
//            
//            // check if character is already found
//           
//        }
//        if(characters.size()!=4){
//            throw new InvalidNumException("No duplicate digits allowed.");
//        } else {
//            return guess;
//        }
    }
}
