package com.bewell.inventory.dao;

import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.entity.Product;
import com.bewell.inventory.mapper.ProductMapper;
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

    private final EmailService emailService;
    private final ProductRepository productRepository;
    @Value("${spring.mail.username}")
    private String sender;

    public ProductDTO getProduct(Long productId){
        return ProductMapper.INSTANCE.entityToDTO(productRepository.findById(productId).get());
    }

    public ProductDTO getProduct(String productName){
        return ProductMapper.INSTANCE.entityToDTO(productRepository.findByName(productName));
    }

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = null;
        if (Objects.nonNull(productDTO.getProductId())){
            product = productRepository.findById(productDTO.getProductId()).get();
        }
        if (productDTO.equals(product)){
            return this.addQuantity(productDTO);
        }
        product = ProductMapper.INSTANCE.dtoToEntity(productDTO);
        return ProductMapper.INSTANCE.entityToDTO(productRepository.save(product));
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

    public ProductDTO subtractQuantity(ProductDTO productDTO){
        Product product = null;
        if (Objects.nonNull(productDTO.getProductId())){
            product = productRepository.findById(productDTO.getProductId()).get();
        }
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
