package com.bewell.inventory.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product_warehouse", schema = "inventory_management")
public class ProductWarehouse implements Serializable {

    @Id
    @Column(name = "product_warehouse_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_warehouse_gen")
    @SequenceGenerator(name = "product_warehouse_gen", sequenceName = "inventory_management.product_warehouse_seq", allocationSize = 1)
    private Long productWarehouseId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "critical_quantity")
    private BigDecimal criticalQuantity;
}
