package com.bewell.inventory.mapper;

import com.bewell.inventory.dto.ProductWarehouseDTO;
import com.bewell.inventory.entity.ProductWarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductWarehouseMapper {
    ProductWarehouseMapper INSTANCE = Mappers.getMapper(ProductWarehouseMapper.class);

    @Mapping(target = "productId", source = "product.productId")
    @Mapping(target = "warehouseId", source = "warehouse.warehouseId")
    ProductWarehouseDTO entityToDTO(ProductWarehouse productWarehouse);

    /*@Mapping(target = "category.categoryId", source = "categoryId")
    @Mapping(target = "warehouse.warehouseId", source = "warehouseId")
    Product dtoToTargetEntity(ProductDTO productDTO, @MappingTarget Product product);*/

    @Mapping(target = "product.productId", source = "productId")
    @Mapping(target = "warehouse.warehouseId", source = "warehouseId")
    ProductWarehouse dtoToEntity(ProductWarehouseDTO productWarehouseDTO);

}
