package com.holddie.springboot.mybatis.rest.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.holddie.springboot.mybatis.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 * ---------------------------------
 * @author HoldDie
 * @description User 实体类
 * @since 2018-05-21
 */
@TableName("elec_user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
	@ApiModelProperty("用户ID")
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 员工ID
     */
	@ApiModelProperty("员工ID")
	@TableField("staff_id")
	private Long staffId;
    /**
     * 用户类型
     */
	@ApiModelProperty("用户类型")
	private String type;
    /**
     * 登陆账号
     */
	@ApiModelProperty("登陆账号")
	private String account;
    /**
     * 昵称
     */
	@ApiModelProperty("昵称")
	private String nickname;
    /**
     * 登陆密码
     */
	@ApiModelProperty("登陆密码")
	private String password;
    /**
     * 最后登陆时间
     */
	@ApiModelProperty("最后登陆时间")
	@TableField("last_login")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lastLogin;
    /**
     * 创建人
     */
	@ApiModelProperty("创建人")
	@TableField("create_by")
	private String createBy;
    /**
     * 创建时间
     */
	@ApiModelProperty("创建时间")
	@TableField("create_dt")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDt;
    /**
     * 修改人
     */
	@ApiModelProperty("修改人")
	@TableField("update_by")
	private String updateBy;
    /**
     * 修改时间
     */
	@ApiModelProperty("修改时间")
	@TableField("update_dt")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateDt;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}


	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", staffId=" + staffId +
			", type=" + type +
			", account=" + account +
			", nickname=" + nickname +
			", password=" + password +
			", lastLogin=" + lastLogin +
			", createBy=" + createBy +
			", createDt=" + createDt +
			", updateBy=" + updateBy +
			", updateDt=" + updateDt +
			"}";
	}
}
