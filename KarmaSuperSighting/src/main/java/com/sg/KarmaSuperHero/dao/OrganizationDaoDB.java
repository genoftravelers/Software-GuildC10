/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.dao;

import com.sg.KarmaSuperHero.dao.HeroDaoDB.HeroMapper;
import com.sg.KarmaSuperHero.dao.LocationDaoDB.LocationMapper;
import com.sg.KarmaSuperHero.dao.SuperpowerDaoDB.SuperpowerMapper;
import com.sg.KarmaSuperHero.dto.Hero;
import com.sg.KarmaSuperHero.dto.Location;
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
public class OrganizationDaoDB implements OrganizationDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Organization getOrganizationById(int id) {

        try {
            final String GET_ORGANIZATION_BY_ID = "SELECT * FROM Organization WHERE organizationId = ? ";
            Organization organization = jdbc.queryForObject(GET_ORGANIZATION_BY_ID, new OrganizationMapper(), id);

            //check helper method
            organization.setLocation(getLocationForOrganization(organization.getOrganizationId()));

            organization.setHeroes(getHerosForOrganization(organization.getOrganizationId()));

            return organization;

        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Organization> getAllOrganizations() {
        final String GET_ALL_ORGANIZATIONS = "SELECT * FROM organization";
        List<Organization> organizations = jdbc.query(GET_ALL_ORGANIZATIONS, new OrganizationMapper());
        for (Organization organization : organizations) {
            organization.setHeroes(getHerosForOrganization(organization.getOrganizationId()));
            organization.setLocation(getLocationForOrganization(organization.getOrganizationId()));
        }

        return organizations;
    }

    @Override
    public Organization addOrganization(Organization organization) {
        final String INSERT_ORGANIZATION = "INSERT INTO organization (name, description, phoneNum, locationId) " + "VALUES(?,?,?,?)";
        jdbc.update(INSERT_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationPhoneNum(),
                organization.getLocation().getLocationId());

        int newId = jdbc.queryForObject("select LAST_INSERT_ID();", Integer.class);
        organization.setOrganizationId(newId);

        insertOrganizationHero(organization);

        return organization;
    }

    @Override
    public void updateOrganization(Organization organization) {
        final String UPDATE_ORGANIZATION = "UPDATE organization SET name = ?, description=?, phoneNum=?, locationId=? WHERE organizationId=? ";
        jdbc.update(UPDATE_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationPhoneNum(),
                organization.getLocation().getLocationId(),
                organization.getOrganizationId());

        final String DELETE_HERO_ORGANIZATION = "DELETE FROM HeroOrganization WHERE organizationId = ?";
        jdbc.update(DELETE_HERO_ORGANIZATION, organization.getOrganizationId());
        insertOrganizationHero(organization);
    }

    @Override
    public void deleteOrganizationById(int id) {
        final String DELETE_ORGANIZATION_FROM_HERO = "DELETE FROM HeroOrganization WHERE organizationId = ?";
        jdbc.update(DELETE_ORGANIZATION_FROM_HERO, id);

        final String DELETE_ORGANIZATION = "DELETE FROM Organization WHERE organizationId = ?";
        jdbc.update(DELETE_ORGANIZATION, id);
    }

    //Helper Methods 
    private Location getLocationForOrganization(int id) {
        final String GET_LOCATION_FOR_ORGANIZATION = "SELECT l.*" + " FROM location l JOIN Organization o ON o.locationId = l.locationId WHERE o.organizationId = ?";
        Location thisLocation = jdbc.queryForObject(GET_LOCATION_FOR_ORGANIZATION, new LocationMapper(), id);
        return thisLocation;
    }

    private List<Hero> getHerosForOrganization(int id) {
        final String GET_HEROS_FOR_ORGANIZATION = "SELECT h.*" + " FROM hero h JOIN HeroOrganization o ON o.heroId = h.heroId WHERE o.organizationId = ?";
        List<Hero> heros = jdbc.query(GET_HEROS_FOR_ORGANIZATION, new HeroMapper(), id);

        for (Hero hero : heros) {
            final String SELECT_SUPERPOWER_FOR_HERO = "SELECT s.superpowerId, s.name FROM Superpower s "
                    + "JOIN Hero h ON h.superpowerId = s.superpowerId WHERE h.heroId =?";
            Superpower thisPower = jdbc.queryForObject(SELECT_SUPERPOWER_FOR_HERO, new SuperpowerMapper(), hero.getHeroId());
            hero.setSuperPower(thisPower);

        }

        if (heros.isEmpty()) {
            heros = null;
        }

        return heros;
    }

    private void insertOrganizationHero(Organization organization) {
        final String INSERT_HERO_ORGANIZATION = "INSERT INTO "
                + "HeroOrganization(heroId, organizationId) VALUES(?,?)";
        try {
            for (Hero hero : organization.getHeroes()) {
                jdbc.update(INSERT_HERO_ORGANIZATION,
                        hero.getHeroId(),
                        organization.getOrganizationId());
            }
        } catch (NullPointerException ex) {

        }
    }

    //Mapper
    public static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int index) throws SQLException {
            Organization organization = new Organization();
            organization.setOrganizationId(rs.getInt("organizationId"));
            organization.setOrganizationName(rs.getString("name"));
            organization.setOrganizationDescription(rs.getString("description"));
            organization.setOrganizationPhoneNum(rs.getString("phoneNum"));

            return organization;
        }

    }
}
