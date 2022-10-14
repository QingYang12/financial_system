package com.financial_system.financial_system.consumption.controller;

import com.financial_system.financial_system.common.BeanCopierUtils;
import com.financial_system.financial_system.common.PageParam;
import com.financial_system.financial_system.common.PageResult;
import com.financial_system.financial_system.common.ResponseDto;
import com.financial_system.financial_system.consumption.entity.Consumption;
import com.financial_system.financial_system.consumption.service.ConsumptionService;
import com.financial_system.financial_system.consumption.vo.ConsumptionDto;
import com.financial_system.financial_system.login.service.LoginService;
import com.financial_system.financial_system.user.entity.User;
import com.financial_system.financial_system.user.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 员工管理员表(Consumption)表控制层
 *
 * @author makejava
 * @since 2021-04-03 18:36:29
 */
@RestController
@RequestMapping("consumption")
public class ConsumController {
    /**
     * 服务对象
     */
    @Resource
    private ConsumptionService consumptionServiceImpl;
    @Resource
    private UserService userServiceImpl;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Consumption selectOne(String id) {
        return this.consumptionServiceImpl.queryById(id);
    }
    /**查询管理员 API0015
     * 查询多条数据
     *
     * @return 对象列表
     */
    @RequestMapping(value="queryByPage" ,method = POST)
    @ResponseBody
    PageResult querybyPage(@RequestBody PageParam vo, HttpServletRequest request)throws  Exception{
        ResponseDto result=null;
        int code =200;
        String msg="success";
        try{
            String token = request.getHeader("X-Token");
            User user=userServiceImpl.tokenGetUserinfo(token);
            vo.setUserid(user.getId());
            List<Consumption> data=consumptionServiceImpl.queryByPage(vo);
            result=new ResponseDto(code,msg,data);
        }catch (Exception e){

            code=500;
            msg="error:"+e.getMessage();
            result=new ResponseDto(500,msg,null);
            e.printStackTrace();
        }
        PageResult pageResult=new PageResult(vo,result,code,msg);
        return pageResult;
    }
    /**新增管理员     API0012
     * 新增数据
     *
     * @param Consumption 实例对象
     * @return 实例对象
     */
    @RequestMapping("insert")
    @ResponseBody
    ResponseDto insert(@RequestBody Consumption Consumption, HttpServletRequest request){
        ResponseDto result=null;
        try{
            String token = request.getHeader("X-Token");
            User user=userServiceImpl.tokenGetUserinfo(token);
            Consumption.setUserid(user.getId());
            consumptionServiceImpl.insert(Consumption);
            result=new ResponseDto(200,"success",null);
        }catch (Exception e){
            result=new ResponseDto(500,"error:"+e.getMessage(),null);
            e.printStackTrace();
        }
        return result;
    }
    /**修改管理员         API0014
     * 修改数据
     *
     * @param Consumption 实例对象
     * @return 实例对象
     */
    @RequestMapping("update")
    @ResponseBody
    ResponseDto update(@RequestBody Consumption Consumption, HttpServletRequest request){
        ResponseDto result=null;
        try{
            String token = request.getHeader("X-Token");
            User user=userServiceImpl.tokenGetUserinfo(token);
            Consumption.setUserid(user.getId());
            consumptionServiceImpl.update(Consumption);
            result=new ResponseDto(200,"success",null);
        }catch (Exception e){
            result=new ResponseDto(500,"error:"+e.getMessage(),null);
            e.printStackTrace();
        }
        return result;
    }
    /**删除管理员           API0013
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @RequestMapping("delete")
    @ResponseBody
    ResponseDto deleteById(@RequestBody String id){
        ResponseDto result=null;
        try{
            consumptionServiceImpl.deleteById(id);
            result=new ResponseDto(200,"success",null);
        }catch (Exception e){
            result=new ResponseDto(500,"error:"+e.getMessage(),null);
            e.printStackTrace();
        }
        return result;
    }



}
