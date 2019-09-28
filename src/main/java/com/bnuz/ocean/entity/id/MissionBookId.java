package com.bnuz.ocean.entity.id;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class MissionBookId implements Serializable {

    private static final long serialVersionUID = 386769174267239083L;

    private Integer missionId;

    private Integer bookId;
}
