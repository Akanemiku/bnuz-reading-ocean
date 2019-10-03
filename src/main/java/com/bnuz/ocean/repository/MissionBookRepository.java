package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.MissionBook;
import com.bnuz.ocean.entity.id.MissionBookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MissionBookRepository extends JpaRepository<MissionBook, MissionBookId> {

    @Modifying
    @Query(nativeQuery = true, value = "insert into r_mission_book(mission_id, book_id) values (?1,?2)")
    void insert(Integer missionId, Integer bookId);
}
