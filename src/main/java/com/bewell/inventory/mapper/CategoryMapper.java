package com.bewell.inventory.mapper;

import com.bewell.inventory.dto.CategoryDTO;
import com.bewell.inventory.dto.HistoryDTO;
import com.bewell.inventory.entity.Category;
import com.bewell.inventory.entity.History;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO entityToDTO(Category category);
    Category dtoToEntity(CategoryDTO categoryDTO);
    List<CategoryDTO> entityListToDTOList(List<Category> categoryList);
}
