package com.rms.wotests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockWOServiceTests {

	private WorkOrder wo;

	@InjectMocks
	WorkOrderService wos;

	@Mock
	WorkOrderDao wod;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		wo = new WorkOrder(Category.OTHER, Status.PENDING, "Test work order", "test1@test.com", 1);
	}

	@Test
	public void testSaveNewWorkOrder() {
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
		when(wod.findById(1)).thenReturn(Optional.of(wo));
		WorkOrder wo2 = wos.grabById(1);
		assertEquals("test1@test.com", wo2.getContactEmail());
	}

	@Test
	public void testUpdateWorkOrder() {
		wos.addWorkOrder(wo);

		WorkOrder wo2 = wo;

		wo2 = new WorkOrder(null, Category.DOORS, Status.PENDING, "Testing a door", "test2@test.com", 1);
		wos.updateWorkOrder(wo2);
		// System.out.println("LOOK HERE: "+wo2.getDescription());
		assertEquals("Testing a door", wo2.getDescription());
	}

	@Test
	public void testDeleteWorkOrder() {
		wos.addWorkOrder(wo);
		when(wod.findById(1)).thenReturn(Optional.of(wo));
		wos.deleteWorkOrder(1);
		assertFalse(wo != null);
	}

}
