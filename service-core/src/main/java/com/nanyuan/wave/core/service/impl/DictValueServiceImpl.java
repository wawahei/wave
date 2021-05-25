package com.nanyuan.wave.core.service.impl;

import com.nanyuan.wave.core.pojo.entity.DictValue;
import com.nanyuan.wave.core.mapper.DictValueMapper;
import com.nanyuan.wave.core.service.DictValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典值表 GROUP_ID为0的数据为初始化数据 服务实现类
 * </p>
 *
 * @author yanghailang
 * @since 2021-05-25
 */
@Service
public class DictValueServiceImpl extends ServiceImpl<DictValueMapper, DictValue> implements DictValueService {

}
