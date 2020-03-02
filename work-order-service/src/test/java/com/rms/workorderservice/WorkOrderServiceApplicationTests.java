package com.rms.workorderservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.rms.dao.WorkOrderDao;
import com.rms.model.Category;
import com.rms.model.Status;
import com.rms.model.WorkOrder;
import com.rms.service.WorkOrderService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorkOrderServiceApplicationTests {

	// @Test
	// void contextLoads() {
	// }

	@InjectMocks
	WorkOrderService wos;

	@Mock
	WorkOrderDao wod;

	@Test
	public void testSaveNewWorkOrder() {
		WorkOrder wo = new WorkOrder(null, Category.OTHER, Status.PENDING, "Test work order", "test1@test.com", 1);
		wos.addWorkOrder(wo);
		verify(wod, times(1)).save(wo);
	}

	@Test
	public void testGrabAll() {
		Iterable<WorkOrder> wo = wos.grabAll();
		assertNotNull(wo);
	}

	@Test
	public void testGrabById() {
		// when(wod.findById(1)).thenReturn(new WorkOrder(null, Category.OTHER, Status.PENDING, "Test 2", "test2@test.com", 1));
		
		// boolean bool = false;
		// Optional<WorkOrder> wo1 = wod.findById(1);
		// WorkOrder wo2 = wos.grabById(1);
		// if(wo2.equals(wo1)) {
		// 	bool = true;
		// } else {
		// 	bool = false;
		// }
		// assertNotNull(bool);
		WorkOrder wo = new WorkOrder(null, Category.OTHER, Status.PENDING, "Test work order", "test1@test.com", 1);
		wos.addWorkOrder(wo);
		WorkOrder wo2 = wos.grabById(0);
		assertNotNull(wo2);
	}

	@Test
	public void testUpdateWorkOrder() {
		WorkOrder wo = new WorkOrder(null, Category.OTHER, Status.PENDING, "Test work order", "test1@test.com", 1);
		wos.addWorkOrder(wo);
		// System.out.println("Here is the id number: "+wo.getId()+wo.getDescription());
		
		// WorkOrder wo2 = wos.grabById(0);
		WorkOrder wo2 = wo;

		wo2 = new WorkOrder(null, Category.DOORS, Status.PENDING, "Testing a door", "test2@test.com", 1);
		wos.updateWorkOrder(wo2);
		System.out.println("LOOK HERE: "+wo2.getDescription());
		assertEquals("Testing a door", wo2.getDescription());
	}

}
