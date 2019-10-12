package com.bnuz.ocean.controller;

import com.bnuz.ocean.DTO.MissionDTO;
import com.bnuz.ocean.VO.AssessStudentVO;
import com.bnuz.ocean.VO.ResultVO;
import com.bnuz.ocean.VO.StudentVO;
import com.bnuz.ocean.converter.MissionDTO2Mission;
import com.bnuz.ocean.entity.*;
import com.bnuz.ocean.enums.ResultEnum;
import com.bnuz.ocean.exception.OceanException;
import com.bnuz.ocean.repository.AnswerRepository;
import com.bnuz.ocean.service.*;

import com.bnuz.ocean.utils.ResultVOUtil;
//import com.sun.org.apache.xpath.internal.operations.Mod;
//import com.sun.org.apache.xpath.internal.operations.Mod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/mission")
public class MissionController {
    static Logger logger = LoggerFactory.getLogger(MissionController.class);

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

    @Autowired
    private EvaluateService evaluateService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

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
                         Model model) {
        missionService.deleteByMissionId(missionId);
        missionBookService.deleteByMissionId(missionId);
        missionStudentService.deleteByMissionId(missionId);
        return "common/success";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(value = "missionId") String missionId, Map<String, Object> map) {
        Mission mission = missionService.findAllByMissionId(Integer.valueOf(missionId));
        List<Book> bookList = bookService.findBooksByMissionId(missionId);
        List<StudentVO> allStudentVOSByMissionIdWhenFinishTaskAndNotAssess = studentService.findAllStudentVOSByMissionIdWhenFinishTaskAndNotAssess(missionId);
        List<StudentVO> allStudentVOSByMissionIdWhenNotFinishTask = studentService.findAllStudentVOSByMissionIdWhenNotFinishTask(missionId);
        List<AssessStudentVO> assessStudentVOS = evaluateService.findAllAssessStudentsByMissionId(missionId);
        map.put("missionId", missionId);
        map.put("mission", mission);
        map.put("finishedTaskStudent", allStudentVOSByMissionIdWhenFinishTaskAndNotAssess);
        map.put("notFinishedTaskStudent", allStudentVOSByMissionIdWhenNotFinishTask);
        map.put("isAssessedStudent", assessStudentVOS);
        map.put("bookList", bookList);
        return "mission/detail";
    }

    @GetMapping("/question")
    public String question(@RequestParam(value = "teacherNo", defaultValue = "233") String teacherNo,
                           Integer pageNum, Model model) {

        if (pageNum == null) {
            pageNum = 1;
        }
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");   // 排序方式，这里是以“questionId”为标准进行降序
        Pageable pageable = new PageRequest(pageNum - 1, 4, sort);    // （当前页， 每页记录数， 排序方式）
        Page<Question> questionPage = questionService.findAll(pageable);
        logger.info("Question pageNum: " + pageNum);
        model.addAttribute("questionPage", questionPage);
        model.addAttribute("teacherNo", teacherNo);
        model.addAttribute("pageNum", pageNum);

        return "mission/question";
    }

    @GetMapping("/questioncommonlist")
    @ResponseBody
    public Map<String, Object> questionCommonList(@RequestParam(value = "questionId") Integer questionId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Answer> answerList = answerService.findAllByQuestionId(questionId);
        if (answerList.size() >= 0) {
            modelMap.put("questioncommonlist", answerList);
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;
    }

    @GetMapping("/addcomment")
    @ResponseBody
    public Map<String, Object> addComment(@RequestParam(value = "questionId") Integer questionId,
                                          @RequestParam(value = "answerAns") String answerAns,
                                          @RequestParam(value = "teacherId", defaultValue = "1") Integer teacherId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Date date = new Date();
        int effectedNum = answerService.insertAnswer(questionId, answerAns, date, teacherId);
        if(effectedNum == 1){
            modelMap.put("success", true);
        }else {
            modelMap.put("success", false);
        }

        return modelMap;
    }

}
