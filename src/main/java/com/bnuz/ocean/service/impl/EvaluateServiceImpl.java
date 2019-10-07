package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.DTO.EvaluateDTO;
import com.bnuz.ocean.VO.AssessStudentVO;
import com.bnuz.ocean.VO.StudentVO;
import com.bnuz.ocean.entity.Evaluate;
import com.bnuz.ocean.entity.id.EvaluateId;
import com.bnuz.ocean.repository.EvaluateRepository;
import com.bnuz.ocean.service.EvaluateService;
import com.bnuz.ocean.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private EvaluateRepository evaluateRepository;

    @Autowired
    private StudentService studentService;

    @Transactional
    @Override
    public void save(EvaluateDTO evaluateDTO) {
        List<Evaluate> evaluateList = ConvertToEvaluateList(evaluateDTO);
        for (Evaluate evaluate :
                evaluateList) {
            evaluateRepository.insert(evaluate);
        }
    }

    @Override
    public List<Evaluate> ConvertToEvaluateList(EvaluateDTO evaluateDTO) {
        String students = evaluateDTO.getStudents();
        List<Evaluate> evaluateList = null;
        evaluateList = new ArrayList<>();
        String[] studentIdList = students.split(",");
        for (String student :
                studentIdList) {
            if(student!=null){
                Evaluate evaluate = new Evaluate();
                evaluate.setAssess(evaluateDTO.getAssess());
                evaluate.setAssessPlus(evaluateDTO.getAssessPlus());
                evaluate.setIntegral(evaluateDTO.getIntegral());
                EvaluateId evaluateId = new EvaluateId();
                evaluateId.setMissionId(evaluateDTO.getTaskId());
                evaluateId.setStudentId(student);
                evaluate.setEvaluateId(evaluateId);
                evaluateList.add(evaluate);
            }
        }
        return evaluateList;
    }

    @Override
    public List<Evaluate> findAllByMissionId(String missionId) {
        return evaluateRepository.findAllByMissionId(missionId);
    }

    @Override
    public List<AssessStudentVO> findAllAssessStudentsByMissionId(String missionId) {
        List<StudentVO> studentVOList = studentService.findAllStudentVOSByMissionId(missionId);
        List<Evaluate> evaluateList = evaluateRepository.findAllByMissionId(missionId);
        List<AssessStudentVO> assessStudentVOList = new ArrayList<>();
        for (Evaluate evaluate :
                evaluateList) {
            for (StudentVO studentVO :
                    studentVOList) {
                if (studentVO.getStudentId().equals(evaluate.getEvaluateId().getStudentId())){
                    AssessStudentVO assessStudentVO = new AssessStudentVO();
                    assessStudentVO.setStudentId(evaluate.getEvaluateId().getStudentId());
                    assessStudentVO.setAssess(evaluate.getAssess());
                    assessStudentVO.setStudentName(studentVO.getStudentName());
                    assessStudentVOList.add(assessStudentVO);
                    break;
                }
            }
        }
        return assessStudentVOList;
    }
}
