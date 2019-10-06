package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.MissionBook;
import com.bnuz.ocean.repository.MissionBookRepository;
import com.bnuz.ocean.service.MissionBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MissionBookServiceImpl implements MissionBookService {
    @Autowired
    private MissionBookRepository missionBookRepository;

    @Override
    @Transactional
    public void insert(Integer missionId, Integer bookId) {
        missionBookRepository.insert(missionId,bookId);
    }

    @Override
    @Transactional
    public void save(MissionBook missionBook) {
        missionBookRepository.save(missionBook);
    }

    @Override
    public List<MissionBook> findAll(Integer missionId) {
        return missionBookRepository.findAll(missionId);
    }

    @Override
    @Transactional
    public void deleteByMissionId(Integer missionId) {
        missionBookRepository.deleteByMissionId(missionId);
    }

    @Override
    public List<Integer> findAllBookIdByMissionId(Integer missionId) {
        return missionBookRepository.findAllBookIdByMissionId(missionId);
    }
}
