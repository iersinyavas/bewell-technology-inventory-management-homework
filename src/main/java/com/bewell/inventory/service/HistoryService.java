package com.bewell.inventory.service;

import com.bewell.inventory.dao.HistoryDAO;
import com.bewell.inventory.dto.HistoryDTO;
import com.bewell.inventory.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryDAO historyDAO;

    public HistoryDTO addHistory(HistoryDTO historyDTO) {
        return historyDAO.addHistory(historyDTO);
    }
}
