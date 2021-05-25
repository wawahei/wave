package com.nanyuan.wave.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanyuan.wave.core.mapper.DictTypeMapper;
import com.nanyuan.wave.core.pojo.entity.DictType;
import com.nanyuan.wave.core.service.DictTypeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 字典类型表 GROUP_ID为0的数据为初始化数据 服务实现类
 * </p>
 *
 * @author yanghailang
 * @since 2021-05-25
 */
@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Override
    public IPage<DictType> list(Page<DictType> pageParam, String keyword) {

        QueryWrapper<DictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("TYPE_ID");

        if(!StringUtils.isEmpty(keyword)){
            queryWrapper
                    .like("TYPE_CODE",keyword)
                    .or().like("TYPE_NAME",keyword);
        }

        IPage<DictType> page = baseMapper.selectPage(pageParam,queryWrapper);
        return page;
    }
}
