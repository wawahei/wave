package com.nanyuan.wave.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nanyuan.wave.core.pojo.entity.DictType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 字典类型表 GROUP_ID为0的数据为初始化数据 服务类
 * </p>
 *
 * @author yanghailang
 * @since 2021-05-25
 */
public interface DictTypeService extends IService<DictType> {

    IPage<DictType> list(Page<DictType> pageParam, String keyword);
}
