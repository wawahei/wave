package com.nanyuan.wave.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nanyuan.wave.core.pojo.entity.DictValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 字典值表 GROUP_ID为0的数据为初始化数据 服务类
 * </p>
 *
 * @author yanghailang
 * @since 2021-05-25
 */
public interface DictValueService extends IService<DictValue> {

    IPage<DictValue> list(Page<DictValue> pageParam, String typeCode);

    boolean saveList(List<DictValue> list);
}
