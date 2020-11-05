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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
    
    @Before
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
     * Test of getHeroById method, of class HeroDaoDB.
     */
    @Test
    public void testAddGetHeroById() {
        
        Superpower shapeShifting = new Superpower();
        shapeShifting.setSuperpowerName("Shape Shifting");
        
        shapeShifting=superpowerDao.addSuperpower(shapeShifting);
        
        Hero kingkong = new Hero();
        kingkong.setHeroName("KingKong");
        kingkong.setHeroDescription("break and remake");
        kingkong.setSuperPower(shapeShifting);

        kingkong=heroDao.addHero(kingkong);

        Hero result = heroDao.getHeroById(kingkong.getHeroId());

        assertEquals(kingkong, result);
    }

    /**
     * Test of getAllHeroes method, of class HeroDaoDB.
     */
    @Test
    public void testGetAllHeroes() {
        
    }

    /**
     * Test of addHero method, of class HeroDaoDB.
     */
    @Test
    public void testAddHero() {
    }

    /**
     * Test of updateHero method, of class HeroDaoDB.
     */
    @Test
    public void testUpdateHero() {
    }

    /**
     * Test of deleteHeroById method, of class HeroDaoDB.
     */
    @Test
    public void testDeleteHeroById() {
    }

    /**
     * Test of getHeroesBySuperpower method, of class HeroDaoDB.
     */
    @Test
    public void testGetHeroesBySuperpower() {
    }

    /**
     * Test of insertHeroOrganization method, of class HeroDaoDB.
     */
    @Test
    public void testInsertHeroOrganization() {
    }

    /**
     * Test of getHeroesByOrganization method, of class HeroDaoDB.
     */
    @Test
    public void testGetHeroesByOrganization() {
    }
    
}
