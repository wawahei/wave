package com.nanyuan.wave.core.controller;

import com.nanyuan.wave.core.exception.Assert;
import com.nanyuan.wave.core.pojo.vo.LoginVO;
import com.nanyuan.wave.core.pojo.vo.UserInfoVO;
import com.nanyuan.wave.core.result.R;
import com.nanyuan.wave.core.result.ResponseEnum;
import com.nanyuan.wave.core.service.UserService;
import com.nanyuan.wave.core.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/api/user")
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @ApiOperation("会员登录")
    @PostMapping("/login")
    public R login(@RequestBody LoginVO loginVO, HttpServletRequest request){

        String userName = loginVO.getUserName();
        String password = loginVO.getUserLoginPwd();

        Assert.notEmpty(userName, ResponseEnum.PARAM_NOT_EMPTY);
        Assert.notEmpty(password, ResponseEnum.PARAM_NOT_EMPTY);

        String ip = request.getRemoteAddr();
        UserInfoVO userInfoVO = userService.login(loginVO);

        return R.ok().data("userInfo", userInfoVO);
    }

    @ApiOperation("校验令牌")
    @GetMapping("/checkToken")
    public R checkToken(HttpServletRequest request) {

        String token = request.getHeader("token");
        boolean result = JwtUtils.checkToken(token);

        if(result){
            return R.ok();
        }else{
            return R.setResult(ResponseEnum.LOGIN_AUTH_ERROR);
        }

    }

}


