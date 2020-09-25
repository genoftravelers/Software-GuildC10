/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kd.guessthenum.service;

import com.kd.guessthenum.dtos.Game;
import com.kd.guessthenum.dtos.Rounds;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface GuessNumService {

    //   Game addGame(Game game);
//    Rounds addRounds(Rounds round);
    Game getGameById(int gameId);

    List<Game> getAllGames() throws NotFoundException;

    List<Rounds> getAllRounds(int gameId) throws NotFoundException;

    Rounds getRoundsById(int gameId);

    Game generateNum();

    Rounds calculateResult(Rounds rounds) throws Exception;

    String validateGuessNum(String guess) throws Exception;

}
