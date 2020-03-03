package com.rms.wotests;

import static org.junit.Assert.assertEquals;

import com.rms.model.Status;

import org.junit.Test;

public class StatusTests {
    
    @Test
    public void testPending() {
        assertEquals("PENDING", Status.PENDING.name());
    }

    @Test
    public void testCompleted() {
        assertEquals("COMPLETED", Status.COMPLETED.name());
    }

    @Test
    public void testDenied() {
        assertEquals("DENIED", Status.DENIED.name());
    }

}