package com.nanyuan.wave.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nanyuan.wave.core.pojo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanyuan.wave.core.pojo.vo.LoginVO;
import com.nanyuan.wave.core.pojo.vo.UserInfoVO;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author yanghailang
 * @since 2021-07-02
 */
public interface UserService extends IService<User> {

    IPage<User> list(Page<User> pageParam, String keyword);

    UserInfoVO login(LoginVO loginVO);
}
