package com.nanyuan.wave.core.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nanyuan.wave.core.enums.DeleteStateEnum;
import com.nanyuan.wave.core.pojo.entity.User;
import com.nanyuan.wave.core.result.R;
import com.nanyuan.wave.core.service.UserService;
import com.nanyuan.wave.core.utils.CommonConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author yanghailang
 * @since 2021-07-02
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HashedCredentialsMatcher hashedCredentialsMatcher;


    @ApiOperation("查询list列表")
    @GetMapping("/list/{page}/{limit}")
    public R listByParentId(
            @ApiParam(value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(value = "查询关键字", required = false)
            @RequestParam(required=false) String keyword
    ){
        Page<User> pageParam = new Page<>(page, limit);
        IPage<User> pageModel = userService.list(pageParam,keyword);
        return R.ok().data("pageModel", pageModel);
    }



    @ApiOperation("保存用户")
    @PostMapping("/save")
    public R save(
            @ApiParam(value = "用户实体",required = true)
            @RequestBody User user){
        user.setIsDeleted(DeleteStateEnum.NORMAL.getStatus());

        //获取默认密码
        String password = new SimpleHash(
                hashedCredentialsMatcher.getHashAlgorithmName(), //加密算法
                CommonConstant.USER_DEFAULT_CIPHER, //默认密码
                ByteSource.Util.bytes(user.getUserLoginAccount()), //加密盐值
                hashedCredentialsMatcher.getHashIterations()) //加密次数
                .toHex();
        user.setUserLoginPwd(password);

        boolean result = userService.save(user);
        if(result){
            return R.ok().message("保存成功");
        }else {
            return R.ok().message("保存失败");
        }
    }

}
