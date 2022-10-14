package com.financial_system.financial_system.login.service;

import com.financial_system.financial_system.login.entity.UserToken;
import com.financial_system.financial_system.user.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * 员工管理员表(User)表服务接口
 *
 * @author makejava
 * @since 2021-04-03 18:36:29
 */

public interface LoginService {


    UserToken login(User user) throws Exception;
    void logout(HttpServletRequest ret);
    //校验方法  所有用户中是否包含username
    boolean verifiedUser(String username);

}
