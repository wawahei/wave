package com.nanyuan.wave.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanyuan.wave.core.enums.DeleteStateEnum;
import com.nanyuan.wave.core.mapper.DictValueMapper;
import com.nanyuan.wave.core.pojo.entity.DictValue;
import com.nanyuan.wave.core.service.DictValueService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private DictValueMapper dictValueMapper;

    @Override
    public IPage<DictValue> list(Page<DictValue> pageParam, String typeCode) {
        QueryWrapper<DictValue> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("VALUE_ID");

        if(!StringUtils.isEmpty(typeCode)){
            queryWrapper
                    .eq("TYPE_CODE",typeCode);
        }

        IPage<DictValue> page = baseMapper.selectPage(pageParam,queryWrapper);
        return page;
    }

    @Override
    public boolean saveList(List<DictValue> list) {
        for(DictValue dictValue:list){
            dictValue.setIsDeleted(DeleteStateEnum.NORMAL.getStatus());
        }
        int count = dictValueMapper.saveList(list);
        return count>0;
    }
}
