package com.financial_system.financial_system.analysis.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.financial_system.financial_system.analysis.entity.Analysis;
import com.financial_system.financial_system.analysis.service.AnalysisService;
import com.financial_system.financial_system.analysis.vo.AnalysisVo;
import com.financial_system.financial_system.common.PageParam;
import com.financial_system.financial_system.common.PageResult;
import com.financial_system.financial_system.common.ResponseDto;
import com.financial_system.financial_system.consumption.entity.Consumption;
import com.financial_system.financial_system.consumption.vo.ConsumptionVo;
import com.financial_system.financial_system.user.entity.User;
import com.financial_system.financial_system.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 员工管理员表(Consumption)表控制层
 *
 * @author makejava
 * @since 2021-04-03 18:36:29
 */
@RestController
@RequestMapping("analysis")
public class AnalysisController {
    /**
     * 服务对象
     */
    @Resource
    private AnalysisService analysisServiceImpl;
    @Resource
    private UserService userServiceImpl;


    @RequestMapping(value="query" ,method = POST)
    @ResponseBody
    PageResult query(@RequestBody PageParam pageParam, HttpServletRequest request)throws  Exception{
        ResponseDto result=null;
        int code =200;
        String msg="success";
        try{
            JSONObject json = (JSONObject) JSON.toJSON(pageParam.getParam());
            AnalysisVo param = (AnalysisVo) JSON.toJavaObject(json, AnalysisVo.class);
            String token = request.getHeader("X-Token");
            User user=userServiceImpl.tokenGetUserinfo(token);
            param.setUserid(user.getId());
            JSONArray data=analysisServiceImpl.query(param);
            result=new ResponseDto(code,msg,data);
        }catch (Exception e){

            code=500;
            msg="error:"+e.getMessage();
            result=new ResponseDto(500,msg,null);
            e.printStackTrace();
        }
        PageResult pageResult=new PageResult(pageParam,result,code,msg);
        return pageResult;
    }

    @RequestMapping(value="yearquery" ,method = POST)
    @ResponseBody
    PageResult yearquery(@RequestBody PageParam pageParam, HttpServletRequest request)throws  Exception{
        ResponseDto result=null;
        int code =200;
        String msg="success";
        try{
            JSONObject json = (JSONObject) JSON.toJSON(pageParam.getParam());
            AnalysisVo param = (AnalysisVo) JSON.toJavaObject(json, AnalysisVo.class);
            String token = request.getHeader("X-Token");
            User user=userServiceImpl.tokenGetUserinfo(token);
            param.setUserid(user.getId());
            //  处理
            String happenTimey=param.getHappenTimey();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTimenow = LocalDateTime.now();
            if(happenTimey==null){
                LocalDateTime firstDayOfYear = LocalDateTime.of(LocalDate.from(LocalDateTime.now().with(TemporalAdjusters.firstDayOfYear())), LocalTime.MIN);
                LocalDateTime lastDayOfYear = LocalDateTime.of(LocalDate.from(LocalDateTime.now().with(TemporalAdjusters.lastDayOfYear())), LocalTime.MAX);
                param.happenTimesStart=formatter.format(firstDayOfYear);
                param.happenTimesEnd=formatter.format(lastDayOfYear);
            }else{
                LocalDateTime ldt = LocalDateTime.parse(happenTimey, formatter);
                LocalDateTime firstDayOfYear = LocalDateTime.of(LocalDate.from(LocalDate.from(ldt).with(TemporalAdjusters.firstDayOfYear())), LocalTime.MIN);
                LocalDateTime lastDayOfYear = LocalDateTime.of(LocalDate.from(LocalDate.from(ldt).with(TemporalAdjusters.lastDayOfYear())), LocalTime.MAX);
                param.happenTimesStart=formatter.format(firstDayOfYear);
                param.happenTimesEnd=formatter.format(lastDayOfYear);
            }

            JSONArray data=analysisServiceImpl.query(param);
            result=new ResponseDto(code,msg,data);
        }catch (Exception e){

            code=500;
            msg="error:"+e.getMessage();
            result=new ResponseDto(500,msg,null);
            e.printStackTrace();
        }
        PageResult pageResult=new PageResult(pageParam,result,code,msg);
        return pageResult;
    }
    @RequestMapping(value="monthquery" ,method = POST)
    @ResponseBody
    PageResult monthquery(@RequestBody PageParam pageParam, HttpServletRequest request)throws  Exception{
        ResponseDto result=null;
        int code =200;
        String msg="success";
        try{
            JSONObject json = (JSONObject) JSON.toJSON(pageParam.getParam());
            AnalysisVo param = (AnalysisVo) JSON.toJavaObject(json, AnalysisVo.class);
            String token = request.getHeader("X-Token");
            User user=userServiceImpl.tokenGetUserinfo(token);
            param.setUserid(user.getId());
            //  处理
            String happenTimem=param.getHappenTimem();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTimenow = LocalDateTime.now();
            if(happenTimem==null){
                LocalDateTime firstDayOfMonth = LocalDateTime.of(LocalDate.from(LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth())), LocalTime.MIN);
                LocalDateTime lastDayOfMonth = LocalDateTime.of(LocalDate.from(LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth())), LocalTime.MAX);
                param.happenTimesStart=formatter.format(firstDayOfMonth);
                param.happenTimesEnd=formatter.format(lastDayOfMonth);
            }else{
                LocalDateTime ldt = LocalDateTime.parse(happenTimem, formatter);
                LocalDateTime firstDayOfMonth = LocalDateTime.of(LocalDate.from(LocalDate.from(ldt).with(TemporalAdjusters.firstDayOfMonth())), LocalTime.MIN);
                LocalDateTime lastDayOfMonth = LocalDateTime.of(LocalDate.from(LocalDate.from(ldt).with(TemporalAdjusters.lastDayOfMonth())), LocalTime.MAX);
                param.happenTimesStart=formatter.format(firstDayOfMonth);
                param.happenTimesEnd=formatter.format(lastDayOfMonth);
            }

            JSONArray data=analysisServiceImpl.query(param);
            result=new ResponseDto(code,msg,data);
        }catch (Exception e){

            code=500;
            msg="error:"+e.getMessage();
            result=new ResponseDto(500,msg,null);
            e.printStackTrace();
        }
        PageResult pageResult=new PageResult(pageParam,result,code,msg);
        return pageResult;
    }
    @RequestMapping(value="dayquery" ,method = POST)
    @ResponseBody
    PageResult dayquery(@RequestBody PageParam pageParam, HttpServletRequest request)throws  Exception{
        ResponseDto result=null;
        int code =200;
        String msg="success";
        try{
            JSONObject json = (JSONObject) JSON.toJSON(pageParam.getParam());
            AnalysisVo param = (AnalysisVo) JSON.toJavaObject(json, AnalysisVo.class);
            String token = request.getHeader("X-Token");
            User user=userServiceImpl.tokenGetUserinfo(token);
            param.setUserid(user.getId());
            String getHappenTimet=param.getHappenTimet();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            if(getHappenTimet==null){
                // 获取当天的起始时间
                LocalDateTime firstTimeOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
                LocalDateTime lastTimeOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

                param.happenTimesStart=formatter.format(firstTimeOfDay);
                param.happenTimesEnd=formatter.format(lastTimeOfDay);
            }else{
                LocalDateTime ldt = LocalDateTime.parse(getHappenTimet, formatter);
                LocalDateTime firstTimeOfDay = LocalDateTime.of(LocalDate.from(ldt), LocalTime.MIN);
                LocalDateTime lastTimeOfDay = LocalDateTime.of(LocalDate.from(ldt), LocalTime.MAX);
                param.happenTimesStart=formatter.format(firstTimeOfDay);
                param.happenTimesEnd=formatter.format(lastTimeOfDay);
            }

            JSONArray data=analysisServiceImpl.query(param);
            result=new ResponseDto(code,msg,data);
        }catch (Exception e){

            code=500;
            msg="error:"+e.getMessage();
            result=new ResponseDto(500,msg,null);
            e.printStackTrace();
        }
        PageResult pageResult=new PageResult(pageParam,result,code,msg);
        return pageResult;
    }
}
