package com.bewell.inventory.service;

import com.bewell.inventory.dao.HistoryDAO;
import com.bewell.inventory.dao.InventoryDAO;
import com.bewell.inventory.dao.ProductDAO;
import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.dto.ProductWarehouseDTO;
import com.bewell.inventory.entity.Product;
import com.bewell.inventory.entity.ProductWarehouse;
import com.bewell.inventory.enumeration.OperationStatusCode;
import com.bewell.inventory.repository.ProductWarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService{

    private final ProductDAO productDAO;
    private final HistoryDAO historyDAO;
    private final ProductWarehouseRepository productWarehouseRepository;

    public ProductDTO getProduct(Long productId) {
        return productDAO.getProduct(productId);
    }

    public ProductDTO getProduct(String productName) {
        return productDAO.getProduct(productName);
    }

    public ProductDTO addProduct(ProductDTO productDTO) {
        ProductDTO product = this.getProduct(productDTO.getName());
        if (Objects.nonNull(product)){
            return product;
        }
        productDTO = productDAO.addProduct(productDTO);
        ProductWarehouseDTO productWarehouseDTO = new ProductWarehouseDTO();
        productWarehouseDTO.setProductName(productDTO.getName());
        historyDAO.addHistory(OperationStatusCode.NEW_ADD_PRODUCT.getValue(), productWarehouseDTO);
        return productDTO;
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        return productDAO.updateProduct(productDTO);
    }

    public void deleteProduct(Long productId) {
        List<ProductWarehouse> productWarehouseList = productWarehouseRepository.getProductWarehouseByProductId(productId);
        productWarehouseRepository.deleteAll(productWarehouseList);
        productDAO.delete(productId);
    }

}
