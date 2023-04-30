package com.bewell.inventory.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product", schema = "inventory_management")
public class ProductWarehouse implements Serializable {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_gen")
    @SequenceGenerator(name = "product_gen", sequenceName = "inventory_management.product_seq", allocationSize = 1)
    private Long productWarehouseId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id")
    private Warehouse warehouse;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "critical_quantity")
    private BigDecimal criticalQuantity;
}
