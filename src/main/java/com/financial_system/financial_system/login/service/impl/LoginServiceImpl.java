package com.financial_system.financial_system.login.service.impl;

import com.financial_system.financial_system.common.TokenUtil;
import com.financial_system.financial_system.login.entity.UserToken;
import com.financial_system.financial_system.login.service.LoginService;
import com.financial_system.financial_system.user.dao.UserDao;
import com.financial_system.financial_system.user.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 员工管理员表(User)表服务实现类
 *
 * @author makejava
 * @since 2021-04-03 18:36:29
 */
@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserDao userDao;


    @Override
    public UserToken login(User user) throws Exception{
        UserToken userToken=new UserToken();
        List<User> userlist= this.userDao.queryAll(user);
        User customer=new User();
        customer.setUsername(user.getUsername());
        customer.setPassword(user.getPassword());
        List<User> customerlist=this.userDao.queryAll(customer);
        if(userlist.size()>0){
            User userItem=userlist.get(0);
            String userName=userItem.getUsername();
            String password=userItem.getPassword();
            String token= TokenUtil.getToken(userName);
            userToken.setToken(token);
        }else if(customerlist.size()>0){
            User userItem=customerlist.get(0);
            String userName=userItem.getUsername();
            String id=userItem.getId();
            String password=userItem.getPassword();
            String token= TokenUtil.getToken(id);
            userToken.setToken(token);
        }else{
            throw new Exception();
        }
        return  userToken;
    }
    @Override
    public void logout(HttpServletRequest ret) {
        //String xtoken=TokenUtil.requestGetXToken(ret);
        //String UserName=TokenUtil.tokenGetUsername(xtoken);
    }
    @Override
    public boolean verifiedUser(String username) {
        boolean  res=false;
        User user=new User();
        user.setUsername(username);
        List<User> userlist= this.userDao.queryAll(user);
        User customer=new User();
        customer.setUsername(username);
        List<User> customerlist=this.userDao.queryAll(customer);
        if(userlist.size()>0||customerlist.size()>0){
            res=true;
        }
        return  res;
    }


}
