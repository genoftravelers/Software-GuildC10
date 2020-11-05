/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.dao;

import com.sg.KarmaSuperHero.dao.HeroDaoDB.HeroMapper;
import com.sg.KarmaSuperHero.dto.Hero;
import com.sg.KarmaSuperHero.dto.Location;
import com.sg.KarmaSuperHero.dto.Organization;
import com.sg.KarmaSuperHero.dto.Sighting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@Repository
public class SightingDaoDB implements SightingDao {

    @Autowired
    JdbcTemplate jdbc;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-YYYY");

    @Override
    public Sighting getSightingById(int id) {
        try {
            final String GET_SIGHTING_BY_ID = "SELECT * FROM Sighting WHERE sightingId = ?";
            Sighting sighting = jdbc.queryForObject(GET_SIGHTING_BY_ID, new SightingMapper(), id);
            sighting.setHero(getHeroForSighting(sighting.getSightingId()));
            sighting.setLocation(getLocationForSighting(sighting.getSightingId()));
            return sighting;

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<Sighting> getAllSightings() {
        final String GET_ALL_SIGHTINGS = "SELECT * FROM Sighting";
        List<Sighting> sightings = jdbc.query(GET_ALL_SIGHTINGS, new SightingMapper());

        for (Sighting sighting : sightings) {
            sighting.setHero(getHeroForSighting(sighting.getSightingId()));
            sighting.setLocation(getLocationForSighting(sighting.getSightingId()));
        }
        return sightings;
    }

    @Override
    @Transactional
    public Sighting addSighting(Sighting sighting) {
        final String INSERT_SIGHTING = "INSERT INTO Sighting (sightingId, locationId, heroId) " + "VALUES(?,?,?)";
        jdbc.update(INSERT_SIGHTING,
                sighting.getDate(),
                sighting.getHero(),
                sighting.getLocation());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        sighting.setSightingId(newId);

        return sighting;
    }

    @Override
    public void updateSighting(Sighting sighting) {
        final String UPDATE_SIGHTING = "UPDATE sighting SET heroId = ?, "
                + "locationId = ? WHERE sightingId = ?";
        jdbc.update(UPDATE_SIGHTING,
                sighting.getHero().getHeroId(),
                sighting.getLocation().getLocationId(),
                sighting.getSightingId());
    }

    @Override
    public void deleteSightingById(int id) {

        final String DELETE_SIGHTING = "DELETE FROM Sighting WHERE sightingId = ?";
        jdbc.update(DELETE_SIGHTING, id);
    }

    @Override
    public List<Sighting> getSightingsOfHero(Hero hero) {
        final String GET_SIGHTING_BY_HEROES = "SELECT * FROM Sighting s" + " WHERE s.heroId = ?";
        List<Sighting> sightings = jdbc.query(GET_SIGHTING_BY_HEROES, new SightingMapper(), hero.getHeroId());
        for (Sighting sighting : sightings) {
            sighting.setHero(getHeroForSighting(sighting.getSightingId()));
            sighting.setLocation(getLocationForSighting(sighting.getSightingId()));
        }
        return sightings;
    }

    @Override
    public List<Sighting> getSightingsAtLocation(Location location) {
        final String GET_SIGHTINGS_BY_Location
                = "SELECT * FROM Sighting s"
                + " WHERE s.Location_idLocation = ?";
        List<Sighting> sightings = jdbc.query(GET_SIGHTINGS_BY_Location,
                new SightingMapper(), location.getLocationId());
        for (Sighting sighting : sightings) {
            sighting.setHero(getHeroForSighting(sighting.getSightingId()));
            sighting.setLocation(getLocationForSighting(sighting.getSightingId()));
        }

        return sightings;
    }

    @Override
    public List<Sighting> getSightingsFromDate(LocalDate date) {
        final String GET_SIGHTINGS_BY_DATE = "SELECT * FROM Sightings s" + " WHERE s.date = ?";
        List<Sighting> sightings = jdbc.query(GET_SIGHTINGS_BY_DATE,
                new SightingMapper(), date);

        for (Sighting sighting : sightings) {
            sighting.setHero(getHeroForSighting(sighting.getSightingId()));
            sighting.setLocation(getLocationForSighting(sighting.getSightingId()));
        }
        return sightings;
    }

    //Helper methods
    private Hero getHeroForSighting(int id) {
        final String GET_HEROS_FOR_SIGHTING = "SELECT h.*" + " FROM hero h JOIN Sighting s ON s.heroId WHERE s.sightingId = ?";
        Hero hero = jdbc.queryForObject(GET_HEROS_FOR_SIGHTING, new HeroMapper(), id);
        return hero;
    }

    private Location getLocationForSighting(int id) {
        final String GET_LOCATION_FOR_SIGHTING = "SELECT l.*" + " FROM location l JOIN Sighting s ON s.locationId WHERE s.sightingId = ?";
        Location thisLocation = jdbc.queryForObject(GET_LOCATION_FOR_SIGHTING, new LocationDaoDB.LocationMapper(), id);
        return thisLocation;
        //Mapper

    }

    public static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting sighting = new Sighting();
            rs.getInt("sightingId");
            sighting.setDate(rs.getDate("date").toLocalDate());

            Hero hero = new Hero();
            hero.setHeroId(rs.getInt("heroId"));

            sighting.setHero(hero);

            Location location = new Location();
            location.setLocationId(rs.getInt("locationId"));

            return sighting;
        }

    }
}
