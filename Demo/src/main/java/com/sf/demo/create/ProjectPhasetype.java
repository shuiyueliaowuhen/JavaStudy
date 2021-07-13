package com.smartarch.project.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel("项目类型和各个阶段的字典表")
@Table(name = "prj_phasetype")
public class ProjectPhasetype {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty("主键")
    private String id;

    /**
     * 项目类型名称
     */
    @ApiModelProperty("项目类型名称：景观、园林/路、桥、隧/水厂、管网/建筑/水环境/燃气、热力/规划")
    private String name;

    /**
     * 项目类型编码
     */
    @ApiModelProperty("项目类型编码：lanscape、road_bridge_tunnel、warter_works、architecture、water_environment、power、plan")
    private String type;

    /**
     * 项目阶段描述，如：[{"step":1,"code":"design","name":"初步设计","percent":"40%"},{"step":2,"code":"production_drawin","name":"施工图","percent":"50%"},{"step":3,"code":"service","name":"服务","percent":"10%"}]
     */
    @Column(name = "project_phase")
    @ApiModelProperty("项目阶段描述，如：[{'step':1,'code':'design','name':'初步设计','percent':'40%'},{'step':2,'code':'production_drawin','name':'施工图','percent':'50%'},{'step':3,'code':'service','name':'服务','percent':'10%'}]")
    private String projectPhase;

    public static final String ID = "id";

    public static final String DB_ID = "id";

    public static final String NAME = "name";

    public static final String DB_NAME = "name";

    public static final String CODE = "code";

    public static final String DB_CODE = "code";

    public static final String PROJECT_PHASE = "projectPhase";

    public static final String DB_PROJECT_PHASE = "project_phase";
}