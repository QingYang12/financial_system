package com.financial_system.financial_system.consumption.dao;

import com.financial_system.financial_system.consumption.entity.Consumption;
import com.financial_system.financial_system.consumption.vo.ConsumptionVo;

import java.util.List;

public interface ConsumptionDao {
    int deleteByPrimaryKey(String id);

    int insert(Consumption record);

    int insertSelective(Consumption record);

    Consumption selectByPrimaryKey(String id);
    List<Consumption> queryAll(ConsumptionVo item);

    int updateByPrimaryKeySelective(Consumption record);

    int updateByPrimaryKey(Consumption record);
}