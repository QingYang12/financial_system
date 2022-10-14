package com.financial_system.financial_system.debt.service;

import com.financial_system.financial_system.common.PageParam;
import com.financial_system.financial_system.debt.entity.Debt;

import java.util.List;

/**
 * 员工管理员表(User)表服务接口
 *
 * @author makejava
 * @since 2021-04-03 18:36:29
 */

public interface DebtService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Debt queryById(String id);


    List<Debt> queryByPage(PageParam pageParam);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    Debt insert(Debt user)throws Exception;

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    Debt update(Debt user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);


}
