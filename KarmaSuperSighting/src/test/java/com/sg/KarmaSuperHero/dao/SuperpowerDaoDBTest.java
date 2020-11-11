/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.dao;

import com.sg.KarmaSuperHero.TestApplicationConfiguration;
import com.sg.KarmaSuperHero.dto.Superpower;
import java.util.List;
import static org.junit.Assert.assertEquals;
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
        superpowerDao.addSuperpower(superpower);

        Superpower fromDao = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());

        assertEquals(superpower, fromDao);
        superpowerDao.deleteSuperpowerById(superpower.getSuperpowerId());
        fromDao = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        assertNull(fromDao);
    }

}
