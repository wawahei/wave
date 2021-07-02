package com.nanyuan.wave.core.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author yanghailang
 * @since 2021-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象", description="用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID 序列")
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "工号 员工工号")
    @TableField("USER_NO")
    private String userNo;

    @ApiModelProperty(value = "用户姓名")
    @TableField("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "用户手机号 用户手机号")
    @TableField("USER_MOBILE")
    private String userMobile;

    @ApiModelProperty(value = "用户性别 用户性别")
    @TableField("USER_GENDER")
    private Integer userGender;

    @ApiModelProperty(value = "用户邮箱 用户邮箱")
    @TableField("USER_EMAIL")
    private String userEmail;

    @ApiModelProperty(value = "用户生日 用户生日")
    @TableField("USER_BIRTHDAY")
    private String userBirthday;

    @ApiModelProperty(value = "用户地址 用户地址")
    @TableField("USER_ADDR")
    private String userAddr;

    @ApiModelProperty(value = "用户描述 用户描述")
    @TableField("USER_DESC")
    private String userDesc;

    @ApiModelProperty(value = "登录账号 登录账号")
    @TableField("USER_LOGIN_ACCOUNT")
    private String userLoginAccount;

    @ApiModelProperty(value = "登录密码 登录密码")
    @TableField("USER_LOGIN_PWD")
    private String userLoginPwd;

    @ApiModelProperty(value = "用户状态 用户状态:0 正常  1 删除  2：冻结")
    @TableField("IS_DELETED")
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间 创建时间")
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "最后更新时间 最后更新时间")
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;


}
