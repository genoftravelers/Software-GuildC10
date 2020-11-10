/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.dao;

import com.sg.KarmaSuperHero.dto.Hero;
import com.sg.KarmaSuperHero.dto.Location;
import com.sg.KarmaSuperHero.dto.Organization;
import com.sg.KarmaSuperHero.dto.Sighting;
import com.sg.KarmaSuperHero.dto.Superpower;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
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
@SpringBootTest
public class HeroDaoDBTest {

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

    public HeroDaoDBTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        List<Hero> heroes = heroDao.getAllHeroes();

        for (Hero hero : heroes) {
            heroDao.deleteHeroById(hero.getHeroId());
        }
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        for (Superpower superpower : superpowers) {
            superpowerDao.deleteSuperpowerById(superpower.getSuperpowerId());
        }
        List<Organization> organizations = organizationDao.getAllOrganizations();

        for (Organization organization : organizations) {
            organizationDao.deleteOrganizationById(organization.getOrganizationId());
        }
        List<Sighting> sightings = sightingDao.getAllSightings();

        for (Sighting sighting : sightings) {
            sightingDao.deleteSightingById(sighting.getSightingId());
        }
        List<Location> locations = locationDao.getAllLocations();
        for (Location location : locations) {
            locationDao.deleteLocationById(location.getLocationId());

        }
    }

    /**
     * Test of getHeroById method, of class HeroDaoDB.
     */
    @Test
    public void testAddGetHeroById() {

        Superpower shapeShifting = new Superpower();
        shapeShifting.setSuperpowerName("Shape Shifting");

        shapeShifting = superpowerDao.addSuperpower(shapeShifting);

        Hero kingkong = new Hero();
        kingkong.setHeroName("KingKong");
        kingkong.setHeroDescription("break and remake");
        kingkong.setSuperPower(shapeShifting);

        kingkong = heroDao.addHero(kingkong);

        Hero result = heroDao.getHeroById(kingkong.getHeroId());

        assertEquals(kingkong, result);
    }

    /**
     * Test of getAllHeroes method, of class HeroDaoDB.
     */
    @Test
    public void testGetAllHeroes() {
        Superpower shapeShifting = new Superpower();
        shapeShifting.setSuperpowerName("Shape Shifting");

        shapeShifting = superpowerDao.addSuperpower(shapeShifting);

        Hero kingkong = new Hero();
        kingkong.setHeroName("KingKong");
        kingkong.setHeroDescription("break and remake");
        kingkong.setSuperPower(shapeShifting);

        kingkong = heroDao.addHero(kingkong);

        Superpower flight = new Superpower();
        flight.setSuperpowerName("Shape Shifting");

        shapeShifting = superpowerDao.addSuperpower(shapeShifting);

        Hero theGrinch = new Hero();
        theGrinch.setHeroName("KingKong");
        theGrinch.setHeroDescription("break and remake");
        theGrinch.setSuperPower(shapeShifting);

        theGrinch = heroDao.addHero(kingkong);

        List<Hero> result = heroDao.getAllHeroes();

        assertNotNull(result);
        assertTrue(result.size() == 2);

    }

    /**
     * Test of updateHero method, of class HeroDaoDB.
     */
    @Test
    public void testUpdateHero() {
        Superpower shapeShifting = new Superpower();
        shapeShifting.setSuperpowerName("Shape Shifting");

        shapeShifting = superpowerDao.addSuperpower(shapeShifting);

        Hero kingkong = new Hero();
        kingkong.setHeroName("KingKong");
        kingkong.setHeroDescription("break and remake");
        kingkong.setSuperPower(shapeShifting);

        kingkong = heroDao.addHero(kingkong);

        Hero oldInfo = heroDao.getHeroById(kingkong.getHeroId());

        kingkong.setHeroDescription("Super strong");

        heroDao.updateHero(kingkong);

        Hero updatedResult = heroDao.getHeroById(kingkong.getHeroId());

        assertNotEquals(oldInfo, updatedResult);
    }

    /**
     * Test of deleteHeroById method, of class HeroDaoDB.
     */
    @Test
    public void testDeleteHeroById() {
        Superpower shapeShifting = new Superpower();
        shapeShifting.setSuperpowerName("Shape Shifting");

        shapeShifting = superpowerDao.addSuperpower(shapeShifting);

        Hero kingkong = new Hero();
        kingkong.setHeroName("KingKong");
        kingkong.setHeroDescription("break and remake");
        kingkong.setSuperPower(shapeShifting);

        kingkong = heroDao.addHero(kingkong);

        heroDao.deleteHeroById(kingkong.getHeroId());

        assertNull(heroDao.getHeroById(kingkong.getHeroId()));
    }

    /**
     * Test of getHeroesBySuperpower method, of class HeroDaoDB.
     */
    @Test
    public void testGetHeroesBySuperpower() {
        Superpower flight = new Superpower();
        flight.setSuperpowerName("Flight");
        flight = superpowerDao.addSuperpower(flight);

        Hero Spiderman = new Hero();
        Spiderman.setHeroName("Spiderman");
        Spiderman.setHeroDescription("faster than a speeding bullet");
        Spiderman.setSuperPower(flight);

        Spiderman = heroDao.addHero(Spiderman);

        Superpower mindReading = new Superpower();
        mindReading.setSuperpowerName("Strength");
        mindReading = superpowerDao.addSuperpower(mindReading);

        Hero theGrinch = new Hero();
        theGrinch.setHeroName("Mr. Grinch");
        theGrinch.setHeroDescription("He can ruin your christmas");
        theGrinch.setSuperPower(mindReading);

        theGrinch = heroDao.addHero(theGrinch);

        Hero Batman = new Hero();
        Batman.setHeroName("Batman");
        Batman.setHeroDescription("Super strong");
        Batman.setSuperPower(mindReading);

        Batman = heroDao.addHero(Batman);

        List<Hero> allHeroes = heroDao.getAllHeroes();

        List<Hero> heroesWhoMindRead = heroDao.getHeroesBySuperpower(mindReading);

        assertNotEquals(allHeroes, heroesWhoMindRead);

        assertTrue(heroesWhoMindRead.size() == 2);

    }

}
