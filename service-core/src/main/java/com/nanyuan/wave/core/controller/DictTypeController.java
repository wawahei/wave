package com.nanyuan.wave.core.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nanyuan.wave.core.enums.DeleteStateEnum;
import com.nanyuan.wave.core.exception.Assert;
import com.nanyuan.wave.core.pojo.entity.DictType;
import com.nanyuan.wave.core.result.R;
import com.nanyuan.wave.core.result.ResponseEnum;
import com.nanyuan.wave.core.service.DictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 字典类型表 GROUP_ID为0的数据为初始化数据 前端控制器
 * </p>
 *
 * @author yanghailang
 * @since 2021-05-25
 */
@Api(tags = "数据字典类型管理")
@RestController
@RequestMapping("/api/dictType")
@Slf4j
public class DictTypeController {

    @Autowired
    private DictTypeService dictTypeService;

    @ApiOperation("查询list列表")
    @GetMapping("/list/{page}/{limit}")
    public R listByParentId(
            @ApiParam(value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(value = "查询关键字", required = false)
            @RequestParam String keyword
            ){
        Page<DictType> pageParam = new Page<>(page, limit);
        IPage<DictType> pageModel = dictTypeService.list(pageParam,keyword);
        return R.ok().data("pageModel", pageModel);
    }

    @ApiOperation("保存字典类型")
    @PostMapping("/save")
    public R save(
            @ApiParam(value = "字典类型",required = true)
            @RequestBody DictType dictType){
        dictType.setIsDeleted(DeleteStateEnum.NORMAL.getStatus());
        boolean result = dictTypeService.save(dictType);
        if(result){
            return R.ok().message("保存成功");
        }else {
            return R.ok().message("保存失败");
        }
    }

    @ApiOperation("删除字典类型")
    @DeleteMapping("/delete/{typeId}")
    public R delete(
            @ApiParam(value = "字典类型ID" , required = true)
            @PathVariable Integer typeId
    ){
        Assert.notNull(typeId, ResponseEnum.PARAM_NOT_EMPTY);
        boolean result = dictTypeService.removeById(typeId);
        if(result){
            return R.ok().message("删除成功");
        }else {
            return R.ok().message("删除失败");
        }
    }

    @ApiOperation("更新字典类型")
    @PutMapping("/update")
    public R update(
                @ApiParam(value = "字典类型",required = true)
                @RequestBody DictType dictType){
        boolean result = dictTypeService.updateById(dictType);
        if(result){
            return R.ok().message("更新成功");
        }else {
            return R.ok().message("更新失败");
        }
    }
}
