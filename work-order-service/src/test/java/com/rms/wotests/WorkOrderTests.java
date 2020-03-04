package com.rms.wotests;

import static org.junit.Assert.assertTrue;

import com.rms.model.Category;
import com.rms.model.Status;
import com.rms.model.WorkOrder;
import org.junit.Before;
import org.junit.Test;


public class WorkOrderTests {

    WorkOrder wo;

    @Before
    public void setup() {
        wo = new WorkOrder();
    }

    @Test
    public void testSetID() {
        wo.setId(1);
        assertTrue(wo.getId() == 1);
    }

    @Test
    public void setCreatedDate() {
        wo.setCreatedDateTime(null);
        assertTrue(wo.getCreatedDateTime() == null);
    }

    @Test
    public void setResolvedDate() {
        wo.setResolvedDateTime(null);
        assertTrue(wo.getCreatedDateTime() == null);
    }

    @Test
    public void testSetCategory() {
        wo.setCategory(Category.OTHER);
        assertTrue(wo.getCategory().equals(Category.OTHER));
    }

    @Test
    public void testSetStatus() {
        wo.setStatus(Status.PENDING);
        assertTrue(wo.getStatus().equals(Status.PENDING));
    }

    @Test
    public void testSetDescription() {
        wo.setDescription("AC is broken");
        assertTrue(wo.getDescription().equals("AC is broken"));
    }

    @Test
    public void testSetEmail() {
        wo.setContactEmail("test@email.com");
        assertTrue(wo.getContactEmail().equals("test@email.com"));
    }

    @Test
    public void testSetCreatorID() {
        wo.setCreatorId(1);
        assertTrue(wo.getCreatorId() == 1);
    }

    @Test
    public void testSetResolverID() {
        wo.setResolverId(1);
        assertTrue(wo.getResolverId() == 1);
    }

}