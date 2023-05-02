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

    HistoryDTO entityToDTO(History history);
    History dtoToEntity(HistoryDTO historyDTO);
}
