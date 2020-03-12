package com.rms.controller;

import com.rms.exceptions.WorkOrderNotFoundException;
import com.rms.model.WorkOrder;
import com.rms.service.WorkOrderService;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/
 * @author 1912dec16 Java Fullstack Batch
 * <br>
 * <br>
 * The WorkOrderController class communicates with our front end. This class includes
 * the annotations: 
 * @RestController This annotation is applied to a class to mark it as a request handler
 * @RequestMapping maps the requests for our class
 * @CrossOrigins the communcation with the port tied to the front end
 */
	 
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
        return wos.grabById(id).orElseThrow(() -> new WorkOrderNotFoundException(id));
    }

	@PostMapping("/new")
    public String insert(@RequestBody WorkOrder wo) {
        wos.addWorkOrder(wo);
        return "Saved Work Order";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        wos.deleteWorkOrder(id);
        return "Work Order Deleted";
    }

    
}
