package com.financial_system.financial_system.consumption.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.financial_system.financial_system.common.Base64PWDUtil;
import com.financial_system.financial_system.common.BeanCopierUtils;
import com.financial_system.financial_system.common.PageParam;
import com.financial_system.financial_system.common.UUIDUtil;
import com.financial_system.financial_system.consumption.dao.ConsumptionDao;
import com.financial_system.financial_system.consumption.entity.Consumption;
import com.financial_system.financial_system.consumption.service.ConsumptionService;
import com.financial_system.financial_system.consumption.vo.ConsumptionDto;
import com.financial_system.financial_system.consumption.vo.ConsumptionVo;
import com.financial_system.financial_system.login.service.LoginService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工管理员表(consumption)表服务实现类
 *
 * @author makejava
 * @since 2021-04-03 18:36:29
 */
@Service("consumptionServiceImpl")
class consumptionServiceImpl implements ConsumptionService {
    @Resource
    private ConsumptionDao consumptionDao;
    @Resource
    private LoginService loginServiceImpl;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Consumption queryById(String id) {
        return this.consumptionDao.selectByPrimaryKey(id);
    }


    @Override
    public List<Consumption> queryByPage(PageParam pageParam) {
        JSONObject json = (JSONObject) JSON.toJSON(pageParam.getParam());
        ConsumptionVo param = (ConsumptionVo) JSON.toJavaObject(json, ConsumptionVo.class);
        int pageNum=pageParam.getPageNum();
        int pageSize=pageParam.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        return this.consumptionDao.queryAll(param);
    }
    /**
     * 新增数据
     *
     * @param consumption 实例对象
     * @return 实例对象
     */
    @Override
    public Consumption insert(Consumption consumption) throws Exception{
            consumption.setId(UUIDUtil.getuuid());
            this.consumptionDao.insert(consumption);
        return consumption;
    }

    /**
     * 修改数据
     *
     * @param consumption 实例对象
     * @return 实例对象
     */
    @Override
    public Consumption update(Consumption consumption) {
        this.consumptionDao.updateByPrimaryKey(consumption);
        return this.queryById(consumption.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.consumptionDao.deleteByPrimaryKey(id) > 0;
    }


}
