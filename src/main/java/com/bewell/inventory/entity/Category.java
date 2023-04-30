package com.bewell.inventory.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "category", schema = "inventory_management")
public class Category implements Serializable {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_gen")
    @SequenceGenerator(name = "category_gen", sequenceName = "inventory_management.category_seq", allocationSize = 1)
    private Long categoryId;

    @Column(name = "name")
    private String name;

}
