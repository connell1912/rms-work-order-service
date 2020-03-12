package com.rms.dao;

import org.springframework.data.repository.CrudRepository;
import com.rms.model.WorkOrder;

/**
 * @author 1912dec16 Java Fullstack Batch
 * <br>
 * <br>
 * The WorkOrderDao interface communicates with our H2 database. It utilizes Spring Data and extends the 
 * CrudRepository which gives us access to built in CRUD methods and allows to create abstract methods using 
 * naming conventions that the CrudRepository recognizes and is able provide default implementation.
 */

public interface WorkOrderDao extends CrudRepository<WorkOrder, Integer> {

}
