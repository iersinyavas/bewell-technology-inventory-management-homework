package com.bewell.inventory.dao;

import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.dto.ProductWarehouseDTO;
import com.bewell.inventory.entity.Product;
import com.bewell.inventory.entity.ProductWarehouse;
import com.bewell.inventory.entity.Warehouse;
import com.bewell.inventory.mapper.ProductMapper;
import com.bewell.inventory.mapper.ProductWarehouseMapper;
import com.bewell.inventory.notification.email.EmailDetail;
import com.bewell.inventory.notification.email.EmailService;
import com.bewell.inventory.repository.ProductRepository;
import com.bewell.inventory.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductWarehouseDAO {

    private final EmailService emailService;
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;

    @Value("${spring.mail.username}")
    private String sender;

    public ProductDTO getProduct(Long productId){
        return ProductMapper.INSTANCE.entityToDTO(productRepository.findById(productId).get());
    }

    public ProductDTO getProduct(String productName){
        return ProductMapper.INSTANCE.entityToDTO(productRepository.findByName(productName));
    }

    public ProductWarehouseDTO addProduct(ProductWarehouseDTO productWarehouseDTO) {
        Product product = productRepository.findById(productWarehouseDTO.getProductId()).get();
        Warehouse warehouse = warehouseRepository.findById(productWarehouseDTO.getWarehouseId()).get();

        ProductWarehouse productWarehouse = ProductWarehouseMapper.INSTANCE.dtoToEntity(productWarehouseDTO);
        productWarehouse.setProduct(product);
        productWarehouse.setWarehouse(warehouse);

        return ProductWarehouseMapper.INSTANCE.entityToDTO(productRepository.save(productWarehouse));
    }

    public ProductDTO addQuantity(ProductDTO productDTO){
        Product product = null;
        if (Objects.nonNull(productDTO.getProductId())){
            product = productRepository.findById(productDTO.getProductId()).get();
        }

        if (Objects.nonNull(product)){
            product.setQuantity(product.getQuantity().add(productDTO.getQuantity()));
            return ProductMapper.INSTANCE.entityToDTO(productRepository.save(product));
        }
        return null;
    }

    public ProductDTO subtractQuantity(ProductWarehouseDTO productWarehouseDTO){
        Product product = productRepository.findById(productWarehouseDTO.getProductId()).get();
        Warehouse warehouse = warehouseRepository.findById(productWarehouseDTO.getWarehouseId()).get();

        if (Objects.nonNull(product)){
            if (product.getQuantity().compareTo(productDTO.getQuantity()) > 0){
                product.setQuantity(product.getQuantity().subtract(productDTO.getQuantity()));
                String messageBody = "Depodaki " + product.getName() + " miktarı " + product.getQuantity().intValue() + " adettir. Ürün kritik seviyenin altına düştü.";
                if (product.getQuantity().compareTo(product.getCriticalQuantity()) < 0){
                    log.info(messageBody);
                    EmailDetail emailDetail = new EmailDetail();
                    emailDetail.setMsgBody(messageBody);
                    emailDetail.setRecipient(sender);
                    emailDetail.setSubject("Ürün Miktarı");
                    emailService.sendSimpleMail(emailDetail);
                }
                return ProductMapper.INSTANCE.entityToDTO(productRepository.save(product));
            }

        }
        return null;
    }
}
