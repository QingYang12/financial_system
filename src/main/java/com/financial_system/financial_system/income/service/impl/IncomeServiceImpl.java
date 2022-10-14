package com.financial_system.financial_system.income.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.financial_system.financial_system.common.PageParam;
import com.financial_system.financial_system.common.UUIDUtil;
import com.financial_system.financial_system.income.dao.IncomeDao;
import com.financial_system.financial_system.income.entity.Income;
import com.financial_system.financial_system.income.service.IncomeService;
import com.financial_system.financial_system.income.vo.IncomeVo;
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
@Service("incomeServiceImpl")
class IncomeServiceImpl implements IncomeService {
    @Resource
    private IncomeDao incomeDao;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Income queryById(String id) {
        return this.incomeDao.selectByPrimaryKey(id);
    }


    @Override
    public List<Income> queryByPage(PageParam pageParam) {
        JSONObject json = (JSONObject) JSON.toJSON(pageParam.getParam());
        IncomeVo param = (IncomeVo) JSON.toJavaObject(json, IncomeVo.class);
        int pageNum=pageParam.getPageNum();
        int pageSize=pageParam.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        return this.incomeDao.queryAll(param);
    }
    /**
     * 新增数据
     *
     * @param consumption 实例对象
     * @return 实例对象
     */
    @Override
    public Income insert(Income consumption) throws Exception{
            consumption.setId(UUIDUtil.getuuid());
            this.incomeDao.insert(consumption);
        return consumption;
    }

    /**
     * 修改数据
     *
     * @param consumption 实例对象
     * @return 实例对象
     */
    @Override
    public Income update(Income consumption) {
        this.incomeDao.updateByPrimaryKey(consumption);
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
        return this.incomeDao.deleteByPrimaryKey(id) > 0;
    }


}
