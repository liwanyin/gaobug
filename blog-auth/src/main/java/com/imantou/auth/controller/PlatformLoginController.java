package com.imantou.auth.controller;

import com.imantou.advice.response.ResponseWrapped;
import com.imantou.auth.dto.LoginForm;
import com.imantou.auth.service.LoginService;
import com.imantou.auth.vo.PlatformUserContextVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * 平台用户登录相关接口
 *
 * @author gaobug
 */
@Slf4j
@RestController
@RequestMapping("/login/platform")
public class PlatformLoginController {
    @Resource
    private LoginService loginService;

    /**
     * 登录
     */
    @PostMapping(value = "/login")
    public ResponseWrapped<Object> appLogin(@RequestBody LoginForm form) {
        return ResponseWrapped.success(loginService.platformUserLogin(form));
    }

    /**
     * 获取登录用户信息
     */
    @GetMapping("/info")
    public ResponseWrapped<Object> getLoginUserInfo() throws ExecutionException, InterruptedException {
        PlatformUserContextVO platformUserContextVO = loginService.getPlatformLoginUserInfo();
        return ResponseWrapped.success();
    }

    /**
     * 退出登录
     */
    @PostMapping("/loginOut")
    public ResponseWrapped<Object> loginOut() {
        return ResponseWrapped.success();
    }
}
