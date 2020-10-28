/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.daos;

import com.example.Mastery.CMS.dtos.Hashtag;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
public class HashtagDaoDBTest {

    @Autowired
    HashtagDao hashtagDao;

    public HashtagDaoDBTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {

        List<Hashtag> hashtags = hashtagDao.getAllHashtags();
        for (Hashtag hashtag : hashtags) {
            hashtagDao.deleteHashtag(hashtag.getId());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getHashTagById method, of class HashtagDaoDB.
     */
    @Test
    public void testAddGetHashTagById() {

        Hashtag hashtag = new Hashtag();
        hashtag.setName("Test Hashtag");
        hashtag = hashtagDao.createHashTag(hashtag);

        Hashtag fromDao = hashtagDao.getHashTagById(hashtag.getId());

        assertEquals(hashtag, fromDao);
    }

    /**
     * Test of getHashtagByName method, of class HashtagDaoDB.
     */
    @Test
    public void testAddGetHashtagByName() {
        Hashtag hashtag = new Hashtag();
        hashtag.setName("#test");

        hashtag = hashtagDao.createHashTag(hashtag);

        Hashtag fromDao = hashtagDao.getHashtagByName(hashtag.getName());

        assertEquals(hashtag, fromDao);

    }

    /**
     * Test of getAllHashtags method, of class HashtagDaoDB.
     */
    @Test
    public void testGetAllHashtags() {
        Hashtag hashtag = new Hashtag();
        hashtag.setName("#Family");
        hashtag = hashtagDao.createHashTag(hashtag);

        Hashtag hashtag2 = new Hashtag();
        hashtag2.setName("#Friends");
        hashtag2 = hashtagDao.createHashTag(hashtag2);

        List<Hashtag> hashtags = hashtagDao.getAllHashtags();

        assertEquals(2, hashtags.size());
        assertTrue(hashtags.contains(hashtag));
        assertTrue(hashtags.contains(hashtag2));

    }

    /**
     * Test of deleteHashtag method, of class HashtagDaoDB.
     */
    @Test
    public void testDeleteHashtag() {
        Hashtag hashtag = new Hashtag();
        hashtag.setName("#TestFirst");
        hashtag = hashtagDao.createHashTag(hashtag);

        Hashtag fromDao = hashtagDao.getHashTagById(hashtag.getId());

        assertEquals(hashtag, fromDao);
        hashtagDao.deleteHashtag(hashtag.getId());
        fromDao = hashtagDao.getHashTagById(hashtag.getId());

        assertNull(fromDao);

    }

    /**
     * Test of updateHashtag method, of class HashtagDaoDB.
     */
    @Test
    public void testUpdateHashtag() {
        Hashtag hashtag = new Hashtag();
        hashtag.setName("#Testfirst");
        hashtag = hashtagDao.createHashTag(hashtag);
        
        Hashtag fromDao = hashtagDao.getHashTagById(hashtag.getId());
        
        assertEquals(hashtag, fromDao);
        
        hashtag.setName("#NewTestFirst");
        hashtagDao.updateHashtag(hashtag);
        
        assertNotEquals(hashtag, fromDao);
        fromDao = hashtagDao.getHashTagById(hashtag.getId());
        
        assertEquals(hashtag, fromDao);
    }

   

}
