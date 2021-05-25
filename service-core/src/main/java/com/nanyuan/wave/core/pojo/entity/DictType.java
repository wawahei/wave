package com.nanyuan.wave.core.pojo.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 字典类型表 GROUP_ID为0的数据为初始化数据
 * </p>
 *
 * @author yanghailang
 * @since 2021-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="DictType对象", description="字典类型表 GROUP_ID为0的数据为初始化数据")
public class DictType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典类型ID 字典类型ID")
    @TableId(value = "TYPE_ID", type = IdType.AUTO)
    private BigDecimal typeId;

    @ApiModelProperty(value = "字典类型编码 字典类型编码")
    @TableField("TYPE_CODE")
    private String typeCode;

    @ApiModelProperty(value = "字典类型名称 字典类型名称")
    @TableField("TYPE_NAME")
    private String typeName;

    @ApiModelProperty(value = "创建时间 创建时间")
    @TableField(value = "CREATE_TIME",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "最后更新时间 最后更新时间")
    @TableField(value = "UPDATE_TIME",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "状态 状态 0:正常  1: 删除")
    @TableField("IS_DELETED")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "集团ID 集团ID")
    @TableField("GROUP_ID")
    private BigDecimal groupId;


}
