package com.bewell.inventory.dao;

import com.bewell.inventory.dto.ProductWarehouseDTO;
import com.bewell.inventory.entity.Product;
import com.bewell.inventory.entity.ProductWarehouse;
import com.bewell.inventory.mapper.ProductWarehouseMapper;
import com.bewell.inventory.repository.ProductRepository;
import com.bewell.inventory.repository.ProductWarehouseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class InventoryDAO {

    private final ProductWarehouseRepository productWarehouseRepository;
    private final ProductRepository productRepository;

    public ProductWarehouseDTO updateProductWarehouse(ProductWarehouseDTO productWarehouseDTO){
        ProductWarehouse productWarehouse = productWarehouseRepository.getProductWarehouseByProductNameAndWarehouseId(productWarehouseDTO.getProductName(), productWarehouseDTO.getWarehouseId()).get();
        productWarehouse = ProductWarehouseMapper.INSTANCE.dtoToTargetEntity(productWarehouseDTO, productWarehouse);
        return ProductWarehouseMapper.INSTANCE.entityToDTO(productWarehouseRepository.save(productWarehouse));
    }

    public ProductWarehouseDTO addProductWarehouse(ProductWarehouseDTO productWarehouseDTO) {
        Product product = productRepository.findByName(productWarehouseDTO.getProductName());
        ProductWarehouse productWarehouse = ProductWarehouseMapper.INSTANCE.dtoToEntity(productWarehouseDTO);
        productWarehouse.setProduct(product);
        return ProductWarehouseMapper.INSTANCE.entityToDTO(productWarehouseRepository.save(productWarehouse));
    }

    public ProductWarehouseDTO getProductWarehouseByProductNameAndWarehouseId(ProductWarehouseDTO productWarehouseDTO){
        ProductWarehouse productWarehouse = productWarehouseRepository.getProductWarehouseByProductNameAndWarehouseId(productWarehouseDTO.getProductName(), productWarehouseDTO.getWarehouseId()).orElse(null);
        return ProductWarehouseMapper.INSTANCE.entityToDTO(productWarehouse);
    }

}
