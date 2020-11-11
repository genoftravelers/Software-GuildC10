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
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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
public class OrganizationDaoDBTest {

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

    public OrganizationDaoDBTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {

        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        for (Superpower superpower : superpowers) {
            superpowerDao.deleteSuperpowerById(superpower.getSuperpowerId());
        }

        List<Location> locations = locationDao.getAllLocations();
        for (Location location : locations) {
            locationDao.deleteLocationById(location.getLocationId());
        }

        List<Hero> heroes = heroDao.getAllHeroes();

        for (Hero hero : heroes) {
            heroDao.deleteHeroById(hero.getHeroId());
        }

        List<Organization> organizations = organizationDao.getAllOrganizations();

        for (Organization organization : organizations) {
            organizationDao.deleteOrganizationById(organization.getOrganizationId());
        }

        List<Sighting> sightings = sightingDao.getAllSightings();

        for (Sighting sighting : sightings) {
            sightingDao.deleteSightingById(sighting.getSightingId());
        }

    }

    /**
     * Test of getOrganizationById method, of class OrganizationDaoDB.
     */
    @Test
    public void testAddGetOrganizationById() {

        BigDecimal latitude = new BigDecimal("25.455000");
        BigDecimal longitude = new BigDecimal("72.455000");

        Location FlatIron = new Location();
        FlatIron.setLocationDescription("A lotus looking building that is made of steel. Finger prints needed to enter.");
        FlatIron.setLocationAddress("89 E 42nd St");
        FlatIron.setLocationCity("New York City");
        FlatIron.setLocationState("NY");
        FlatIron.setZipCode("1OO17");
        FlatIron.setLocationName("The Way");
        FlatIron.setLatitude(latitude);
        FlatIron.setLongitude(longitude);

        FlatIron = locationDao.addLocation(FlatIron);

        Organization zenPower = new Organization();

        zenPower.setOrganizationName("Zen");
        zenPower.setOrganizationDescription("Hidden under the Dessert");
        zenPower.setOrganizationPhoneNum("9292459121");
        zenPower.setLocation(FlatIron);

        zenPower = organizationDao.addOrganization(zenPower);

        Organization result = organizationDao.getOrganizationById(zenPower.getOrganizationId());

        assertEquals(zenPower, result);
    }

    /**
     * Test of getAllOrganizations method, of class OrganizationDaoDB.
     */
    @Test
    public void testGetAllOrganizations() {
        //First
        BigDecimal latitude = new BigDecimal("34.355000");
        BigDecimal longitude = new BigDecimal("57.545000");

        Location GrandCentralTerminal = new Location();
        GrandCentralTerminal.setLocationDescription("All calm");
        GrandCentralTerminal.setLocationAddress("1234 This way");
        GrandCentralTerminal.setLocationCity("D.C");
        GrandCentralTerminal.setLocationState("NY");
        GrandCentralTerminal.setZipCode("11377");
        GrandCentralTerminal.setLocationName("Manhattan");
        GrandCentralTerminal.setLatitude(latitude);
        GrandCentralTerminal.setLongitude(longitude);

        GrandCentralTerminal = locationDao.addLocation(GrandCentralTerminal);

        Organization TheUnion = new Organization();

        TheUnion.setOrganizationName("Name Organization");
        TheUnion.setOrganizationDescription("Hidden under the  dessert");
        TheUnion.setOrganizationPhoneNum("9292459121");
        TheUnion.setLocation(GrandCentralTerminal);

        TheUnion = organizationDao.addOrganization(TheUnion);

        //Second
        BigDecimal latitude2 = new BigDecimal("27.555000");
        BigDecimal longitude2 = new BigDecimal("76.555000");

        Location mcDonalds = new Location();
        mcDonalds.setLocationDescription("All in union");
        mcDonalds.setLocationAddress("123 Union way");
        mcDonalds.setLocationCity("Manhattan");
        mcDonalds.setLocationState("NY");
        mcDonalds.setZipCode("10001");
        mcDonalds.setLocationName("Manhattan");
        mcDonalds.setLatitude(latitude2);
        mcDonalds.setLongitude(longitude2);

        mcDonalds = locationDao.addLocation(mcDonalds);

        Organization TheUnion2 = new Organization();

        TheUnion2.setOrganizationName("The gang");
        TheUnion2.setOrganizationDescription("Looks like a good gang");
        TheUnion2.setOrganizationPhoneNum("9292459121");
        TheUnion2.setLocation(mcDonalds);

        TheUnion2 = organizationDao.addOrganization(TheUnion2);

        List<Organization> result = organizationDao.getAllOrganizations();

        assertNotNull(result);
        assertTrue(result.size() == 2);

    }

    /**
     * Test of updateOrganization method, of class OrganizationDaoDB.
     */
    @Test
    public void testUpdateOrganization() {

        BigDecimal latitude = new BigDecimal("34.355000");
        BigDecimal longitude = new BigDecimal("57.545000");

        Location GrandCentralTerminal = new Location();
        GrandCentralTerminal.setLocationDescription("All calm");
        GrandCentralTerminal.setLocationAddress("1234 This way");
        GrandCentralTerminal.setLocationCity("D.C");
        GrandCentralTerminal.setLocationState("NY");
        GrandCentralTerminal.setZipCode("11377");
        GrandCentralTerminal.setLocationName("Manhattan");
        GrandCentralTerminal.setLatitude(latitude);
        GrandCentralTerminal.setLongitude(longitude);

        GrandCentralTerminal = locationDao.addLocation(GrandCentralTerminal);

        Organization theUnion = new Organization();

        theUnion.setOrganizationName("Name Organization");
        theUnion.setOrganizationDescription("Hidden under the  dessert");
        theUnion.setOrganizationPhoneNum("9292459121");
        theUnion.setLocation(GrandCentralTerminal);

        theUnion = organizationDao.addOrganization(theUnion);

        String oldInfo = theUnion.getOrganizationDescription();
        String newInfo = "new info";

        theUnion.setOrganizationDescription(newInfo);

        organizationDao.updateOrganization(theUnion);

        Organization result = organizationDao.getOrganizationById(theUnion.getOrganizationId());

        assertNotEquals(result.getOrganizationDescription(), oldInfo);
        assertEquals(result.getOrganizationDescription(), newInfo);

    }

    /**
     * Test of deleteOrganizationById method, of class OrganizationDaoDB.
     */
    @Test
    public void testDeleteOrganizationById() {
         BigDecimal latitude = new BigDecimal("34.355000");
        BigDecimal longitude = new BigDecimal("57.545000");

        Location GrandCentralTerminal = new Location();
        GrandCentralTerminal.setLocationDescription("All calm");
        GrandCentralTerminal.setLocationAddress("1234 This way");
        GrandCentralTerminal.setLocationCity("D.C");
        GrandCentralTerminal.setLocationState("NY");
        GrandCentralTerminal.setZipCode("11377");
        GrandCentralTerminal.setLocationName("Manhattan");
        GrandCentralTerminal.setLatitude(latitude);
        GrandCentralTerminal.setLongitude(longitude);

        GrandCentralTerminal = locationDao.addLocation(GrandCentralTerminal);

        Organization theUnion = new Organization();

        theUnion.setOrganizationName("Name Organization");
        theUnion.setOrganizationDescription("Hidden under the  dessert");
        theUnion.setOrganizationPhoneNum("9292459121");
        theUnion.setLocation(GrandCentralTerminal);

        theUnion = organizationDao.addOrganization(theUnion);
        
        organizationDao.deleteOrganizationById(theUnion.getOrganizationId());
        assertNull(organizationDao.getOrganizationById(theUnion.getOrganizationId()));
        
    }

}
