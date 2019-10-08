package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.MissionBook;
import com.bnuz.ocean.entity.id.MissionBookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("ALL")
public interface MissionBookRepository extends JpaRepository<MissionBook, MissionBookId> {

    @Modifying
    @Query(nativeQuery = true, value = "insert into r_mission_book(mission_id, book_id) values (?1,?2)")
    void insert(Integer missionId, Integer bookId);

    @Query(nativeQuery = true, value = "select * from r_mission_book where mission_id = ?1")
    List<MissionBook> findAll(Integer missionId);

    @Modifying
    @Query(nativeQuery = true, value = "delete from r_mission_book where mission_id = ?1")
    void deleteByMissionId(Integer missionId);

    @Query(nativeQuery = true, value = "select book_id from r_mission_book where mission_id = ?1")
    List<Integer> findAllBookIdByMissionId(Integer missionId);
}
