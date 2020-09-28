/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kd.guessthenum.daos;

import com.kd.guessthenum.dtos.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@Repository
public class GameDaoDB implements GameDao {

    @Autowired
    JdbcTemplate jdbc;

    public static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game gm = new Game();
            gm.setGameId(rs.getInt("gameId"));
            gm.setAnswer(rs.getString("answer"));
            gm.setStatus(rs.getBoolean("status"));

            return gm;

        }
    }

    @Override
    public List<Game> getAllGames() {
        final String SELECT_ALL_GAMES = "SELECT * FROM Game";
        return jdbc.query(SELECT_ALL_GAMES, new GameMapper());
    }
;
    @Override
    public Game getGameById(int gameId) {
        try {
            final String SELECT_GAME_BY_ID = "SELECT * FROM Game WHERE gameId = ?";
            return jdbc.queryForObject(SELECT_GAME_BY_ID, new GameMapper(), gameId);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public Game addGame(Game game) { //status = true, answer = 1234, gameId= 1
        final String INSERT_GAME = "INSERT INTO Game(answer, status) VALUES(?,?)";
        jdbc.update(INSERT_GAME, 
                game.getAnswer(),
                game.isStatus());
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setGameId(newId);
        return game;
    }

    @Override
    public void updateGame(Game game) {
        final String UPDATE_GAME = "UPDATE Game SET answer = ?, status = ? WHERE gameId = ?";
        jdbc.update(UPDATE_GAME,
                game.getAnswer(),
                game.isStatus(),
                game.getGameId());
                
    }

    @Override
    @Transactional
    public void deleteGameById(int gameId) {
        final String DELETE_GAME_BY_ROUNDS = "DELETE FROM Rounds WHERE gameId = ? ";
        jdbc.update(DELETE_GAME_BY_ROUNDS, gameId);
        
        final String DELETE_GAME = "DELETE FROM Game WHERE gameId = ?";
        jdbc.update(DELETE_GAME, gameId);
    }

}
