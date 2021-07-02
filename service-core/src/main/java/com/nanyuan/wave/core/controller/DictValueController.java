package com.nanyuan.wave.core.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nanyuan.wave.core.enums.DeleteStateEnum;
import com.nanyuan.wave.core.pojo.entity.DictValue;
import com.nanyuan.wave.core.result.R;
import com.nanyuan.wave.core.service.DictValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 字典值表 GROUP_ID为0的数据为初始化数据 前端控制器
 * </p>
 *
 * @author yanghailang
 * @since 2021-05-25
 */
@Api(tags = "字典值管理")
@RestController
@RequestMapping("/api/dictValue")
@Slf4j
public class DictValueController {

    @Autowired
    private DictValueService dictValueService;

    @ApiOperation("查询字典值列表")
    @GetMapping("/list/{page}/{limit}")
    public R listByParentId(
            @ApiParam(value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(value = "字典类型编码")
            @RequestParam String typeCode
    ){
        Page<DictValue> pageParam = new Page<>(page, limit);
        IPage<DictValue> pageModel = dictValueService.list(pageParam,typeCode);
        return R.ok().data("pageModel", pageModel);
    }

    @ApiOperation("保存字典值")
    @PostMapping("/save")
    public R save(
            @ApiParam(value = "新增字典值",required = true)
            @RequestBody DictValue dictValue){
        dictValue.setIsDeleted(DeleteStateEnum.NORMAL.getStatus());
        boolean result = dictValueService.save(dictValue);
        if(result){
            return R.ok().message("保存成功");
        }else {
            return R.ok().message("保存失败");
        }
    }

}
