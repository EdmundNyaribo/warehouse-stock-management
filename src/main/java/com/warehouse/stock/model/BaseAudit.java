package com.warehouse.stock.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Column;
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseAudit  {
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Long createdDate = System.currentTimeMillis();

    @Column(name = "modified_date")
    @LastModifiedDate
    private Long modifiedDate;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;
}
