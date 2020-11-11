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
import org.junit.AfterClass;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
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
public class SightingDaoDBTest {

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

    public SightingDaoDBTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {

        List<Sighting> sightings = sightingDao.getAllSightings();

        for (Sighting sighting : sightings) {
            sightingDao.deleteSightingById(sighting.getSightingId());
        }

        List<Organization> organizations = organizationDao.getAllOrganizations();

        for (Organization organization : organizations) {
            organizationDao.deleteOrganizationById(organization.getOrganizationId());
        }
        List<Location> locations = locationDao.getAllLocations();
        for (Location location : locations) {
            locationDao.deleteLocationById(location.getLocationId());

        }

        List<Hero> heroes = heroDao.getAllHeroes();

        for (Hero hero : heroes) {
            heroDao.deleteHeroById(hero.getHeroId());
        }

    }

    /**
     * Test of getSightingById method, of class SightingDaoDB.
     */
    @Test
    public void testAddGetSightingById() {

        Superpower mindReading = new Superpower();
        mindReading.setSuperpowerName("MindReading");
        mindReading = superpowerDao.addSuperpower(mindReading);

        Hero Spiderman = new Hero();
        Spiderman.setHeroName("Spiderman");
        Spiderman.setHeroDescription("can read mind");
        Spiderman.setSuperPower(mindReading);

        Spiderman = heroDao.addHero(Spiderman);

        BigDecimal latitude = new BigDecimal("37.455000");
        BigDecimal longitude = new BigDecimal("55.155000");

        Location thePost = new Location();
        thePost.setLocationDescription("calm the mind");
        thePost.setLocationAddress("454 The way");
        thePost.setLocationCity("Queens");
        thePost.setLocationState("NY");
        thePost.setZipCode("11372");
        thePost.setLocationName("The post");
        thePost.setLatitude(latitude);
        thePost.setLongitude(longitude);

        thePost = locationDao.addLocation(thePost);

        Sighting currentSighting = new Sighting();

        LocalDate date = LocalDate.parse("2017-02-05");

        currentSighting.setDate(date);
        currentSighting.setHero(Spiderman);
        currentSighting.setLocation(thePost);

        currentSighting = sightingDao.addSighting(currentSighting);

        Sighting result = sightingDao.getSightingById(currentSighting.getSightingId());

        assertEquals(currentSighting, result);
    }

    /**
     * Test of getAllSightings method, of class SightingDaoDB.
     */
    @Test
    public void testGetAllSightings() {

        Superpower mindReading = new Superpower();
        mindReading.setSuperpowerName("Flight");
        mindReading = superpowerDao.addSuperpower(mindReading);
        Hero Spiderman = new Hero();
        Spiderman.setHeroName("Spiderman");
        Spiderman.setHeroDescription("flies");
        Spiderman.setSuperPower(mindReading);

        Spiderman = heroDao.addHero(Spiderman);

        BigDecimal latitude = new BigDecimal("32.515000");
        BigDecimal longitude = new BigDecimal("75.255000");

        Location thePost = new Location();
        thePost.setLocationDescription("calm the mind");
        thePost.setLocationAddress("454 The way");
        thePost.setLocationCity("Queens");
        thePost.setLocationState("NY");
        thePost.setZipCode("11372");
        thePost.setLocationName("The post");
        thePost.setLatitude(latitude);
        thePost.setLongitude(longitude);

        thePost = locationDao.addLocation(thePost);

        Sighting sightingOne = new Sighting();

        LocalDate date = LocalDate.parse("2015-06-17");

        sightingOne.setDate(date);
        sightingOne.setHero(Spiderman);
        sightingOne.setLocation(thePost);

        sightingOne = sightingDao.addSighting(sightingOne);

        Sighting sightingTwo = new Sighting();

        LocalDate dateTwo = LocalDate.parse("2016-09-05");

        sightingTwo.setDate(dateTwo);
        sightingTwo.setHero(Spiderman);
        sightingTwo.setLocation(thePost);

        sightingTwo = sightingDao.addSighting(sightingTwo);

        List<Sighting> sightings = new ArrayList<>();

        sightings.add(sightingOne);
        sightings.add(sightingTwo);

        List<Sighting> result = sightingDao.getAllSightings();

        assertEquals(sightings, result);
    }

    /**
     * Test of updateSighting method, of class SightingDaoDB.
     */
    @Test
    public void testUpdateSighting() {
        Superpower mindReading = new Superpower();
        mindReading.setSuperpowerName("Flight");
        mindReading = superpowerDao.addSuperpower(mindReading);
        Hero Spiderman = new Hero();
        Spiderman.setHeroName("Spiderman");
        Spiderman.setHeroDescription("flies");
        Spiderman.setSuperPower(mindReading);

        Spiderman = heroDao.addHero(Spiderman);

        BigDecimal latitude = new BigDecimal("32.515000");
        BigDecimal longitude = new BigDecimal("75.255000");

        Location thePost = new Location();
        thePost.setLocationDescription("calm the mind");
        thePost.setLocationAddress("454 The way");
        thePost.setLocationCity("Queens");
        thePost.setLocationState("NY");
        thePost.setZipCode("11372");
        thePost.setLocationName("The post");
        thePost.setLatitude(latitude);
        thePost.setLongitude(longitude);

        thePost = locationDao.addLocation(thePost);

        Sighting currentSighting = new Sighting();

        LocalDate date = LocalDate.parse("2015-06-17");

        currentSighting.setDate(date);
        currentSighting.setHero(Spiderman);
        currentSighting.setLocation(thePost);

        currentSighting = sightingDao.addSighting(currentSighting);

        LocalDate newDate = LocalDate.parse("2016-09-05");

        currentSighting.setDate(newDate);

        sightingDao.updateSighting(currentSighting);

        Sighting sighting = sightingDao.getSightingById(currentSighting.getSightingId());

        LocalDate result = sighting.getDate();

        assertEquals(newDate, result);
    }

    /**
     * Test of deleteSightingById method, of class SightingDaoDB.
     */
    @Test
    public void testDeleteSightingById() {

        Superpower mindReading = new Superpower();
        mindReading.setSuperpowerName("Flight");
        mindReading = superpowerDao.addSuperpower(mindReading);
        Hero Spiderman = new Hero();
        Spiderman.setHeroName("Spiderman");
        Spiderman.setHeroDescription("flies");
        Spiderman.setSuperPower(mindReading);

        Spiderman = heroDao.addHero(Spiderman);

        BigDecimal latitude = new BigDecimal("32.515000");
        BigDecimal longitude = new BigDecimal("75.255000");

        Location thePost = new Location();
        thePost.setLocationDescription("calm the mind");
        thePost.setLocationAddress("454 The way");
        thePost.setLocationCity("Queens");
        thePost.setLocationState("NY");
        thePost.setZipCode("11372");
        thePost.setLocationName("The post");
        thePost.setLatitude(latitude);
        thePost.setLongitude(longitude);

        thePost = locationDao.addLocation(thePost);

        Sighting currentSighting = new Sighting();

        LocalDate date = LocalDate.parse("2015-06-17");

        currentSighting.setDate(date);
        currentSighting.setHero(Spiderman);
        currentSighting.setLocation(thePost);

        currentSighting = sightingDao.addSighting(currentSighting);

        LocalDate newDate = LocalDate.parse("2016-09-05");
        currentSighting.setDate(date);
        currentSighting.setHero(Spiderman);
        currentSighting.setLocation(thePost);

        currentSighting = sightingDao.addSighting(currentSighting);

        sightingDao.deleteSightingById(currentSighting.getSightingId());

        Sighting result = sightingDao.getSightingById(currentSighting.getSightingId());

        assertNull(result);
    }

    /**
     * Test of getSightingsOfHero method, of class SightingDaoDB.
     */
    @Test
    public void testGetSightingsOfHero() {

        Superpower mindReading = new Superpower();
        mindReading.setSuperpowerName("Flight");
        mindReading = superpowerDao.addSuperpower(mindReading);
        Hero Spiderman = new Hero();
        Spiderman.setHeroName("Spiderman");
        Spiderman.setHeroDescription("flies");
        Spiderman.setSuperPower(mindReading);

        Spiderman = heroDao.addHero(Spiderman);

        BigDecimal latitude = new BigDecimal("32.515000");
        BigDecimal longitude = new BigDecimal("75.255000");

        Location thePost = new Location();
        thePost.setLocationDescription("calm the mind");
        thePost.setLocationAddress("454 The way");
        thePost.setLocationCity("Queens");
        thePost.setLocationState("NY");
        thePost.setZipCode("11372");
        thePost.setLocationName("The post");
        thePost.setLatitude(latitude);
        thePost.setLongitude(longitude);

        thePost = locationDao.addLocation(thePost);

        Superpower flight = new Superpower();
        flight.setSuperpowerName("Flight");
        flight = superpowerDao.addSuperpower(flight);

        Hero Kingkong = new Hero();
        Kingkong.setHeroName("KingKong");
        Kingkong.setHeroDescription("He ruins Christmas");
        Kingkong.setSuperPower(mindReading);

        Kingkong = heroDao.addHero(Kingkong);

        Sighting sightingOne = new Sighting();

        LocalDate date = LocalDate.parse("2017-02-05");

        sightingOne.setDate(date);
        sightingOne.setHero(Spiderman);
        sightingOne.setLocation(thePost);

        sightingOne = sightingDao.addSighting(sightingOne);

        Sighting sightingTwo = new Sighting();

        LocalDate date2 = LocalDate.parse("2017-03-10");

        sightingTwo.setDate(date2);
        sightingTwo.setHero(Spiderman);
        sightingTwo.setLocation(thePost);

        sightingTwo = sightingDao.addSighting(sightingTwo);

        Sighting sightingThree = new Sighting();

        sightingThree.setDate(date);
        sightingThree.setHero(Kingkong);
        sightingThree.setLocation(thePost);

        sightingThree = sightingDao.addSighting(sightingThree);

        List<Sighting> spidermanSightings = new ArrayList<>();
        spidermanSightings.add(sightingOne);
        spidermanSightings.add(sightingTwo);

        List<Sighting> result = sightingDao.getSightingsOfHero(Spiderman);

        assertEquals(spidermanSightings, result);
    }

    /**
     * Test of getSightingsAtLocation method, of class SightingDaoDB.
     */
    @Test
    public void testGetSightingsAtLocation() {
        Superpower mindReading = new Superpower();
        mindReading.setSuperpowerName("Flight");
        mindReading = superpowerDao.addSuperpower(mindReading);
        Hero Spiderman = new Hero();
        Spiderman.setHeroName("Spiderman");
        Spiderman.setHeroDescription("flies");
        Spiderman.setSuperPower(mindReading);

        Spiderman = heroDao.addHero(Spiderman);

        BigDecimal latitude = new BigDecimal("32.515000");
        BigDecimal longitude = new BigDecimal("75.255000");

        Location thePost = new Location();
        thePost.setLocationDescription("calm the mind");
        thePost.setLocationAddress("454 The way");
        thePost.setLocationCity("Queens");
        thePost.setLocationState("NY");
        thePost.setZipCode("11372");
        thePost.setLocationName("The post");
        thePost.setLatitude(latitude);
        thePost.setLongitude(longitude);

        thePost = locationDao.addLocation(thePost);

        Sighting sightingOne = new Sighting();

        LocalDate date = LocalDate.parse("2017-02-05");

        sightingOne.setDate(date);
        sightingOne.setHero(Spiderman);
        sightingOne.setLocation(thePost);

        sightingOne = sightingDao.addSighting(sightingOne);

        Sighting sightingTwo = new Sighting();

        LocalDate date2 = LocalDate.parse("2017-03-10");

        sightingTwo.setDate(date2);
        sightingTwo.setHero(Spiderman);
        sightingTwo.setLocation(thePost);

        sightingTwo = sightingDao.addSighting(sightingTwo);

        BigDecimal latitude2 = new BigDecimal("17.555000");
        BigDecimal longitude2 = new BigDecimal("96.555000");

        Location GrandCentral = new Location();
        GrandCentral.setLocationDescription("Not just for tacos");
        GrandCentral.setLocationAddress("1234 taco way");
        GrandCentral.setLocationCity("Manhattan");
        GrandCentral.setLocationState("NY");
        GrandCentral.setZipCode("11111");
        GrandCentral.setLocationName("Taco Bell");
        GrandCentral.setLatitude(latitude2);
        GrandCentral.setLongitude(longitude2);

        GrandCentral = locationDao.addLocation(GrandCentral);

        Sighting sightingThree = new Sighting();

        sightingThree.setDate(date2);
        sightingThree.setHero(Spiderman);
        sightingThree.setLocation(GrandCentral);

        sightingThree = sightingDao.addSighting(sightingThree);

        List<Sighting> sightingsAtThePost = new ArrayList<>();

        sightingsAtThePost.add(sightingOne);
        sightingsAtThePost.add(sightingTwo);

        List<Sighting> result = sightingDao.getSightingsAtLocation(thePost);

        assertEquals(sightingsAtThePost, result);
    }

    /**
     * Test of getSightingsFromDate method, of class SightingDaoDB.
     */
    @Test
    public void testGetSightingsFromDate() {
        
        Superpower mindReading = new Superpower();
        mindReading.setSuperpowerName("Flight");
        mindReading = superpowerDao.addSuperpower(mindReading);
        Hero Spiderman = new Hero();
        Spiderman.setHeroName("Spiderman");
        Spiderman.setHeroDescription("flies");
        Spiderman.setSuperPower(mindReading);

        Spiderman = heroDao.addHero(Spiderman);

        BigDecimal latitude = new BigDecimal("32.515000");
        BigDecimal longitude = new BigDecimal("75.255000");

        Location thePost = new Location();
        thePost.setLocationDescription("calm the mind");
        thePost.setLocationAddress("454 The way");
        thePost.setLocationCity("Queens");
        thePost.setLocationState("NY");
        thePost.setZipCode("11372");
        thePost.setLocationName("The post");
        thePost.setLatitude(latitude);
        thePost.setLongitude(longitude);

        thePost = locationDao.addLocation(thePost);

        Sighting sightingOne = new Sighting();

        LocalDate date = LocalDate.parse("2017-02-05");

        sightingOne.setDate(date);
        sightingOne.setHero(Spiderman);
        sightingOne.setLocation(thePost);

        sightingOne = sightingDao.addSighting(sightingOne);

        Sighting sightingTwo = new Sighting();

        LocalDate date2 = LocalDate.parse("2017-03-10");

        sightingTwo.setDate(date2);
        sightingTwo.setHero(Spiderman);
        sightingTwo.setLocation(thePost);

        sightingTwo = sightingDao.addSighting(sightingTwo);
        
        

        List<Sighting> sightings = new ArrayList<>();
        sightings.add(sightingOne);
        sightings.add(sightingTwo);

       List <Sighting> result = sightingDao.getAllSightings();
       
        assertEquals(sightings, result);
       
    }

}
