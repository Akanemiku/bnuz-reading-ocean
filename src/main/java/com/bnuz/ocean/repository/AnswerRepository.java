package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {

    List<Answer> findAllByQuestionId(Integer questionId);

    @Modifying
    @Query(nativeQuery = true, value = "insert into t_answer_info(question_id, answer_ans, create_time, teacher_id) VALUES (?1,?2,?3,?4)")
    int insertAnswer(Integer questionId, String answerAns, Date date, Integer teacherId);

}
