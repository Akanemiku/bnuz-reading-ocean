package com.bnuz.ocean.DTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class MissionDTO {
    private String title;
    private String teacherNo;
    private Integer cate;
    private String desc;
    private List<Integer> student;
    private List<Integer> book;
    private String beginTime;
    private String endTime;
}
