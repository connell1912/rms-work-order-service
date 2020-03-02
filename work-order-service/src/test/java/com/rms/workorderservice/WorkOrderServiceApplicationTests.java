package com.rms.workorderservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rms.dao.WorkOrderDao;
import com.rms.model.Category;
import com.rms.model.Status;
import com.rms.model.WorkOrder;
import com.rms.service.WorkOrderService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class WorkOrderServiceApplicationTests {

	// @Test
	// void contextLoads() {
	// }

	@InjectMocks
	WorkOrderService wos;

	@Mock
	WorkOrderDao wod;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

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
		when(wod.findById(1)).thenReturn(new WorkOrder(36, Category.OTHER, Status.PENDING, "Test 2", "test2@test.com", 1));
		WorkOrder wo2 = wod.findById(1);
		assertEquals("Test 2", wo2.getDescription());
	}

	@Test
	public void testUpdateWorkOrder() {
		WorkOrder wo = new WorkOrder(null, Category.OTHER, Status.PENDING, "Test work order", "test1@test.com", 1);
		wos.addWorkOrder(wo);

		WorkOrder wo2 = wo;

		wo2 = new WorkOrder(null, Category.DOORS, Status.PENDING, "Testing a door", "test2@test.com", 1);
		wos.updateWorkOrder(wo2);
		// System.out.println("LOOK HERE: "+wo2.getDescription());
		assertEquals("Testing a door", wo2.getDescription());
	}

	@Test
	public void testDeleteWorkOrder() {
		WorkOrder wo = new WorkOrder(33, Category.OTHER, Status.PENDING, "Testing delete", "test3@test.com", 3);
		wos.addWorkOrder(wo);
		WorkOrder wo2 = wos.grabById(33);
		wos.deleteWorkOrder(33);
		assertFalse(wo2 != null);
	}

}
