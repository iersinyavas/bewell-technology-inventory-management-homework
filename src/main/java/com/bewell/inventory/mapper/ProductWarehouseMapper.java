package com.bewell.inventory.mapper;

import com.bewell.inventory.dto.ProductWarehouseDTO;
import com.bewell.inventory.entity.ProductWarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductWarehouseMapper {
    ProductWarehouseMapper INSTANCE = Mappers.getMapper(ProductWarehouseMapper.class);

    @Mapping(target = "productName", source = "product.name")
    ProductWarehouseDTO entityToDTO(ProductWarehouse productWarehouse);

    @Mapping(target = "product.name", source = "productName")
    ProductWarehouse dtoToEntity(ProductWarehouseDTO productWarehouseDTO);

    @Mapping(target = "product.name", source = "productName")
    ProductWarehouse dtoToTargetEntity(ProductWarehouseDTO productWarehouseDTO, @MappingTarget ProductWarehouse productWarehouse);

}
