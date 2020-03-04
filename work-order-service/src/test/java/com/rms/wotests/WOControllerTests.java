package com.rms.wotests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

import com.rms.model.Category;
import com.rms.model.Status;
import com.rms.model.WorkOrder;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class WOControllerTests extends AbstractTest {

    private Timestamp createdDateTime;
    private Timestamp resolvedDateTime;
    private Category category;
    private Status status;
    private String description;
    private String contactEmail;
    private int creatorId;
    private int resolverId;
    private WorkOrder wo;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        createdDateTime = null;
        resolvedDateTime = null;
        category = Category.AIR_CONDITIONING;
        status = Status.PENDING;
        description = "AC is broken";
        contactEmail = "test@email.com";
        creatorId = 1;
        resolverId = 1;
        wo = new WorkOrder(createdDateTime, resolvedDateTime, category, status, description, contactEmail, creatorId,
                resolverId);
    }

    @Test
    public void getProductsList() throws Exception {
        String uri = "/workorder/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        WorkOrder[] wo = super.mapFromJson(content, WorkOrder[].class);
        assertTrue(wo.length > 0);
    }

    @Test
    public void createProduct() throws Exception {
        String uri = "/workorder/newworkorder";

        String inputJson = super.mapToJson(wo);
        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Saved Work Order");
    }

    @Test
   public void deleteProduct() throws Exception {
      String uri = "/workorder/20";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Work Order Deleted");
   }

}