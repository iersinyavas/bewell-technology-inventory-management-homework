package com.bewell.inventory.mapper;

import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.dto.WarehouseDTO;
import com.bewell.inventory.entity.Product;
import com.bewell.inventory.entity.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseMapper {
    WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);

    WarehouseDTO entityToDTO(Warehouse warehouse);

    Warehouse dtoToEntity(WarehouseDTO warehouseDTO);
}
