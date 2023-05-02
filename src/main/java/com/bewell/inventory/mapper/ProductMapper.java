package com.bewell.inventory.mapper;

import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.entity.Category;
import com.bewell.inventory.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "categoryId", source = "category.categoryId")
    ProductDTO entityToDTO(Product product);

    @Mapping(target = "category.categoryId", source = "categoryId")
    Product dtoToTargetEntity(ProductDTO productDTO, @MappingTarget Product product);

    @Mapping(target = "category.categoryId", source = "categoryId")
    Product dtoToEntity(ProductDTO productDTO);

}
