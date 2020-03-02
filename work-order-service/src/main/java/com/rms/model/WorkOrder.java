package com.rms.model;

import java.sql.Timestamp;
import java.util.Objects;
// import java.util.Locale.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table
public class WorkOrder {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @CreationTimestamp
    private Timestamp createdDateTime;

    @Column
    private Timestamp resolvedDateTime;

    @Column
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column 
    private String description;

    @Column 
    private String contactEmail;

    @Column
    private int creatorId;

    @Column
    private int resolverId;


    

    // public WorkOrder(Timestamp resolvedDateTime, Category category, String description, String contactEmail, int creatorId, int resolverId) {
    //     this.resolvedDateTime = resolvedDateTime;
    //     this.category = category;
    //     this.description = description;
    //     this.contactEmail = contactEmail;
    //     this.creatorId = creatorId;
    //     this.resolverId = resolverId;
    // }


    
    public WorkOrder() {
    }

    public WorkOrder(int id, Timestamp createdDateTime, Timestamp resolvedDateTime, Category category, Status status, String description, String contactEmail, int creatorId, int resolverId) {
        this.id = id;
        this.createdDateTime = createdDateTime;
        this.resolvedDateTime = resolvedDateTime;
        this.category = category;
        this.status = status;
        this.description = description;
        this.contactEmail = contactEmail;
        this.creatorId = creatorId;
        this.resolverId = resolverId;
    }

     public WorkOrder(Timestamp resolvedDateTime, Category category, Status status, String description, String contactEmail, int creatorId) {
        this.resolvedDateTime = resolvedDateTime;
        this.category = category;
        this.status = status;
        this.description = description;
        this.contactEmail = contactEmail;
        this.creatorId = creatorId;
    }

    public WorkOrder(Category category, Status status, String description, String contactEmail, int creatorId) {
        this.category = category;
        this.status = status;
        this.description = description;
        this.contactEmail = contactEmail;
        this.creatorId = creatorId;
    }

    public WorkOrder(int id, Category category, Status status, String description, String contactEmail, int creatorId) {
        this.id = id;
        this.category = category;
        this.status = status;
        this.description = description;
        this.contactEmail = contactEmail;
        this.creatorId = creatorId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreatedDateTime() {
        return this.createdDateTime;
    }

    public void setCreatedDateTime(Timestamp createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Timestamp getResolvedDateTime() {
        return this.resolvedDateTime;
    }

    public void setResolvedDateTime(Timestamp resolvedDateTime) {
        this.resolvedDateTime = resolvedDateTime;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public WorkOrder createdDateTime(Timestamp createdDateTime) {
        this.createdDateTime = createdDateTime;
        return this;
    }

    public WorkOrder resolvedDateTime(Timestamp resolvedDateTime) {
        this.resolvedDateTime = resolvedDateTime;
        return this;
    }

    public WorkOrder category(Category category) {
        this.category = category;
        return this;
    }

    public WorkOrder status(Status status) {
        this.status = status;
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
        return id == workOrder.id && Objects.equals(createdDateTime, workOrder.createdDateTime) && Objects.equals(resolvedDateTime, workOrder.resolvedDateTime) && Objects.equals(category, workOrder.category) && Objects.equals(status, workOrder.status) && Objects.equals(description, workOrder.description) && Objects.equals(contactEmail, workOrder.contactEmail) && creatorId == workOrder.creatorId && resolverId == workOrder.resolverId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDateTime, resolvedDateTime, category, status, description, contactEmail, creatorId, resolverId);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", createdDateTime='" + getCreatedDateTime() + "'" +
            ", resolvedDateTime='" + getResolvedDateTime() + "'" +
            ", category='" + getCategory() + "'" +
            ", status='" + getStatus() + "'" +
            ", description='" + getDescription() + "'" +
            ", contactEmail='" + getContactEmail() + "'" +
            ", creatorId='" + getCreatorId() + "'" +
            ", resolverId='" + getResolverId() + "'" +
            "}";
    }
    

}