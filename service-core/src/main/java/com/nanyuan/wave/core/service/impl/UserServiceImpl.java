package com.nanyuan.wave.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanyuan.wave.core.mapper.UserMapper;
import com.nanyuan.wave.core.pojo.entity.User;
import com.nanyuan.wave.core.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yanghailang
 * @since 2021-07-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public IPage<User> list(Page<User> pageParam, String keyword) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("USER_ID");

        if(!StringUtils.isEmpty(keyword)){
            queryWrapper
                    .like("USER_NAME",keyword)
                    .or().like("USER_NO",keyword);
        }

        IPage<User> page = baseMapper.selectPage(pageParam,queryWrapper);
        return page;
    }
}
