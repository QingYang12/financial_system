package com.financial_system.financial_system.debt.dao;

import com.financial_system.financial_system.consumption.entity.Consumption;
import com.financial_system.financial_system.debt.entity.Debt;

import java.util.List;

public interface DebtDao {
    int deleteByPrimaryKey(String id);

    int insert(Debt record);

    int insertSelective(Debt record);

    Debt selectByPrimaryKey(String id);
    List<Debt> queryAll(Debt item);

    int updateByPrimaryKeySelective(Debt record);

    int updateByPrimaryKey(Debt record);
}