package com.nanyuan.wave.core.pojo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 字典值表 GROUP_ID为0的数据为初始化数据
 * </p>
 *
 * @author yanghailang
 * @since 2021-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="DictValue对象", description="字典值表 GROUP_ID为0的数据为初始化数据")
public class DictValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典值ID 序列")
    @TableId(value = "VALUE_ID", type = IdType.AUTO)
    private BigDecimal valueId;

    @ApiModelProperty(value = "字典类型编码 字典类型编码")
    @TableField("TYPE_CODE")
    private String typeCode;

    @ApiModelProperty(value = "字典值 字典值")
    @TableField("VALUE_CODE")
    private String valueCode;

    @ApiModelProperty(value = "字典值展示名称 字典值展示名称")
    @TableField("VALUE_NAME")
    private String valueName;

    @ApiModelProperty(value = "描述 描述")
    @TableField("VALUE_DESC")
    private String valueDesc;

    @ApiModelProperty(value = "创建时间 创建时间")
    @TableField(value = "CREATE_TIME",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "最后更新时间 最后更新时间")
    @TableField(value = "UPDATE_TIME",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "状态 状态 0:正常  1: 删除")
    @TableField("IS_DELETED")
    private Integer isDeleted;

    @ApiModelProperty(value = "集团ID 集团ID")
    @TableField("GROUP_ID")
    private BigDecimal groupId;


}
