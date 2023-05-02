package com.bewell.inventory.repository;

import com.bewell.inventory.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    Warehouse findByName(String name);

    @Query(value = "select w from ProductWarehouse pw, Product p, Warehouse w where pw.product.productId = p.productId and pw.warehouseId = w.warehouseId and pw.quantity > 0 and p.name = :productName")
    List<Warehouse> productWhichWarehouse(String productName);
}
