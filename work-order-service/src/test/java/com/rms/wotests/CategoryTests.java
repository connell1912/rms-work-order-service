package com.rms.wotests;

import static org.junit.Assert.assertEquals;

import com.rms.model.Category;

import org.junit.Test;

public class CategoryTests {

    @Test
    public void testLighting() {
        assertEquals("LIGHTING", Category.LIGHTING.name());
    }

    @Test
    public void testAC() {
        assertEquals("AIR_CONDITIONING", Category.AIR_CONDITIONING.name());
    }

    @Test
    public void testDoors() {
        assertEquals("DOORS", Category.DOORS.name());
    }

    @Test
    public void testProjector() {
        assertEquals("PROJECTOR", Category.PROJECTOR.name());
    }

    @Test
    public void testOther() {
        assertEquals("OTHER", Category.OTHER.name());
    }

}