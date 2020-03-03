package com.rms.wotests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
        System.out.println(ws);
        wo.setContactEmail("wow@test.com");
        ws.addWorkOrder(wo);
    }

    // @Test
    // public void deleteTest() {
    // ws.deleteWO(wo);
    // WorkOrder wo2 = ws.grabById(12);
    // assertTrue(wo2 == null);
    // }

    // @Test
    // public void findAllTest() {
    // List<WorkOrder> ls = (List<WorkOrder>) ws.grabAll();
    // System.out.println("\n***********:\n"+ls);
    // assertTrue(ls != null);
    // }

}