package com.rms.wotests;

import java.sql.Timestamp;

import com.rms.model.Category;
import com.rms.model.Status;
import com.rms.model.WorkOrder;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.boot.test.autoconfigure.json.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.json.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.*;
@RunWith(SpringRunner.class)
@JsonTest
public class WOJsonTests {

    private JacksonTester<WorkOrder> json;

    private Timestamp createdDateTime;
    private Timestamp resolvedDateTime;
    private Category category;
    private Status status;
    private String description;
    private String contactEmail;
    private int creatorId;
    private int resolverId;

    @Before
    public void setup() {
        createdDateTime = null;
        resolvedDateTime = null;
        category = Category.AIR_CONDITIONING;
        status = Status.PENDING;
        description = "AC is broken";
        contactEmail = "email@test.com";
        creatorId = 1;
        resolverId = 2;
    }

    @Test
    public void testSerialize() throws Exception {
        WorkOrder details = new WorkOrder(createdDateTime, resolvedDateTime, category, status, description, contactEmail, creatorId, resolverId);
        assertThat(this.json.write(details)).isEqualToJson("expected.json");
        assertThat(this.json.write(details)).hasJsonPathStringValue("@.make");
        assertThat(this.json.write(details)).extractingJsonPathStringValue("@.make")
                .isEqualTo("email@test.com");
    }

}