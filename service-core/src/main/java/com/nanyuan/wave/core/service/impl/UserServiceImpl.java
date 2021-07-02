package com.nanyuan.wave.core.service.impl;

import com.nanyuan.wave.core.pojo.entity.User;
import com.nanyuan.wave.core.mapper.UserMapper;
import com.nanyuan.wave.core.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
