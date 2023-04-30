package com.bewell.inventory.dao;

import com.bewell.inventory.dto.HistoryDTO;
import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.entity.History;
import com.bewell.inventory.entity.Product;
import com.bewell.inventory.mapper.HistoryMapper;
import com.bewell.inventory.mapper.ProductMapper;
import com.bewell.inventory.repository.HistoryRepository;
import com.bewell.inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class HistoryDAO {

    private final HistoryRepository historyRepository;

    public HistoryDTO addHistory(HistoryDTO historyDTO) {
        History history = HistoryMapper.INSTANCE.dtoToEntity(historyDTO);
        return HistoryMapper.INSTANCE.entityToDTO(historyRepository.save(history));
    }

}
