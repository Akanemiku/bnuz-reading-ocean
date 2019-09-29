package com.bnuz.ocean.VO;

import lombok.Data;

import java.util.Date;

@Data
public class MissionVO {
    private String missionTitle;

    private String missionDesc;

    private Date beginTime;

    private Date endTime;
}
