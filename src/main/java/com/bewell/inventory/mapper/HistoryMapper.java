package com.bewell.inventory.mapper;

import com.bewell.inventory.dto.HistoryDTO;
import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.entity.History;
import com.bewell.inventory.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HistoryMapper {
    HistoryMapper INSTANCE = Mappers.getMapper(HistoryMapper.class);

    @Mapping(target = "productId", source = "product.productId")
    HistoryDTO entityToDTO(History history);

    @Mapping(target = "product.productId", source = "productId")
    History dtoToEntity(HistoryDTO historyDTO);
}
