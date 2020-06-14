/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.unittesting;

import static com.tsg.unittesting.HappyLlamas.areTheLlamasHappy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class HappyLlamasTest {

    public HappyLlamasTest() {
    }

    @Test
    public void testSomeMethod() {
    }

    @Test
    public void testNormalTrampoline10() {
        // ARRANGE - for simple methods, this means setting up the parameters
        boolean isNasaFabric = false;
        int numTrampolines = 10;

        // ACT - for simple methods, this generally means calling the method under test
        // and then capturing its return to assert on
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);

        // ASSERT - basically just a conditional that proves the result is what
        // you expect it to be, plus an extra message to display if it doesn't match.
        //
        // There are a wide variety of assert types, here we
        // just want to assert that it returned false. But we could have also used
        // assertEquals and passed in a false value.
        assertFalse(result, "10 Llamas w/ Normal Trampolines should be Unhappy!");
    }

    @Test
    public void testNormalTrampoline24() {
        boolean isNasaFabric = false;
        int numTrampolines = 24;
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);
        assertTrue(result, "24 llama w/Normal Trampolines should be happy");
//assertTrue(areTheLlamasHappy(false, 24), "24 Llamas w/ Normal Trampolines should be Happy!");
    }

    @Test
    public void testNormalTrampoline30() {
        boolean isNasaFabric = false;
        int numTrampolines = 30;
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);
        assertTrue(result, "30 llama w/Normal Trampolines should be happy");
    }

    @Test
    public void testNormalTrampoline42() {
        boolean isNasaFabric = false;
        int numTrampolines = 42;
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);
        assertTrue(result, "42 llama w/Normal Trampolines should be happy");
    }

    @Test
    public void testNormalTrampoline50() {
        boolean isNasaFabric = false;
        int numTrampolines = 50;
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);
        assertFalse(result, "50 llama w/Normal Trampolines should be unhappy");
    }

    @Test
    public void testNormalBounce10() {
        boolean isNasaFabric = true;
        int numTrampolines = 10;
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);
        assertFalse(result, "10 lla,a w/Normal Trampolines should be Unhappy");
    }

    @Test
    public void testNormalBounce24() {
        boolean isNasaFabric = true;
        int numTrampolines = 24;
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);
        assertTrue(result, "24 lla,a w/bouncy Trampolines should be happy");
    }

    @Test
    public void testNormalBounce30() {
        boolean isNasaFabric = true;
        int numTrampolines = 30;
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);
        assertTrue(result, "30 llama w/bouncy Trampolines should be happy");
    }

    @Test
    public void testNormalBounce42() {
        boolean isNasaFabric = true;
        int numTrampolines = 42;
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);
        assertTrue(result, "42 llama w/bouncy Trampolines should be happy");
    }

    @Test
    public void testNormalBounce50() {
        boolean isNasaFabric = true;
        int numTrampolines = 50;
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);
        assertTrue(result, "50 llama w/boucy Trampolines should be happy");
    }

}
