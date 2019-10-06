package com.bnuz.ocean.controller;

import com.bnuz.ocean.DTO.MissionDTO;
import com.bnuz.ocean.VO.ResultVO;
import com.bnuz.ocean.converter.MissionDTO2Mission;
import com.bnuz.ocean.entity.*;
import com.bnuz.ocean.enums.ResultEnum;
import com.bnuz.ocean.exception.OceanException;
import com.bnuz.ocean.service.*;
import com.bnuz.ocean.utils.ResultVOUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mission")
public class MissionController {

    @Autowired
    private MissionService missionService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private BookService bookService;
    @Autowired
    private MissionStudentService missionStudentService;
    @Autowired
    private MissionBookService missionBookService;

    @GetMapping("/list")
    public String list(@RequestParam(value = "teacherNo", defaultValue = "233") String teacherNo,
                       @PageableDefault(size = 5) Pageable pageable, Model model) {

        Page<Mission> missionPage = missionService.findList(teacherNo, pageable);
        model.addAttribute("missionPage", missionPage);
        model.addAttribute("teacherNo", teacherNo);
        model.addAttribute("current", pageable.getPageNumber());
        model.addAttribute("size", pageable.getPageSize());
        return "mission/list";
    }

    @GetMapping("/index")
    public String index(@RequestParam(value = "teacherNo", defaultValue = "233") Integer teacherNo,
                        @RequestParam(value = "missionId", required = false) Integer missionId,
                        Model model) {
        List<Student> studentList = studentService.findAll();
        List<Book> bookList = bookService.findAll();

        model.addAttribute("studentList", studentList);
        model.addAttribute("bookList", bookList);
        model.addAttribute("teacherNo", teacherNo);

        if (missionId != null) {
            Mission mission = missionService.findAllByMissionId(missionId);
            model.addAttribute("mission", mission);
        } else {
            model.addAttribute("mission", null);
        }

        return "mission/index";
    }

    @PostMapping("/save")
    public String save(MissionDTO missionDTO, Model model) {
        System.out.println(missionDTO.toString());
        try {
            Mission mission = MissionDTO2Mission.convert(missionDTO);
            List<Integer> students = missionDTO.getStudent();
            List<Integer> books = missionDTO.getBook();

            try {
                missionService.save(mission);
            } catch (OceanException e) {
                model.addAttribute("msg", ResultEnum.MISSION_INSERT_ERROR.getCode());
                return "common/error";
            }
            try {
                List<MissionStudent> missionStudentList = missionStudentService.findAll(mission.getMissionId());
                for (MissionStudent missionStudent : missionStudentList) {
                        missionStudentService.deleteByMissionId(missionStudent.getMissionStudentId().getMissionId());
                }
                for (Integer student : students) {
                    //不能用jpa自带save，会进行持久化导致刚刚删除的同样数据无法再次插入
                    missionStudentService.insert(mission.getMissionId(), student);
                }
//                List<MissionStudent> missionStudentList = missionStudentService.findAll(mission.getMissionId());
//                for(MissionStudent missionStudent : missionStudentList){
//                    if(!students.contains(missionStudent.getMissionStudentId().getStudentId())){
//                        missionStudentService.deleteByMissionId(missionStudent.getMissionStudentId().getMissionId());
//                    }
//                }
            } catch (OceanException e) {
                model.addAttribute("msg", ResultEnum.M_S_INSERT_ERROR.getCode());
                return "common/error";
            }
            try {
                List<MissionBook> missionBookList = missionBookService.findAll(mission.getMissionId());
                for (MissionBook missionBook : missionBookList) {
                    missionBookService.deleteByMissionId(missionBook.getMissionBookId().getMissionId());
                }
                for (Integer book : books) {
                    missionBookService.insert(mission.getMissionId(), book);
                }
            } catch (OceanException e) {
                model.addAttribute("msg", ResultEnum.M_B_INSERT_ERROR.getCode());
                return "common/error";
            }

        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "common/error";
        }
        return "common/success";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "missionId", required = true) Integer missionId,
                         Model model){
        missionService.deleteByMissionId(missionId);
        missionBookService.deleteByMissionId(missionId);
        missionStudentService.deleteByMissionId(missionId);
        return "common/success";
    }

    @GetMapping("/detail")
    public String detail(){
        return "mission/detail";
    }
}
