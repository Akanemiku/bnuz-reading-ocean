package com.bnuz.ocean.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EvaluateDTO {

    private String taskId;

    private String assessPlus;

    private Integer integral;

    private String assess;

    private String students;
}
