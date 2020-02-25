package com.rms.model;

import java.util.Locale.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// @Entity
// @Table
public class WorkOrder {
    
    // @Id
    // @Column
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // @Column
    private String createdDateTime;

    // @Column
    private String resolvedDateTime;

    // @Column
    private Category category;

    // @Column 
    private String description;

    // @Column 
    private String contactEmail;

    // @Column
    private int creatorId;

    // @Column
    private int resolverId;

}