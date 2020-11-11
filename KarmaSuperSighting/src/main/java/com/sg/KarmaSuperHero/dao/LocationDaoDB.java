/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.dao;

import com.sg.KarmaSuperHero.dao.OrganizationDaoDB.OrganizationMapper;
import com.sg.KarmaSuperHero.dto.Location;
import com.sg.KarmaSuperHero.dto.Organization;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class LocationDaoDB implements LocationDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    @Transactional
    public Location addLocation(Location location) {
        final String INSERT_LOCATION = "INSERT INTO Location(name, description, address, city, state, zipcode, latitude, longitude) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        jdbc.update(INSERT_LOCATION,
                location.getLocationName(),
                location.getLocationDescription(),
                location.getLocationAddress(),
                location.getLocationCity(),
                location.getLocationState(),
                location.getZipCode(),
                location.getLatitude(),
                location.getLongitude());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        location.setLocationId(newId);

        return location;
    }

    @Override
    public Location getLocationById(int id) {
        try {
            final String GET_LOCATION_BY_ID = "SELECT * FROM Location WHERE locationId = ?";
            return jdbc.queryForObject(GET_LOCATION_BY_ID, new LocationMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Location> getAllLocations() {

        final String GET_ALL_LOCATIONS = "SELECT * FROM Location";
        return jdbc.query(GET_ALL_LOCATIONS, new LocationMapper());
    }

    @Override
    public void updateLocation(Location location) {
        final String UPDATE_LOCATION = "UPDATE location SET name = ?, description = ?, "
                + "address = ?, city = ?, state = ?, zipcode = ?, latitude = ?,"
                + "longitude = ?  WHERE locationId = ?";
        jdbc.update(UPDATE_LOCATION,
                location.getLocationName(),
                location.getLocationDescription(),
                location.getLocationAddress(),
                location.getLocationCity(),
                location.getLocationState(),
                location.getZipCode(),
                location.getLatitude(),
                location.getLongitude(),
                location.getLocationId());
    }

    @Override
    @Transactional
    public void deleteLocationById(int id) {

        final String GET_ORGANIZATION_BY_LOCATION = "SELECT * FROM Organization WHERE locationId = ?";

        List<Organization> organizationsAtLocation = jdbc.query(GET_ORGANIZATION_BY_LOCATION, new OrganizationMapper(), id);
        
        for (Organization organization : organizationsAtLocation) {
            final String DELETE_HEROORGANIZATION = "DELETE FROM HeroOrganization WHERE organizationId=?";
            jdbc.update(DELETE_HEROORGANIZATION, organization.getOrganizationId());
            
        }

        final String DELETE_ORGANIZATION_BY_LOCATION = "DELETE FROM Organization WHERE locationId = ?";
        jdbc.update(DELETE_ORGANIZATION_BY_LOCATION, id);

        final String DELETE_SIGHTING_BY_LOCATION = "DELETE FROM Sighting WHERE locationId = ?";
        jdbc.update(DELETE_SIGHTING_BY_LOCATION, id);

        final String DELETE_LOCATION = "DELETE FROM Location WHERE locationId = ?";
        jdbc.update(DELETE_LOCATION, id);
    }

    public static final class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int index) throws SQLException {
            Location location = new Location();
            location.setLocationId(rs.getInt("locationId"));
            location.setLocationName(rs.getString("name"));
            location.setLocationDescription(rs.getString("description"));
            location.setLocationAddress(rs.getString("address"));
            location.setLocationCity(rs.getString("city"));
            location.setLocationState(rs.getString("state"));
            location.setZipCode(rs.getString("zipcode"));
            location.setLatitude(rs.getBigDecimal("latitude"));
            location.setLongitude(rs.getBigDecimal("longitude"));

            return location;
        }
    }
}
