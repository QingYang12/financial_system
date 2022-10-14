package com.financial_system.financial_system.investment.dao;

import com.financial_system.financial_system.income.entity.Income;
import com.financial_system.financial_system.investment.entity.Investment;

import java.util.List;

public interface InvestmentDao {
    int deleteByPrimaryKey(String id);

    int insert(Investment record);

    int insertSelective(Investment record);

    Investment selectByPrimaryKey(String id);
    List<Investment> queryAll(Investment item);
    int updateByPrimaryKeySelective(Investment record);

    int updateByPrimaryKey(Investment record);
}