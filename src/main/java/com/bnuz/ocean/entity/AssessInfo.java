package com.bnuz.ocean.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_assess_info")
public class AssessInfo {

    @Id
    @Column(name = "id")
    @JsonIgnore
    private Integer assessInfoId;

    @Column(name = "assess_desc")
    private String id;

    @Column(name = "assess_value")
    private Integer name;

    @Column(name = "assess_type")
    private String type;
}
