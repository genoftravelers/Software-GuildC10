/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.dao;

import com.sg.KarmaSuperHero.TestApplicationConfiguration;
import com.sg.KarmaSuperHero.dto.Hero;
import com.sg.KarmaSuperHero.dto.Location;
import com.sg.KarmaSuperHero.dto.Organization;
import com.sg.KarmaSuperHero.dto.Sighting;
import com.sg.KarmaSuperHero.dto.Superpower;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class LocationDaoDBTest {

    @Autowired
    SuperpowerDao superpowerDao;

    @Autowired
    SightingDao sightingDao;

    @Autowired
    HeroDao heroDao;

    @Autowired
    OrganizationDao organizationDao;
    @Autowired
    LocationDao locationDao;

    public LocationDaoDBTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        List<Location> locations = locationDao.getAllLocations();
        for (Location location : locations) {
            locationDao.deleteLocationById(location.getLocationId());
        }
    }

    /**
     * Test of addLocation method, of class LocationDaoDB.
     */
    @Test
    public void testAddGetLocation() {
        Location location = new Location();
        location.setLocationName("Cool city");
        location.setLocationDescription("Diversed");
        location.setLocationAddress("37-94 Judget steet, Jackson Heights, NY 11372");
        location.setLocationCity("Jackson Heights");
        location.setLocationState("NY");
        location.setZipCode("11372");
        location.setLatitude(new BigDecimal("90.744715"));
        location.setLongitude(new BigDecimal("-83.785605"));

        location = locationDao.addLocation(location);
        Location location1 = locationDao.getLocationById(location.getLocationId());

        assertEquals(location, location1);

    }

    /**
     * Test of getAllLocations method, of class LocationDaoDB.
     */
    @Test
    public void testGetAllLocations() {

        Location location = new Location();
        location.setLocationName("Cool city");
        location.setLocationDescription("Diversed");
        location.setLocationAddress("37-94 Judget steet, Jackson Heights, NY 11372");
        location.setLocationCity("Jackson Heights");
        location.setLocationState("NY");
        location.setZipCode("11372");
        location.setLatitude(new BigDecimal("90.744715"));
        location.setLongitude(new BigDecimal("-83.785605"));

        location = locationDao.addLocation(location);

        Location location1 = new Location();
        location1.setLocationName("Diversed city");
        location1.setLocationDescription("Diversed");
        location1.setLocationAddress("98-34 78th street, Jackson Heights, NY 11372");
        location1.setLocationCity("Jackson Heights");
        location1.setLocationState("NY");
        location1.setZipCode("11372");
        location1.setLatitude(new BigDecimal("90.744715"));
        location1.setLongitude(new BigDecimal("-83.785605"));

        location1 = locationDao.addLocation(location1);

        List<Location> locations = locationDao.getAllLocations();

        assertEquals(2, locations.size());
        assertTrue(locations.contains(location));
        assertTrue(locations.contains(location1));
    }

    /**
     * Test of updateLocation method, of class LocationDaoDB.
     */
    @Test
    public void testUpdateLocation() {
        Location location = new Location();
        location.setLocationName("Cool city");
        location.setLocationDescription("Diversed");
        location.setLocationAddress("37-94 Judget steet, Jackson Heights, NY 11372");
        location.setLocationCity("Jackson Heights");
        location.setLocationState("NY");
        location.setZipCode("11372");
        location.setLatitude(new BigDecimal("90.744715"));
        location.setLongitude(new BigDecimal("-83.785605"));

        location = locationDao.addLocation(location);

        location.setLocationName("New city");
        location.setLocationDescription(" New Diversed");
        location.setLocationAddress("37-94 Judget steet, Jackson Heights, NY 11372");
        location.setLocationCity("Jackson Heights");
        location.setLocationState("NY");
        location.setZipCode("11372");
        location.setLatitude(new BigDecimal("90.744715"));
        location.setLongitude(new BigDecimal("-83.785605"));

        locationDao.updateLocation(location);
        Location fromDao = locationDao.getLocationById(location.getLocationId());
        assertEquals(location, fromDao);

    }

    /**
     * Test of deleteLocationById method, of class LocationDaoDB.
     */
    @Test
    public void testDeleteLocationById() {

        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Shape shifting");
        superpower = superpowerDao.addSuperpower(superpower);

        Hero hero = new Hero();
        hero.setHeroName("Supergirl");
        hero.setHeroDescription("super string");
        hero.setSuperPower(superpower);
        hero = heroDao.addHero(hero);

        Hero fromDao = heroDao.getHeroById(hero.getHeroId());
        assertEquals(hero, fromDao);

        Location location = new Location();
        location.setLocationName("Cool city");
        location.setLocationDescription("Diversed");
        location.setLocationAddress("37-94 Judget steet, Jackson Heights, NY 11372");
        location.setLocationCity("Jackson Heights");
        location.setLocationState("NY");
        location.setZipCode("11372");
        location.setLatitude(new BigDecimal("90.744715"));
        location.setLongitude(new BigDecimal("-83.785605"));

        location = locationDao.addLocation(location);
        

        Location locationFromDao = locationDao.getLocationById(location.getLocationId());
        assertEquals(location, locationFromDao);

        Organization organization = new Organization();

        organization.setOrganizationName("Zen");
        organization.setOrganizationDescription("Hidden under the Dessert");
        organization.setOrganizationPhoneNum("9292459121");
        organization.setLocation(location);

        List<Hero> heroes = new ArrayList<>();
        heroes.add(hero);
        organization.setHeroes(heroes);

        organization = organizationDao.addOrganization(organization);

        Organization orgFromDao = organizationDao.getOrganizationById(organization.getOrganizationId());
        assertEquals(organization, orgFromDao);

        Organization organization2 = new Organization();

        organization2.setOrganizationName("Zen2");
        organization2.setOrganizationDescription("Hidden under the Dessert2");
        organization2.setOrganizationPhoneNum("9292459121");
        organization2.setLocation(location);

        organization2.setHeroes(heroes);
        organization2 = organizationDao.addOrganization(organization2);

        Organization org2FromDao = organizationDao.getOrganizationById(organization2.getOrganizationId());
        assertEquals(organization2, org2FromDao);

        Sighting firstSighting = new Sighting();

        LocalDate date = LocalDate.parse("2017-02-05");

        firstSighting.setDate(date);
        firstSighting.setHero(hero);
        firstSighting.setLocation(location);

        firstSighting = sightingDao.addSighting(firstSighting);

        Sighting sightingFromDao = sightingDao.getSightingById(firstSighting.getSightingId());

        assertEquals(firstSighting, sightingFromDao);

        locationDao.deleteLocationById(location.getLocationId());
        locationFromDao =locationDao.getLocationById(location.getLocationId());
        orgFromDao = organizationDao.getOrganizationById(organization.getOrganizationId());
        sightingFromDao = sightingDao.getSightingById(firstSighting.getSightingId());

        assertNull(locationFromDao);
        //Cheking if organization is deleted
        assertNull(orgFromDao);
        //Check if the sighting is deleted
        assertNull(sightingFromDao);

    }
}
