package com.imantou.auth.service;

import com.imantou.auth.dto.LoginForm;
import com.imantou.auth.vo.AuthTokenVO;
import com.imantou.auth.vo.PlatformUserContextVO;

/**
 * 登录服务接口
 *
 * @author gaobug
 */
public interface LoginService {

    /**
     * 平台用户登录
     *
     * @param form 登录表单
     * @return 登录令牌
     */
    AuthTokenVO platformUserLogin(LoginForm form);

    /**
     * 后台用户登录
     *
     * @param randomId 验证码key
     * @param form     登录表单
     * @return 登录令牌
     */
    AuthTokenVO systemLogin(String randomId, LoginForm form);

    /**
     * 获取平台登录用户基本信息
     *
     * @return 平台登录用户基本信息
     */
    PlatformUserContextVO getPlatformLoginUserInfo();

}
