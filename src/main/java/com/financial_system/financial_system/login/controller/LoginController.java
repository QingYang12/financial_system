package com.financial_system.financial_system.login.controller;

import com.financial_system.financial_system.common.ResponseDto;
import com.financial_system.financial_system.login.entity.UserToken;
import com.financial_system.financial_system.login.service.LoginService;
import com.financial_system.financial_system.user.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 员工管理员表(User)表控制层
 *
 * @author makejava
 * @since 2021-04-03 18:36:29
 */
@RestController
@RequestMapping("/user")
public class LoginController {
    /**
     * 服务对象
     */
    @Resource
    private LoginService loginServiceImpl;


    /**登录系统     API0022
     *
     *
     * @param User 实例对象
     * @return 实例对象
     */
    @RequestMapping("login")
    @ResponseBody
    ResponseDto login(@RequestBody User User){
        ResponseDto result=null;
        try{
            UserToken userToken =loginServiceImpl.login(User);
            result=new ResponseDto(200,"success",userToken);
        }catch (Exception e){
            result=new ResponseDto(500,"error:"+e.getMessage(),null);
            e.printStackTrace();
        }
        return result;
    }
    /**登出系统     API0023
     *
     *
     * @param
     * @return 实例对象
     */
    @RequestMapping("logout")
    @ResponseBody
    ResponseDto logout(HttpServletRequest ret){
        ResponseDto result=null;
        try{
            loginServiceImpl.logout(ret);
            result=new ResponseDto(200,"success",null);
        }catch (Exception e){
            result=new ResponseDto(500,"error:"+e.getMessage(),null);
            e.printStackTrace();
        }
        return result;
    }
}
