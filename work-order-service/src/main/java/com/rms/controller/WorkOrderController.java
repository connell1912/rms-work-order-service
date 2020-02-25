package com.rms.controller;

import com.rms.dao.WorkOrderDao;
import com.rms.model.WorkOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workorder")
public class WorkOrderController {

    @Autowired
    WorkOrderDao wod; 

    @GetMapping("all")
    public Iterable<WorkOrder> findAll() {
        return wod.findAll();
    }

    @GetMapping("/{id}")
    public WorkOrder findById(@PathVariable("id") int id) {
        return wod.findById(id).get();
    }

    @PostMapping
    public String insert(@RequestBody WorkOrder wo) {
        wod.save(wo);
        return "Saved Work Order";
    } 

    @PutMapping("/{id}")
    public String updateResolved(@PathVariable("id") int id, String resolvedtime) {
        WorkOrder wo = wod.findById(id).get();
        wo.setResolvedDateTime(resolvedtime);
        wod.save(wo);
        return "Work Order Updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        wod.deleteById(id);
        return "Work Order Deleted";
    }

    
}