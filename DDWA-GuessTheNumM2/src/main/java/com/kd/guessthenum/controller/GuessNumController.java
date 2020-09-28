/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kd.guessthenum.controller;

import com.kd.guessthenum.dtos.Game;
import com.kd.guessthenum.dtos.Rounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.kd.guessthenum.service.GuessNumService;
import com.kd.guessthenum.service.NotFoundException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@RestController
public class GuessNumController {

    @Autowired
    GuessNumService service;

    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public int startGame() {
        Game beginGame = service.generateNum();//test this
        return beginGame.getGameId();
    }

    @PostMapping("/guess")
    @ResponseStatus(HttpStatus.CREATED)
    public Rounds checkGuess(@RequestBody Rounds rounds) throws Exception {

//           try{
        return service.calculateResult(rounds);//test this
//           }catch(InvalidNumException e){
//               throw new InvalidNumException(e.getMessage(), e);
//           }

    }

    @GetMapping("/game")
    public List<Game> getAllGames() throws Exception {

        List<Game> listOfGames = service.getAllGames();

        for (Game game : listOfGames) {
            if (!game.isStatus()) {
                game.setAnswer("****");
            }
        }
        return listOfGames;

    }

    @GetMapping("/game/{gameId}")
    public Game getGameById(@PathVariable int gameId) throws NotFoundException {
        Game game = service.getGameById(gameId);
        if (!game.isStatus()) {
            game.setAnswer("****");
        }
        return game;
    }

    @GetMapping("/rounds/{gameId}")
    public List<Rounds> getAllRounds(@PathVariable int gameId) throws NotFoundException {
        return service.getAllRounds(gameId);
    }

}
