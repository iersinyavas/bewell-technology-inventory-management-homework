package com.bewell.inventory.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "warehouse", schema = "inventory_management")
public class Warehouse implements Serializable {

    @Id
    @Column(name = "warehouse_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "warehouse_gen")
    @SequenceGenerator(name = "warehouse_gen", sequenceName = "inventory_management.warehouse_seq", allocationSize = 1)
    private Long warehouseId;

    @Column(name = "name")
    private String name;

    @Column(name = "region")
    private String region;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;
}
