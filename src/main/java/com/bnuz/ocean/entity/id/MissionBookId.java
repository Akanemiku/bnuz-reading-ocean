package com.bnuz.ocean.entity.id;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class MissionBookId {
    private Integer missionId;
    private Integer bookId;
}
