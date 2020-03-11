package com.rms.wotests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.Timestamp;
import java.util.List;

import com.rms.model.Category;
import com.rms.model.Status;
import com.rms.model.WorkOrder;
import com.rms.service.WorkOrderService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WOServiceTests {

    private Timestamp createdDateTime;
    private Timestamp resolvedDateTime;
    private Category category;
    private Status status;
    private String description;
    private String contactEmail;
    private int creatorId;
    private int resolverId;
    private WorkOrder wo;

    @Autowired
    private WorkOrderService ws;

    @Before
    public void setup() {
        createdDateTime = null;
        category = Category.AIR_CONDITIONING;
        status = Status.PENDING;
        description = "AC is broken";
        contactEmail = "test@email.com";
        creatorId = 1;
        resolverId = 1;
        wo = new WorkOrder(createdDateTime, category, status, description, contactEmail, creatorId,
                resolverId);
    }

    @Test
    public void testEmployeeService() {
        assertTrue(ws != null);
    }

    @Test
    public void saveTest() {
        ws.addWorkOrder(wo);
        System.out.println("****************Test**************** \n" + ws.grabById(13));
        assertTrue(ws.grabById(13) != null);
    }

    @Test
    public void findByIdTest() {
        WorkOrder wo = ws.grabById(13).get();
        System.out.println("***********\n" + wo);
        assertNotNull(wo);
    }

    @Test
    public void updateTest() {
        System.out.println("*********************update\n");
        WorkOrder wo = ws.grabById(13).get();
        System.out.println(wo);
        wo.setContactEmail("wow@test.com");
        WorkOrder wo2 = ws.grabById(13).get();
        ws.updateWorkOrder(wo2);
        assertNotSame(wo, wo2);
    }

    @Test
    public void findAllTest() {
    List<WorkOrder> ls = (List<WorkOrder>) ws.grabAll();
    System.out.println("\n***********:\n"+ls);
    assertTrue(ls != null);
    }

}
