package com.financial_system.financial_system.debt.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.financial_system.financial_system.common.PageParam;
import com.financial_system.financial_system.common.UUIDUtil;
import com.financial_system.financial_system.debt.dao.DebtDao;
import com.financial_system.financial_system.debt.entity.Debt;
import com.financial_system.financial_system.debt.service.DebtService;
import com.financial_system.financial_system.debt.vo.DebtVo;
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
@Service("debtServiceImpl")
class DebtServiceImpl implements DebtService {
    @Resource
    private DebtDao debtDao;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Debt queryById(String id) {
        return this.debtDao.selectByPrimaryKey(id);
    }


    @Override
    public List<Debt> queryByPage(PageParam pageParam) {
        JSONObject json = (JSONObject) JSON.toJSON(pageParam.getParam());
        DebtVo param = (DebtVo) JSON.toJavaObject(json, DebtVo.class);
        int pageNum=pageParam.getPageNum();
        int pageSize=pageParam.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        return this.debtDao.queryAll(param);
    }
    /**
     * 新增数据
     *
     * @param consumption 实例对象
     * @return 实例对象
     */
    @Override
    public Debt insert(Debt consumption) throws Exception{
            consumption.setId(UUIDUtil.getuuid());
            this.debtDao.insert(consumption);
        return consumption;
    }

    /**
     * 修改数据
     *
     * @param consumption 实例对象
     * @return 实例对象
     */
    @Override
    public Debt update(Debt consumption) {
        this.debtDao.updateByPrimaryKey(consumption);
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
        return this.debtDao.deleteByPrimaryKey(id) > 0;
    }


}
