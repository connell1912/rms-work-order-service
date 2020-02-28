package com.rms.controller;

import java.sql.Timestamp;

import com.rms.dao.WorkOrderDao;
import com.rms.model.WorkOrder;
import com.rms.service.WorkOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.action.TimestampAction;

@RestController
@RequestMapping("/workorder")
@CrossOrigin(origins={"http://localhost:3000"})
public class WorkOrderController {

    @Autowired
    WorkOrderService wos; 

    @GetMapping("/all")
    public Iterable<WorkOrder> findAll() {
        return wos.grabAll();
    }

    @GetMapping("/{id}")
    public WorkOrder findById(@PathVariable("id") int id) {
        return wos.grabById(id);
    }

    @PostMapping("/newworkorder")
    public String insert(@RequestBody WorkOrder wo) {
        wos.addWorkOrder(wo);
        return "Saved Work Order";
    } 

    // @PutMapping("/{id}")
    // public String updateResolved(@PathVariable("id") int id, Timestamp resolvedtime) {
    //     WorkOrder wo = wod.findById(id).get();
    //     wo.setResolvedDateTime(resolvedtime);
    //     wod.save(wo);
    //     return "Work Order Updated";
    // }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        wos.deleteWorkOrder(id);
        return "Work Order Deleted";
    }

    
}