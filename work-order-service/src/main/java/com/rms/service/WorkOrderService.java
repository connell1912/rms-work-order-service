package com.rms.service;

import com.rms.dao.WorkOrderDao;
import com.rms.model.WorkOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkOrderService {

    @Autowired
    WorkOrderDao wod;

    public Iterable<WorkOrder> grabAll() {
        return wod.findAll();
    }

    public Optional<WorkOrder> grabById(int id) {
        return wod.findById(id);
    }

    public void addWorkOrder(WorkOrder wo) {
        wod.save(wo);
    }

    public void deleteWO(WorkOrder wo) {
        wod.delete(wo);
    }

    public void deleteWorkOrder(int id) {
        wod.deleteById(id);
    }

    public void updateWorkOrder(WorkOrder wo) {
        wod.save(wo);
    }

}
