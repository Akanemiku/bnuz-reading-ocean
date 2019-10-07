package com.bnuz.ocean.service;

import com.bnuz.ocean.DTO.EvaluateDTO;
import com.bnuz.ocean.VO.AssessStudentVO;
import com.bnuz.ocean.entity.Evaluate;

import java.util.List;

public interface EvaluateService {

    /**
     * 保存评价信息
     * @param evaluateDTO
     * @return
     */
    public void save(EvaluateDTO evaluateDTO);

    /**
     * 将EvaluateDTO转换成evaluateList
     * @param evaluateDTO
     * @return
     */
    public List<Evaluate> ConvertToEvaluateList(EvaluateDTO evaluateDTO);

    /**
     * 通过missionId找到Evaluate
     * @param missionId
     * @return
     */
    public List<Evaluate> findAllByMissionId(String missionId);

    /**
     * 通过missionId找到AssessStudentVO
     * @param missionId
     * @return
     */
    public List<AssessStudentVO> findAllAssessStudentsByMissionId(String missionId);
}
