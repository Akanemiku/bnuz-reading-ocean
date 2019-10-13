package com.bnuz.ocean.utils;

import com.bnuz.ocean.VO.StudentVO;
import com.bnuz.ocean.entity.Homework;
import com.bnuz.ocean.entity.Student;
import com.bnuz.ocean.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ConverterUtil {

    public static List<StudentVO> convertStudentToStudentVO(List<Student> studentList){
        List<StudentVO> studentVOList = null;
        studentVOList = new ArrayList<>();
        for (Student student :
                studentList) {
            StudentVO studentVO = new StudentVO();
            int index = student.getStudentInfo().indexOf("班");
            int length = student.getStudentInfo().length();
            studentVO.setStudentName(student.getStudentInfo().substring(index+1,length));
            studentVO.setStudentId(student.getStudentId().toString());
            studentVOList.add(studentVO);
        }
        return studentVOList;
    }

    public static String convertStudentInfoToStudentName(String studentInfo){
        int index = studentInfo.indexOf("班");
        return studentInfo.substring(index+1);
    }
}
