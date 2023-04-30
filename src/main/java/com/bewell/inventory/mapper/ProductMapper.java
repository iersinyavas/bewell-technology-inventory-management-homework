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
    @Mapping(target = "warehouseId", source = "warehouse.warehouseId")
    ProductDTO entityToDTO(Product product);

    @Mapping(target = "category.categoryId", source = "categoryId")
    @Mapping(target = "warehouse.warehouseId", source = "warehouseId")
    Product dtoToTargetEntity(ProductDTO productDTO, @MappingTarget Product product);

    @Mapping(target = "category.categoryId", source = "categoryId")
    @Mapping(target = "warehouse.warehouseId", source = "warehouseId")
    Product dtoToEntity(ProductDTO productDTO);

}
