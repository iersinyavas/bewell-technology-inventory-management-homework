package com.bewell.inventory.repository;

import com.bewell.inventory.entity.ProductWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductWarehouseRepository extends JpaRepository<ProductWarehouse, Long> {

    Optional<ProductWarehouse> getProductWarehouseByProductNameAndWarehouseId(String productName, Long warehouseId);

    @Query(value = "select pw from ProductWarehouse pw where pw.product.productId = :productId")
    List<ProductWarehouse> getProductWarehouseByProductId(Long productId);


}
