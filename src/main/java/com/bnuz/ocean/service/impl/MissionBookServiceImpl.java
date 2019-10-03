package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.repository.MissionBookRepository;
import com.bnuz.ocean.service.MissionBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MissionBookServiceImpl implements MissionBookService {
    @Autowired
    private MissionBookRepository missionBookRepository;

    @Override
    @Transactional
    public void insert(Integer missionId, Integer bookId) {
        missionBookRepository.insert(missionId,bookId);
    }
}
