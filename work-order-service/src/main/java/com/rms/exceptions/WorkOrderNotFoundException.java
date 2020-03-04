package com.rms.exceptions;

public class WorkOrderNotFoundException extends RuntimeException  {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public WorkOrderNotFoundException(int id) {
        super("WorkOrder id not found: " + id);
    }

    
}