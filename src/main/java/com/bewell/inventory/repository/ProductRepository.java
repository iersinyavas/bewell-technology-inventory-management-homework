package com.bewell.inventory.repository;

import com.bewell.inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

    @Modifying(clearAutomatically = true)
    @Query(value = "delete from product p where p.product_id = :productId", nativeQuery = true)
    void deleteProduct(Long productId);
}
