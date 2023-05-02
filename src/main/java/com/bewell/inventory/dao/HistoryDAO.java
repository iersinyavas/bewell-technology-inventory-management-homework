package com.bewell.inventory.dao;

import com.bewell.inventory.dto.HistoryDTO;
import com.bewell.inventory.dto.ProductWarehouseDTO;
import com.bewell.inventory.entity.History;
import com.bewell.inventory.mapper.HistoryMapper;
import com.bewell.inventory.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class HistoryDAO {

    private final HistoryRepository historyRepository;

    public HistoryDTO addHistory(String operationStatusCode, ProductWarehouseDTO productWarehouseDTO) {
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setOperationStatusCode(operationStatusCode);
        historyDTO.setTransactionDate(LocalDateTime.now());
        historyDTO.setProductWarehouseId(productWarehouseDTO.getProductWarehouseId());
        historyDTO.setTransactionQuantity(productWarehouseDTO.getQuantity());
        History history = HistoryMapper.INSTANCE.dtoToEntity(historyDTO);
        return HistoryMapper.INSTANCE.entityToDTO(historyRepository.save(history));
    }

}
