package com.rms.dao;

import org.springframework.data.repository.CrudRepository;
import com.rms.model.WorkOrder;

public interface WorkOrderDao extends CrudRepository<WorkOrder, Integer> {

    WorkOrder findById(int id);

    

}
