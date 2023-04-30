package com.bewell.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operation_status", schema = "inventory_management")
public class OperationStatus {

    @Id
    @Column(name = "oparation_status_id")
    private Long operationStatusId;

    @Column(name = "code")
    private String code;
}
