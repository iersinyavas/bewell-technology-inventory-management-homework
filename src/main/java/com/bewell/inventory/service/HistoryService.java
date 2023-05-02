package com.bewell.inventory.service;

import com.bewell.inventory.dao.HistoryDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryDAO historyDAO;


}
