/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.dao;

import com.sg.KarmaSuperHero.dao.SuperpowerDaoDB.SuperpowerMapper;
import com.sg.KarmaSuperHero.dto.Hero;
import com.sg.KarmaSuperHero.dto.Organization;
import com.sg.KarmaSuperHero.dto.Superpower;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class HeroDaoDB implements HeroDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Hero getHeroById(int id) {
        try {
            final String GET_HERO_BY_ID = "SELECT * FROM Hero WHERE heroId = ?";
            Hero hero = jdbc.queryForObject(GET_HERO_BY_ID, new HeroMapper(), id);
            
            hero.setSuperPower(getSuperpowerForHero(id));

            return hero;

        } catch (DataAccessException ex) {
            return null;
        }

    }

    @Override
    public List<Hero> getAllHeroes() {
        final String GET_ALL_HEROES = "SELECT * FROM Hero";
        List<Hero> heroes = jdbc.query(GET_ALL_HEROES, new HeroMapper());

        for (Hero hero : heroes) {
            hero.setSuperPower(getSuperpowerForHero(hero.getHeroId()));
        }
        return heroes;
    }

    @Override
    public Hero addHero(Hero hero) {
        final String INSERT_HERO = "INSERT INTO Hero(name, description, superpowerId) "
                + "VALUES(?,?,?)";
        jdbc.update(INSERT_HERO,
                hero.getHeroName(),
                hero.getHeroDescription(),
                hero.getSuperPower().getSuperpowerId());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        hero.setHeroId(newId);
        
        

        return hero;
    }

    @Override
    public void updateHero(Hero hero) {
        final String UPDATE_HERO = "UPDATE hero SET name = ?, description = ?, "
                + "superpowerId = ? WHERE heroId = ?";
        jdbc.update(UPDATE_HERO,
                hero.getHeroName(),
                hero.getHeroDescription(),
                hero.getSuperPower().getSuperpowerId());

        final String DELETE_HERO_ORGANIZATION = "DELETE FROM HeroOrganization WHERE heroId = ?";
        jdbc.update(DELETE_HERO_ORGANIZATION, hero.getHeroId());
    }

    @Override
    public void deleteHeroById(int id) {
        final String DELETE_HERO_SIGHTING = "DELETE FROM Sighting WHERE heroId = ?";
        jdbc.update(DELETE_HERO_SIGHTING, id);

        final String DELETE_HERO_From_Organization = "DELETE FROM HeroOrganization WHERE heroId = ?";
        jdbc.update(DELETE_HERO_From_Organization, id);

        final String DELETE_HERO = "DELETE FROM Hero WHERE heroId = ?";
        jdbc.update(DELETE_HERO, id);
    }

    @Override
    public List<Hero> getHeroesBySuperpower(Superpower superPower) {
        final String GET_HEROES_BY_SUPERPOWER
                = "SELECT * FROM Hero h "
                + "WHERE h.Superpower_superpowerId = ?";

        List<Hero> heroes = jdbc.query(GET_HEROES_BY_SUPERPOWER,
                new HeroMapper(), superPower.getSuperpowerId());

        for (Hero hero : heroes) {
            hero.setSuperPower(getSuperpowerForHero(hero.getHeroId()));

        }
        return heroes;
    }

    @Override
    public void insertHeroOrganization(Hero hero, List<Integer> orgIds) {
        final String INSERT_HERO_ORGANIZATION = "INSERT INTO "
                + "HeroOrganization(heroId, organizationId) VALUES(?,?)";
        try {
            for (Integer i : orgIds) {
                jdbc.update(INSERT_HERO_ORGANIZATION,
                        hero.getHeroId(),
                        i);
            }
        } catch (NullPointerException ex) {

        }
    }

    @Override
    public List<Hero> getHeroesByOrganization(Organization organization) {
        final String GET_HEROES_BY_ORGANIZATION
                = "SELECT h.heroId, h.name, h.description, h.superpowerId FROM Hero h "
                + " JOIN HeroOrganization ho ON ho.heroId = h.idHero"
                + " WHERE ho.Organization_organizationId = ?";

        List<Hero> heroes = jdbc.query(GET_HEROES_BY_ORGANIZATION,
                new HeroMapper(), organization.getOrganizationId());

        for (Hero hero : heroes) {
            hero.setSuperPower(getSuperpowerForHero(hero.getHeroId()));

        }
        return heroes;

    }

    //Helper Methods
    private Superpower getSuperpowerForHero(int id) {
        final String SELECT_SUPERPOWER_FOR_HERO = "SELECT s.*" + " FROM Superpower s JOIN Hero h ON h.superpowerId = s.superpowerId WHERE h.heroId = ?";
        Superpower thisPower = jdbc.queryForObject(SELECT_SUPERPOWER_FOR_HERO, new SuperpowerMapper(), id);
        return thisPower;
    }

    //Mapper
    public static final class HeroMapper implements RowMapper<Hero> {

        @Override
        public Hero mapRow(ResultSet rs, int i) throws SQLException {
            Hero hero = new Hero();
            hero.setHeroId(rs.getInt("heroId"));
            hero.setHeroName(rs.getString("name"));
            hero.setHeroDescription(rs.getString("description"));

            return hero;

        }

    }

}
