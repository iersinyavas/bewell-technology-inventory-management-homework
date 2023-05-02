package com.bewell.inventory.dao;

import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.dto.ProductWarehouseDTO;
import com.bewell.inventory.entity.Product;
import com.bewell.inventory.entity.ProductWarehouse;
import com.bewell.inventory.mapper.ProductMapper;
import com.bewell.inventory.mapper.ProductWarehouseMapper;
import com.bewell.inventory.repository.ProductRepository;
import com.bewell.inventory.notification.email.EmailDetail;
import com.bewell.inventory.notification.email.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductDAO {

    private final ProductRepository productRepository;

    public ProductDTO getProduct(Long productId){
        return ProductMapper.INSTANCE.entityToDTO(productRepository.findById(productId).get());
    }

    public ProductDTO getProduct(String productName){
        return ProductMapper.INSTANCE.entityToDTO(productRepository.findByName(productName));
    }

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.dtoToEntity(productDTO);
        return ProductMapper.INSTANCE.entityToDTO(productRepository.save(product));
    }

    public ProductDTO updateProduct(ProductDTO productDTO){
        Product product = productRepository.findById(productDTO.getProductId()).get();
        product = ProductMapper.INSTANCE.dtoToTargetEntity(productDTO, product);
        return ProductMapper.INSTANCE.entityToDTO(productRepository.save(product));
    }

    public void delete(Long productId) {
        productRepository.delete(productRepository.getOne(productId));
    }
}
