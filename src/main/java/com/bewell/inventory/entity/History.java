package com.bewell.inventory.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "history", schema = "inventory_management")
public class History implements Serializable {

    @Id
    @Column(name = "history_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_gen")
    @SequenceGenerator(name = "history_gen", sequenceName = "inventory_management.history_seq", allocationSize = 1)
    private Long historyId;

    @Column(name = "operationStatusCode")
    private String operationStatusCode;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "product_id")
    private Product product;
}
