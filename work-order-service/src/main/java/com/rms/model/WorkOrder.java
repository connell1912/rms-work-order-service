package com.rms.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data
@AllArgsConstructor
@ToString
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

    public WorkOrder() {
        super();
    }

    public WorkOrder(Timestamp createdDateTime, Timestamp resolvedDateTime, Category category, Status status,
            String description, String contactEmail, int creatorId, int resolverId) {
        this.createdDateTime = createdDateTime;
        this.resolvedDateTime = resolvedDateTime;
        this.category = category;
        this.status = status;
        this.description = description;
        this.contactEmail = contactEmail;
        this.creatorId = creatorId;
        this.resolverId = resolverId;
    }

    public WorkOrder(Timestamp resolvedDateTime, Category category, Status status, String description,
            String contactEmail, int creatorId) {
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

}