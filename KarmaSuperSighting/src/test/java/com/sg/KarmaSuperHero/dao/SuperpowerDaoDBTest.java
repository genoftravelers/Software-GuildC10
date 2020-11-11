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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
public class SuperpowerDaoDBTest {

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

    }

    /**
     * Test of getSuperpowerById method, of class SuperpowerDaoDB.
     */
    @Test
    public void testGetSuperpowerById() {

        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Telekinesis");
        superpower = superpowerDao.addSuperpower(superpower);

        Superpower fromDao = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        assertEquals(superpower, fromDao);
    }

    /**
     * Test of getAllSuperpowers method, of class SuperpowerDaoDB.
     */
    @Test
    public void testGetAllSuperpowers() {

        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Telekinesis");
        superpower = superpowerDao.addSuperpower(superpower);

        Superpower superpower1 = new Superpower();
        superpower1.setSuperpowerName("MindReading");
        superpower1 = superpowerDao.addSuperpower(superpower);

        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();

        assertEquals(2, superpowers.size());
        assertTrue(superpowers.contains(superpower));
        assertTrue(superpowers.contains(superpower1));

    }

    /**
     * Test of addSuperpower method, of class SuperpowerDaoDB.
     */
    @Test
    public void testGetAddSuperpower() {
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Flight");
        superpower = superpowerDao.addSuperpower(superpower);

        Superpower fromDao = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        assertEquals(superpower, fromDao);

    }

    /**
     * Test of updateSuperpower method, of class SuperpowerDaoDB.
     */
    @Test
    public void testUpdateSuperpower() {
        Superpower superpower = new Superpower();

        superpower.setSuperpowerName("Flight");
        superpower = superpowerDao.addSuperpower(superpower);

//        superpower = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        superpower.setSuperpowerName("Shape Shifting");
        superpowerDao.updateSuperpower(superpower);
        Superpower fromDao = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());

        assertEquals(superpower, fromDao);
    }

    /**
     * Test of deleteSuperpowerById method, of class SuperpowerDaoDB.
     */
    @Test
    public void testDeleteSuperpowerById() {
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("flight");
        superpower = superpowerDao.addSuperpower(superpower);

        Hero hero = new Hero();
        hero.setHeroName("Supergirl");
        hero.setHeroDescription("strong");
        hero.setSuperPower(superpower);
        hero = heroDao.addHero(hero);

        Hero heroFromDao = heroDao.getHeroById(hero.getHeroId());
        assertEquals(hero, heroFromDao);
        assertNotNull(heroFromDao);

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

        Organization organization = new Organization();

        organization.setOrganizationName("Zen");
        organization.setOrganizationDescription("Hidden under the Dessert");
        organization.setOrganizationPhoneNum("9292459121");
        organization.setLocation(location);

        List<Hero> heroes = new ArrayList<>();
        heroes.add(hero);
        organization.setHeroes(heroes);
        organizationDao.addOrganization(organization);

        Sighting firstSighting = new Sighting();

        LocalDate date = LocalDate.parse("2017-02-05");

        firstSighting.setDate(date);
        firstSighting.setHero(hero);
        firstSighting.setLocation(location);

        firstSighting = sightingDao.addSighting(firstSighting);

        Superpower fromDao = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());

        assertEquals(superpower, fromDao);
        superpowerDao.deleteSuperpowerById(superpower.getSuperpowerId());

        fromDao = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        heroFromDao = heroDao.getHeroById(hero.getHeroId());

        assertNull(fromDao);
        assertNull(heroFromDao);
    }

}
