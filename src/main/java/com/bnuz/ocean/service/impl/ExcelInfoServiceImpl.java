package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.VO.StudentVO;
import com.bnuz.ocean.entity.ExcelInfo;
import com.bnuz.ocean.entity.Mission;
import com.bnuz.ocean.entity.MissionStudent;
import com.bnuz.ocean.service.ExcelInfoService;
import com.bnuz.ocean.service.MissionService;
import com.bnuz.ocean.service.MissionStudentService;
import com.bnuz.ocean.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelInfoServiceImpl implements ExcelInfoService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MissionService missionService;

    @Autowired
    private MissionStudentService missionStudentService;

    @Override
    public List<ExcelInfo> getExcelInfo(String missionId) {
        List<StudentVO> studentVOList = studentService.findAllStudentVOSByMissionId(missionId);
        Mission mission = missionService.findAllByMissionId(Integer.valueOf(missionId));
        List<MissionStudent> missionStudentList = missionStudentService.findAll(Integer.valueOf(missionId));
        List<ExcelInfo> excelInfoList = new ArrayList<>();
        for (StudentVO studentVO :
                studentVOList) {
            for (MissionStudent missionStudent :
                    missionStudentList) {
                if (studentVO.getStudentId().equals(missionStudent.getMissionStudentId().getStudentId().toString())){
                    ExcelInfo excelInfo = new ExcelInfo();
                    excelInfo.setStudentName(studentVO.getStudentName());
                    excelInfo.setMissionName(mission.getMissionTitle());
                    excelInfo.setBeginTime(mission.getBeginTime());
                    excelInfo.setEndTime(mission.getEndTime());
                    excelInfo.setMissionDesc(mission.getMissionDesc());
                    if (missionStudent.getComplete()==1){
                        excelInfo.setIsCompleted("是");
                    }
                    else {
                        excelInfo.setIsCompleted("否");
                    }
                    excelInfoList.add(excelInfo);
                    break;
                }
            }
        }
        return excelInfoList;
    }
}
