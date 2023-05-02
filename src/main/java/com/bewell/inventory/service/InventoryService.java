package com.bewell.inventory.service;

import com.bewell.inventory.dao.HistoryDAO;
import com.bewell.inventory.dao.ProductDAO;
import com.bewell.inventory.dao.InventoryDAO;
import com.bewell.inventory.dao.WarehouseDAO;
import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.dto.ProductWarehouseDTO;
import com.bewell.inventory.dto.WarehouseDTO;
import com.bewell.inventory.entity.Product;
import com.bewell.inventory.enumeration.OperationStatusCode;
import com.bewell.inventory.mapper.ProductMapper;
import com.bewell.inventory.mapper.ProductWarehouseMapper;
import com.bewell.inventory.notification.email.EmailDetail;
import com.bewell.inventory.notification.email.EmailService;
import com.bewell.inventory.request.InventoryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryDAO inventoryDAO;
    private final ProductDAO productDAO;
    private final WarehouseDAO warehouseDAO;
    private final HistoryDAO historyDAO;
    private final EmailService emailService;

    @Value("${spring.mail.username}")
    private String sender;

    public ProductWarehouseDTO addProductWarehouse(InventoryRequest inventoryRequest) {
        ProductWarehouseDTO productWarehouseDTO = inventoryRequest.getProductWarehouseDTO();
        ProductWarehouseDTO productWarehouseCheck = this.controlProductWarehouseDTO(productWarehouseDTO);
        if (Objects.nonNull(productWarehouseCheck)){
            inventoryRequest.setTransactionQuantity(productWarehouseDTO.getQuantity());
            inventoryRequest.setProductWarehouseDTO(productWarehouseCheck);
            this.addQuantity(inventoryRequest);
            return productWarehouseDTO;
        }
        productWarehouseDTO = inventoryDAO.addProductWarehouse(productWarehouseDTO);
        historyDAO.addHistory(OperationStatusCode.NEW_ADD_PRODUCT.getValue(), productWarehouseDTO);
        return productWarehouseDTO;
    }

    public ProductWarehouseDTO updateInventory(ProductWarehouseDTO productWarehouseDTO) {
        return inventoryDAO.updateProductWarehouse(productWarehouseDTO);
    }

    public void deleteProduct(Long productId) {
        productDAO.delete(productId);
    }

    public List<WarehouseDTO> productWhichWarehouse(String productName){
        return warehouseDAO.productWhichWarehouse(productName);
    }

    public ProductWarehouseDTO addQuantityProduct(InventoryRequest inventoryRequest){
        ProductWarehouseDTO productWarehouseCheck = this.controlProductWarehouseDTO(inventoryRequest.getProductWarehouseDTO());
        inventoryRequest.setProductWarehouseDTO(productWarehouseCheck);
        return this.addQuantity(inventoryRequest);
    }

    public ProductWarehouseDTO addQuantity(InventoryRequest inventoryRequest){
        ProductWarehouseDTO productWarehouseDTO = inventoryRequest.getProductWarehouseDTO();
        productWarehouseDTO.setQuantity(productWarehouseDTO.getQuantity().add(inventoryRequest.getTransactionQuantity()));
        productWarehouseDTO = this.updateInventory(productWarehouseDTO);
        productWarehouseDTO.setQuantity(inventoryRequest.getTransactionQuantity());
        historyDAO.addHistory(OperationStatusCode.ADD_PRODUCT.getValue(), productWarehouseDTO);
        return productWarehouseDTO;
    }

    public ProductWarehouseDTO controlProductWarehouseDTO(ProductWarehouseDTO productWarehouseDTO){
        return inventoryDAO.getProductWarehouseByProductNameAndWarehouseId(productWarehouseDTO);
    }

    public ProductWarehouseDTO subtractQuantity(InventoryRequest inventoryRequest){
        ProductWarehouseDTO productWarehouseDTO = inventoryRequest.getProductWarehouseDTO();
        productWarehouseDTO = this.controlProductWarehouseDTO(productWarehouseDTO);
        WarehouseDTO warehouseDTO = warehouseDAO.getWarehouse(productWarehouseDTO.getWarehouseId());

        if (Objects.nonNull(productWarehouseDTO)){
            productWarehouseDTO.setQuantity(productWarehouseDTO.getQuantity().subtract(inventoryRequest.getTransactionQuantity()));
            String messageBody = null;
            if (productWarehouseDTO.getQuantity().compareTo(BigDecimal.ZERO) <= 0){
                productWarehouseDTO.setQuantity(BigDecimal.ZERO);
                messageBody =  warehouseDTO.getCity() + " şehrindeki " + warehouseDTO.getName() + "nda " + productWarehouseDTO.getProductName() + " ürünü tükeniştir";
                log.info(messageBody);
                EmailDetail emailDetail = new EmailDetail();
                emailDetail.setMsgBody(messageBody);
                emailDetail.setRecipient(sender);
                emailDetail.setSubject("Ürün Miktarı");
                emailService.sendEmail(emailDetail);
                productWarehouseDTO = this.updateInventory(productWarehouseDTO);
                historyDAO.addHistory(OperationStatusCode.DELETE_PRODUCT.getValue(), productWarehouseDTO);
                return productWarehouseDTO;
            }
            if (productWarehouseDTO.getQuantity().compareTo(productWarehouseDTO.getCriticalQuantity()) <= 0){
                messageBody =  warehouseDTO.getCity() + " şehrindeki " + warehouseDTO.getName() + "nda " + productWarehouseDTO.getProductName() + " miktarı " + productWarehouseDTO.getQuantity().intValue() + " adettir. Ürün kritik seviyenin altına düştü.";

                log.info(messageBody);
                EmailDetail emailDetail = new EmailDetail();
                emailDetail.setMsgBody(messageBody);
                emailDetail.setRecipient(sender);
                emailDetail.setSubject("Ürün Miktarı");
                emailService.sendEmail(emailDetail);
            }
            productWarehouseDTO = this.updateInventory(productWarehouseDTO);
            productWarehouseDTO.setQuantity(inventoryRequest.getTransactionQuantity());
            historyDAO.addHistory(OperationStatusCode.REMOVE_PRODUCT.getValue(), productWarehouseDTO);
            return productWarehouseDTO;
        }
        return null;
    }

}
