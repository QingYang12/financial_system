package com.financial_system.financial_system.income.dao;

import com.financial_system.financial_system.consumption.entity.Consumption;
import com.financial_system.financial_system.income.entity.Income;

import java.util.List;

public interface IncomeDao {
    int deleteByPrimaryKey(String id);

    int insert(Income record);

    int insertSelective(Income record);

    Income selectByPrimaryKey(String id);

    List<Income> queryAll(Income item);

    int updateByPrimaryKeySelective(Income record);

    int updateByPrimaryKey(Income record);
}