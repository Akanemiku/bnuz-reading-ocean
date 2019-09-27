package com.bnuz.ocean.entity;

import com.bnuz.ocean.entity.id.MissionBookId;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "r_mission_book")
public class MissionBook {
    @EmbeddedId
    private MissionBookId missionBookId;
}
