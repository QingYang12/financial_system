package com.financial_system.financial_system.investment.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.financial_system.financial_system.common.PageParam;
import com.financial_system.financial_system.common.UUIDUtil;
import com.financial_system.financial_system.investment.dao.InvestmentDao;
import com.financial_system.financial_system.investment.entity.Investment;
import com.financial_system.financial_system.investment.service.InvestmentService;
import com.financial_system.financial_system.investment.vo.InvestmentVo;
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
@Service("investmentServiceImpl")
class InvestmentServiceImpl implements InvestmentService {
    @Resource
    private InvestmentDao investmentDao;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Investment queryById(String id) {
        return this.investmentDao.selectByPrimaryKey(id);
    }


    @Override
    public List<Investment> queryByPage(PageParam pageParam) {
        JSONObject json = (JSONObject) JSON.toJSON(pageParam.getParam());
        InvestmentVo param = (InvestmentVo) JSON.toJavaObject(json, InvestmentVo.class);
        int pageNum=pageParam.getPageNum();
        int pageSize=pageParam.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        return this.investmentDao.queryAll(param);
    }
    /**
     * 新增数据
     *
     * @param consumption 实例对象
     * @return 实例对象
     */
    @Override
    public Investment insert(Investment consumption) throws Exception{
            consumption.setId(UUIDUtil.getuuid());
            this.investmentDao.insert(consumption);
        return consumption;
    }

    /**
     * 修改数据
     *
     * @param consumption 实例对象
     * @return 实例对象
     */
    @Override
    public Investment update(Investment consumption) {
        this.investmentDao.updateByPrimaryKey(consumption);
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
        return this.investmentDao.deleteByPrimaryKey(id) > 0;
    }


}
