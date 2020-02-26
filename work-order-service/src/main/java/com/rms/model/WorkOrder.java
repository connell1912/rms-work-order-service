package com.rms.model;

import java.util.Objects;
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


    public WorkOrder() {
        
    }

    public WorkOrder(int id, String createdDateTime, String resolvedDateTime, Category category, String description, String contactEmail, int creatorId, int resolverId) {
        this.id = id;
        this.createdDateTime = createdDateTime;
        this.resolvedDateTime = resolvedDateTime;
        this.category = category;
        this.description = description;
        this.contactEmail = contactEmail;
        this.creatorId = creatorId;
        this.resolverId = resolverId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedDateTime() {
        return this.createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getResolvedDateTime() {
        return this.resolvedDateTime;
    }

    public void setResolvedDateTime(String resolvedDateTime) {
        this.resolvedDateTime = resolvedDateTime;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getCreatorId() {
        return this.creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getResolverId() {
        return this.resolverId;
    }

    public void setResolverId(int resolverId) {
        this.resolverId = resolverId;
    }

    public WorkOrder id(int id) {
        this.id = id;
        return this;
    }

    public WorkOrder createdDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
        return this;
    }

    public WorkOrder resolvedDateTime(String resolvedDateTime) {
        this.resolvedDateTime = resolvedDateTime;
        return this;
    }

    public WorkOrder category(Category category) {
        this.category = category;
        return this;
    }

    public WorkOrder description(String description) {
        this.description = description;
        return this;
    }

    public WorkOrder contactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
        return this;
    }

    public WorkOrder creatorId(int creatorId) {
        this.creatorId = creatorId;
        return this;
    }

    public WorkOrder resolverId(int resolverId) {
        this.resolverId = resolverId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WorkOrder)) {
            return false;
        }
        WorkOrder workOrder = (WorkOrder) o;
        return id == workOrder.id && Objects.equals(createdDateTime, workOrder.createdDateTime) && Objects.equals(resolvedDateTime, workOrder.resolvedDateTime) && Objects.equals(category, workOrder.category) && Objects.equals(description, workOrder.description) && Objects.equals(contactEmail, workOrder.contactEmail) && creatorId == workOrder.creatorId && resolverId == workOrder.resolverId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDateTime, resolvedDateTime, category, description, contactEmail, creatorId, resolverId);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", createdDateTime='" + getCreatedDateTime() + "'" +
            ", resolvedDateTime='" + getResolvedDateTime() + "'" +
            ", category='" + getCategory() + "'" +
            ", description='" + getDescription() + "'" +
            ", contactEmail='" + getContactEmail() + "'" +
            ", creatorId='" + getCreatorId() + "'" +
            ", resolverId='" + getResolverId() + "'" +
            "}";
    }


}