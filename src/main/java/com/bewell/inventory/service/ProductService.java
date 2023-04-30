package com.bewell.inventory.service;

import com.bewell.inventory.dao.ProductDAO;
import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService{

    private final ProductDAO productDAO;

    public ProductDTO getProduct(Long productId) {
        return productDAO.getProduct(productId);
    }

    public ProductDTO getProduct(String productName) {
        return productDAO.getProduct(productName);
    }

    public ProductDTO addProduct(ProductDTO productDTO) {
        return productDAO.addProduct(productDTO);
    }

    public void updateProduct(Product product) {

    }

    public void deleteProduct(Long productId) {

    }

    public ProductDTO addQuantity(ProductDTO productDTO){
        return productDAO.addQuantity(productDTO);
    }

    public ProductDTO subtractQuantity(ProductDTO productDTO){
        return productDAO.subtractQuantity(productDTO);
    }

}
