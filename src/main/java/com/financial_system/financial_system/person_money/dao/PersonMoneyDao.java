package com.financial_system.financial_system.person_money.dao;

import com.financial_system.financial_system.consumption.entity.Consumption;
import com.financial_system.financial_system.person_money.entity.PersonMoney;

import java.util.List;

public interface PersonMoneyDao {
    int deleteByPrimaryKey(String userid);

    int insert(PersonMoney record);

    int insertSelective(PersonMoney record);

    PersonMoney selectByPrimaryKey(String userid);
    List<PersonMoney> queryAll(PersonMoney item);
    int updateByPrimaryKeySelective(PersonMoney record);

    int updateByPrimaryKey(PersonMoney record);
}