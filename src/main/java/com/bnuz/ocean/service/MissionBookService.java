package com.bnuz.ocean.service;

import com.bnuz.ocean.entity.MissionBook;

import java.util.List;

public interface MissionBookService {
    void insert(Integer missionId, Integer bookId);

    void save(MissionBook missionBook);

    List<MissionBook> findAll(Integer missionId);

    void deleteByMissionId(Integer missionId);

}
