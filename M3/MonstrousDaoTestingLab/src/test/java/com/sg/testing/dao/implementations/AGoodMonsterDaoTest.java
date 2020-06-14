/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.testing.dao.implementations;

import com.sg.testing.dao.MonsterDao;
import com.sg.testing.model.Monster;
import com.sg.testing.model.MonsterType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class AGoodMonsterDaoTest {

    MonsterDao testDao;

    public AGoodMonsterDaoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        testDao = new AGoodMonsterDao();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetMonster() {
        //ARRANGE
        int id = 1;
//        String monsterName = "John";
//        MonsterType type= MonsterType.VAMPIRE;
//        int eaten = 12;
//        String fav = "Food";
        Monster m = new Monster("John", MonsterType.VAMPIRE, 12, "Food");

        //ACT
        testDao.addMonster(id, m);//adding
        Monster retrievedMonster = testDao.getMonster(id);//getting

        //ASSERT
        assertEquals(m.getName(),//expected
                retrievedMonster.getName(),//result
                "Checking name");
        assertEquals(m.getType(),
                retrievedMonster.getType(),
                "Checking type");
        assertEquals(m.getPeopleEaten(),
                retrievedMonster.getPeopleEaten(),
                "Checking type");
        assertEquals(m.getFavoriteFood(),
                retrievedMonster.getFavoriteFood(),
                "Checking food");
    }

}
