/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kd.guessthenum.daos;

import com.kd.guessthenum.dtos.Game;
import com.kd.guessthenum.dtos.Rounds;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalTime;
import static java.time.temporal.TemporalQueries.localTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@Repository
public class RoundsDaoDB implements RoundsDao {

    @Autowired
    JdbcTemplate jdbc;

    public static final class RoundsMapper implements RowMapper<Rounds> {

        @Override
        public Rounds mapRow(ResultSet rs, int index) throws SQLException {
            Rounds rd = new Rounds();
            rd.setRoundId(rs.getInt("roundsId"));
            rd.setGuess(rs.getString("guess"));
            rd.setResult(rs.getString("result"));
            rd.setTime(rs.getTimestamp("time").toLocalDateTime());
            rd.setGameId(rs.getInt("gameId"));

            return rd;

        }
    }

    @Override
    public List<Rounds> getAllRounds(Game game) {
        final String SELECT_ALL_ROUNDS = "SELECT * FROM Rounds WHERE gameId = ?";
        return jdbc.query(SELECT_ALL_ROUNDS, new RoundsMapper(), game.getGameId());
    }

    @Override
    public Rounds getRoundsById(int roundId) {
        try {
            final String SELECT_ROUNDS_BY_ID = "SELECT * FROM rounds WHERE roundsId = ?";
            Rounds rounds = jdbc.queryForObject(SELECT_ROUNDS_BY_ID, new RoundsMapper(), roundId);
            return rounds;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public Rounds addRounds(Rounds rounds) {
        final String INSERT_ROUNDS = "INSERT INTO rounds (guess, time, result, gameId) VALUES (?,?,?,?)";
        jdbc.update(INSERT_ROUNDS,
                rounds.getGuess(),
                Timestamp.valueOf(rounds.getTime()),
                rounds.getResult(),
                rounds.getGameId());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        rounds.setRoundId(newId);
        return rounds;

    }

    @Override
    public void updateRounds(Rounds rounds) {
        final String UPDATE_ROUNDS = "UPDATE Rounds SET guess = ?, result = ?, time = ?, gameId = ? WHERE roundsId = ?";
        jdbc.update(UPDATE_ROUNDS,
                rounds.getGuess(),
                rounds.getResult(),
                Timestamp.valueOf(rounds.getTime()),
                rounds.getGameId(),
                rounds.getRoundId());
    }

    @Override
    public void deleteRoundsById(int roundsId) {

        final String DELETE_ROUNDS = "DELETE FROM Rounds WHERE roundsId = ?";
        jdbc.update(DELETE_ROUNDS, roundsId);
    }

}
