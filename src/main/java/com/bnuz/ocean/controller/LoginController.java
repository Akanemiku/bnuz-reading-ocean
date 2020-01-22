package com.bnuz.ocean.controller;

import com.bnuz.ocean.entity.Mission;
import com.bnuz.ocean.entity.Teacher;
import com.bnuz.ocean.repository.TeacherRepository;
import com.bnuz.ocean.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;

@Controller
public class LoginController {
    @Autowired
    private TeacherRepository repository;

    @Autowired
    private MissionService missionService;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/dologin")
    public String login(@RequestParam("username") String username, Model model,@PageableDefault(size = 5) Pageable pageable){
        Teacher teacher = repository.findAllByTeacherName(username);

        Page<Mission> missionPage = missionService.findList(teacher.getTeacherNo(), pageable);
        model.addAttribute("missionPage", missionPage);
        model.addAttribute("teacherNo", teacher.getTeacherNo());
        model.addAttribute("current", pageable.getPageNumber());
        model.addAttribute("size", pageable.getPageSize());
        return "mission/list";
    }

    @GetMapping("/signout")
    public String signout(){
        return "login";
    }
}
