package com.bewell.inventory.service;

import com.bewell.inventory.dao.CategoryDAO;
import com.bewell.inventory.dao.HistoryDAO;
import com.bewell.inventory.dao.ProductDAO;
import com.bewell.inventory.dao.WarehouseDAO;
import com.bewell.inventory.dto.HistoryDTO;
import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.dto.WarehouseDTO;
import com.bewell.inventory.entity.Product;
import com.bewell.inventory.repository.HistoryRepository;
import com.bewell.inventory.request.InventoryTransactionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryService {

    private final HistoryDAO historyDAO;
    private final ProductDAO productDAO;
    private final WarehouseDAO warehouseDAO;
    private final CategoryDAO categoryDAO;

    public HistoryDTO inventoryTransaction(InventoryTransactionRequest request){

        ProductDTO productDTO = productDAO.addProduct(request.getProductDTO());
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setProductId(productDTO.getProductId());

        historyDTO.setTransactionDate(LocalDateTime.now());
        historyDTO.setOperationStatusCode(request.getOperationStatusCode());
        return historyDAO.addHistory(historyDTO);
    }

    public Product saveProduct(InventoryTransactionRequest inventoryTransactionRequest){
        Product product = new Product();
       return product;
    }

    public List<WarehouseDTO> productWhichWarehouse(String productName){
        ProductDTO productDTO = productDAO.getProduct(productName);
        //warehouseDAO.getWarehouse()
        return null;
    }
}
