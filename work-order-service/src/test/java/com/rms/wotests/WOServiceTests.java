package com.rms.wotests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import com.rms.WorkOrderServiceApplication;
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

    private WorkOrder wo;

    @Autowired
    private WorkOrderService ws;

    @Before
    public void setup() {
        wo = new WorkOrder(Category.AIR_CONDITIONING, Status.PENDING, "The AC is broken", "test@email.com", 1);
    }

    @Test
    public void testEmployeeService() {
        assertTrue(ws != null);
    }

    @Test
    public void saveTest() {
        ws.addWorkOrder(wo);
        System.out.println("****************Test**************** \n" + ws.grabById(1));
        assertTrue(ws.grabById(1) != null);
    }

    @Test
    public void findByIdTest() {
        WorkOrder wo = ws.grabById(1);
        System.out.println("***********\n" + wo);
        assertNotNull(wo);
    }

    @Test
    public void updateTest() {
        System.out.println("*********************update\n");
        WorkOrder wo = ws.grabById(1);
        System.out.println(wo);
        wo.setContactEmail("wow@test.com");
        WorkOrder wo2 = ws.grabById(1);
        ws.updateWorkOrder(wo2);
        assertNotSame(wo, wo2);
    }

    @Test
    public void deleteTest() {
    WorkOrder wo2 = ws.grabById(6);
    System.out.println(wo2);
    ws.deleteWO(wo2);
    WorkOrder wo3 = ws.grabById(6);
    assertFalse(wo3 != null);
    }

    @Test
    public void findAllTest() {
    List<WorkOrder> ls = (List<WorkOrder>) ws.grabAll();
    System.out.println("\n***********:\n"+ls);
    assertTrue(ls != null);
    }

}