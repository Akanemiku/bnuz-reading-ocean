package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.DTO.EvaluateDTO;
import com.bnuz.ocean.entity.Evaluate;
import com.bnuz.ocean.entity.id.EvaluateId;
import com.bnuz.ocean.repository.EvaluateRepository;
import com.bnuz.ocean.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private EvaluateRepository evaluateRepository;

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
                evaluateList = new ArrayList<Evaluate>();
                evaluateList.add(evaluate);
            }
        }
        return evaluateList;
    }
}
