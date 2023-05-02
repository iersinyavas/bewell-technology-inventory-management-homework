package com.bewell.inventory.service;

import com.bewell.inventory.dao.CategoryDAO;
import com.bewell.inventory.dao.HistoryDAO;
import com.bewell.inventory.dao.ProductDAO;
import com.bewell.inventory.dto.CategoryDTO;
import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.dto.ProductWarehouseDTO;
import com.bewell.inventory.entity.ProductWarehouse;
import com.bewell.inventory.enumeration.OperationStatusCode;
import com.bewell.inventory.repository.ProductWarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryDAO categoryDAO;

    public CategoryDTO getCategory(String categoryName) {
        return categoryDAO.getCategory(categoryName);
    }

    public CategoryDTO getCategory(Long categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        CategoryDTO category = this.getCategory(categoryDTO.getName());
        if (Objects.nonNull(category)){
            return category;
        }
        return categoryDAO.addCategory(categoryDTO);
    }

    public List<CategoryDTO> getCategoryList() {
        return categoryDAO.getCategoryList();
    }
}
