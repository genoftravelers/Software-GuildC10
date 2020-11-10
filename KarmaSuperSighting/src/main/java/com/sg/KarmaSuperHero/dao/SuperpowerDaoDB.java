/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.dao;

import com.sg.KarmaSuperHero.dao.HeroDaoDB.HeroMapper;
import com.sg.KarmaSuperHero.dto.Hero;
import com.sg.KarmaSuperHero.dto.Superpower;
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
public class SuperpowerDaoDB implements SuperpowerDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Superpower getSuperpowerById(int id) {
        try {
            final String GET_SUPERPOWER_BY_ID = "SELECT * FROM superpower WHERE superpowerId = ?";
            return jdbc.queryForObject(GET_SUPERPOWER_BY_ID, new SuperpowerMapper(), id);
        } catch (DataAccessException ex) {
        }
        return null;
    }

    @Override
    public List<Superpower> getAllSuperpowers() {
        final String GET_ALL_SUPERPOWERS = "SELECT * FROM superpower";
        return jdbc.query(GET_ALL_SUPERPOWERS, new SuperpowerMapper());
    }

    @Override
    @Transactional
    public Superpower addSuperpower(Superpower superpower) {
        final String INSERT_SUPERPOWER = "INSERT INTO superpower(name)" + "VALUES(?)";
        jdbc.update(INSERT_SUPERPOWER, superpower.getSuperpowerName());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        superpower.setSuperpowerId(newId);
        return superpower;
    }

    @Override
    public void updateSuperpower(Superpower superpower) {
        final String UPDATE_SUPERPOWER = "UPDATE superpower SET name = ? WHERE superpowerId = ?";
        jdbc.update(UPDATE_SUPERPOWER, superpower.getSuperpowerName(), superpower.getSuperpowerId());
    }

    @Override
    public void deleteSuperpowerById(int id) {

        final String GET_ALL_HERO_BY_SUPERPOWER = "SELECT * FROM Hero WHERE superpowerId =?";

        List<Hero> heroes = jdbc.query(GET_ALL_HERO_BY_SUPERPOWER, new HeroMapper(), id);

        for (Hero hero : heroes) {
            final String DELETE_HEROES_FROM_ORGANIZATION = "DELETE FROM HeroOrganization WHERE heroId = ?";
            jdbc.update(DELETE_HEROES_FROM_ORGANIZATION, hero.getHeroId());

            final String DELETE_HEROES_FROM_SIGHTING = "DELETE FROM Sighting WHERE heroId = ?";
            jdbc.update(DELETE_HEROES_FROM_SIGHTING, hero.getHeroId());
            
            final String DELETE_HEROES = "DELETE FROM Hero WHERE heroId = ?";
            jdbc.update(DELETE_HEROES, hero.getHeroId());
        }

        final String DELETE_SUPERPOWER = "DELETE FROM superpower WHERE superpowerId = ?";
        jdbc.update(DELETE_SUPERPOWER, id);

    }

    public static final class SuperpowerMapper implements RowMapper<Superpower> {

        @Override
        public Superpower mapRow(ResultSet rs, int index) throws SQLException {
            Superpower superpower = new Superpower();
            superpower.setSuperpowerId(rs.getInt("superpowerId"));
            superpower.setSuperpowerName(rs.getString("name"));

            return superpower;
        }
    }
}
