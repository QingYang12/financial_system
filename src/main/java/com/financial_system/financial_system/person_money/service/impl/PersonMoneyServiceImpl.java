package com.financial_system.financial_system.person_money.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.financial_system.financial_system.common.PageParam;
import com.financial_system.financial_system.common.UUIDUtil;
import com.financial_system.financial_system.person_money.dao.PersonMoneyDao;
import com.financial_system.financial_system.person_money.entity.PersonMoney;
import com.financial_system.financial_system.person_money.service.PersonMoneyService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工管理员表(personMoney)表服务实现类
 *
 * @author makejava
 * @since 2021-04-03 18:36:29
 */
@Service("personMoneyServiceImpl")
class PersonMoneyServiceImpl implements PersonMoneyService {
    @Resource
    private PersonMoneyDao personMoneyDao;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PersonMoney queryById(String id) {
        return this.personMoneyDao.selectByPrimaryKey(id);
    }


    @Override
    public List<PersonMoney> queryByPage(PageParam pageParam) {
        JSONObject json = (JSONObject) JSON.toJSON(pageParam.getParam());
        PersonMoney param = (PersonMoney) JSON.toJavaObject(json, PersonMoney.class);
        int pageNum=pageParam.getPageNum();
        int pageSize=pageParam.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        return this.personMoneyDao.queryAll(param);
    }
    /**
     * 新增数据
     *
     * @param personMoney 实例对象
     * @return 实例对象
     */
    @Override
    public PersonMoney insert(PersonMoney personMoney) throws Exception{
            personMoney.setUserid(UUIDUtil.getuuid());
            this.personMoneyDao.insert(personMoney);
        return personMoney;
    }

    /**
     * 修改数据
     *
     * @param personMoney 实例对象
     * @return 实例对象
     */
    @Override
    public PersonMoney update(PersonMoney personMoney) {
        this.personMoneyDao.updateByPrimaryKey(personMoney);
        return this.queryById(personMoney.getUserid());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.personMoneyDao.deleteByPrimaryKey(id) > 0;
    }


}
