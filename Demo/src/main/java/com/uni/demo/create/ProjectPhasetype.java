package com.uni.demo.create;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class ProjectPhasetype {

    private String id;

    private String name;

    private String type;

    private String projectPhase;

    private List<ProjectPhaseDto> list = new ArrayList<>();

}