package com.smartarch.platform.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Table(name = "tb_user")
public class User {

	@Id
	@Column(name = "id",insertable = false)
	@KeySql(useGeneratedKeys = true)
	private Long id;
	public static final String ID = "id";

	@Column(name = "uuid")
	private String uuid;
	public static final String UUID = "uuid";

	@Column(name = "name")
	private String name;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "create_at")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp createAt;

	@Column(name = "create_by")
	private Long createBy;

	@Column(name = "delete_at")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp deleteAt;

	@Column(name = "delete_by")
	private Long deleteBy;

	@Column(name = "tenant_id")
	private Long tenantId;

	@Column(name = "password")
	private String password;

	@Column(name = "type")
	private String type;

	@Column(name = "header")
	private String header;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "pinyin")
	private String pinyin;

	@Column(name = "status")
	private Integer status;

	@Column(name = "email")
	private String email;

	@Column(name = "level")
	private Integer level;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "start_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp startTime;

	@Column(name = "end_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp endTime;

	private List<Role> roles;

}