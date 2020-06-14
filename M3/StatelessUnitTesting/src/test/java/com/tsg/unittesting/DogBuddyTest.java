/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.unittesting;

import static com.tsg.unittesting.DogBuddy.howManyWoofs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class DogBuddyTest {

    public DogBuddyTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of howManyWoofs method, of class DogBuddy.
     */
    @Test
    public void testTwoBones() {
        // ARRANGE
        int numBones = 2;

        // ACT
        String woofs = howManyWoofs(numBones);

        // ASSERT - w/ Message
        String expectedWoofs = "Woof! Woof! Woof!";
        assertEquals(expectedWoofs, woofs, "Expected 3 Woofs w/ 2 bones");
    }

    @Test
    public void testZeroBones() {
        // ARRANGE
        int numBones = 0;

        // ACT
        String woofs = howManyWoofs(numBones);

        // ASSERT - w/ Message
        String expectedWoofs = "...";
        assertEquals(expectedWoofs, woofs, "Expected silence w/ 0 bones");
    }

    @Test
    public void testNegativeTenBones() {
        // ARRANGE
        int numBones = -10;

        // ACT
        String woofs = howManyWoofs(numBones);

        // ASSERT - w/ Message
        String expectedWoofs = "...";
        assertEquals(expectedWoofs, woofs, "Expected silence w/ -10 bones");
    }

    @Test
    public void testNegativeFiveBones() {
        // ARRANGE
        int numBones = -5;

        // ACT
        String woofs = howManyWoofs(numBones);

        // ASSERT - w/ Message
        String expectedWoofs = "...";
        assertEquals(expectedWoofs, woofs, "Expected silence w/ -5 bones");
    }

}
