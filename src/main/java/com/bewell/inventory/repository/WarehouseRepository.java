package com.bewell.inventory.repository;

import com.bewell.inventory.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    Warehouse findByName(String name);

    @Query(value = "select w from warehouse w, product p where w.warehouse_id = p.warehouse_id and p.product_id = :productId", nativeQuery = true)
    List<Warehouse> productWhichWarehouse(Long pro);
}
