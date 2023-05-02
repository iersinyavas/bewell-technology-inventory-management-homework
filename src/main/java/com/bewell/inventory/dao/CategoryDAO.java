package com.bewell.inventory.dao;

import com.bewell.inventory.dto.CategoryDTO;
import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.entity.Category;
import com.bewell.inventory.entity.Product;
import com.bewell.inventory.mapper.CategoryMapper;
import com.bewell.inventory.mapper.ProductMapper;
import com.bewell.inventory.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryDAO {

    private final CategoryRepository categoryRepository;

    public CategoryDTO getCategory(Long categoryId){
        return CategoryMapper.INSTANCE.entityToDTO(categoryRepository.findById(categoryId).get());
    }

    public CategoryDTO getCategory(String categoryName){
        return CategoryMapper.INSTANCE.entityToDTO(categoryRepository.findByName(categoryName));
    }

    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.INSTANCE.dtoToEntity(categoryDTO);
        return CategoryMapper.INSTANCE.entityToDTO(categoryRepository.save(category));
    }

    public List<CategoryDTO> getCategoryList() {
        return CategoryMapper.INSTANCE.entityListToDTOList(categoryRepository.findAll());
    }
}
