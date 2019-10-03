package com.bnuz.ocean.controller;

import com.bnuz.ocean.DTO.MissionDTO;
import com.bnuz.ocean.VO.MissionVO;
import com.bnuz.ocean.VO.ResultVO;
import com.bnuz.ocean.converter.MissionDTO2Mission;
import com.bnuz.ocean.entity.Book;
import com.bnuz.ocean.entity.Mission;
import com.bnuz.ocean.entity.Student;
import com.bnuz.ocean.enums.ResultEnum;
import com.bnuz.ocean.exception.OceanException;
import com.bnuz.ocean.repository.StudentRepository;
import com.bnuz.ocean.service.*;
import com.bnuz.ocean.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    public String list(@RequestParam(value = "teacherNo",defaultValue = "233") String teacherNo,
                         @PageableDefault(size = 2) Pageable pageable, Model model) {

        Page<Mission> missionPage = missionService.findList(teacherNo,pageable);
        model.addAttribute("missionPage",missionPage);
        model.addAttribute("teacherNo",teacherNo);
        model.addAttribute("current",pageable.getPageNumber());
        model.addAttribute("size",pageable.getPageSize());
        return "mission/list";
    }

    @GetMapping("/index")
    public String index(@RequestParam(value = "teacherNo",defaultValue = "233")Integer teacherNo,
                        Model model){
        List<Student> studentList = studentService.findAll();
        List<Book> bookList = bookService.findAll();

        model.addAttribute("studentList",studentList);
        model.addAttribute("bookList",bookList);
        model.addAttribute("teacherNo",teacherNo);

        return "mission/index";
    }

    @PostMapping("/save")
    public String save(MissionDTO missionDTO,Model model){
        System.out.println(missionDTO.toString());
        try {
            Mission mission = MissionDTO2Mission.convert(missionDTO);
            List<Integer> students = missionDTO.getStudent();
            List<Integer> books = missionDTO.getBook();

            try{
                missionService.save(mission);
            }catch (OceanException e){
                model.addAttribute("msg", ResultEnum.MISSION_INSERT_ERROR.getCode());
                return "common/error";
            }
            try{
                for (Integer student : students) {
                    missionStudentService.insert(mission.getMissionId(), student);
                }
            }catch (OceanException e){
                model.addAttribute("msg", ResultEnum.M_S_INSERT_ERROR.getCode());
                return "common/error";
            }
            try{
                for(Integer book : books){
                    missionBookService.insert(mission.getMissionId(),book);
                }
            }catch (OceanException e){
                model.addAttribute("msg", ResultEnum.M_B_INSERT_ERROR.getCode());
                return "common/error";
            }

        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "common/error";
        }
        return "common/success";

    }



}
