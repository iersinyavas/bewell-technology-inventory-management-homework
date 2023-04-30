package com.bewell.inventory.dao;

import com.bewell.inventory.dto.CategoryDTO;
import com.bewell.inventory.mapper.CategoryMapper;
import com.bewell.inventory.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryDAO {

    private final CategoryRepository categoryRepository;

    private CategoryDTO getCategory(Long categoryId){
        return CategoryMapper.INSTANCE.entityToDTO(categoryRepository.findById(categoryId).get());
    }
}
