package com.financial_system.financial_system.analysis.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.financial_system.financial_system.analysis.service.AnalysisService;
import com.financial_system.financial_system.analysis.vo.AnalysisVo;
import com.financial_system.financial_system.consumption.dao.ConsumptionDao;
import com.financial_system.financial_system.consumption.entity.Consumption;
import com.financial_system.financial_system.consumption.vo.ConsumptionVo;
import com.financial_system.financial_system.debt.dao.DebtDao;
import com.financial_system.financial_system.debt.entity.Debt;
import com.financial_system.financial_system.debt.vo.DebtVo;
import com.financial_system.financial_system.income.dao.IncomeDao;
import com.financial_system.financial_system.income.entity.Income;
import com.financial_system.financial_system.income.vo.IncomeVo;
import com.financial_system.financial_system.investment.dao.InvestmentDao;
import com.financial_system.financial_system.investment.entity.Investment;
import com.financial_system.financial_system.investment.vo.InvestmentVo;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工管理员表(consumption)表服务实现类
 *
 * @author makejava
 * @since 2021-04-03 18:36:29
 */
@Service("analysisServiceImpl")
class AnalysisServiceImpl implements AnalysisService {
    @Resource
    private ConsumptionDao consumptionDao;
    @Resource
    private DebtDao debtDao;
    @Resource
    private IncomeDao incomeDao;
    @Resource
    private InvestmentDao investmentDao;

    @Override
    public JSONArray query(AnalysisVo vo) {
        ConsumptionVo consumptionVo=new ConsumptionVo();
        consumptionVo.setHappenTimesStart(vo.getHappenTimesStart());
        consumptionVo.setHappenTimesEnd(vo.getHappenTimesEnd());
        consumptionVo.setUserid(vo.getUserid());
        List<Consumption> consumptionres=consumptionDao.queryAll(consumptionVo);
        Double consumptionall=0d;
        for (Consumption consumption:consumptionres){
            consumptionall+=consumption.getMoney();
        }
        DebtVo debtVo=new DebtVo();
        debtVo.setHappenTimesStart(vo.getHappenTimesStart());
        debtVo.setHappenTimesEnd(vo.getHappenTimesEnd());
        debtVo.setUserid(vo.getUserid());
        List<Debt> debtres=debtDao.queryAll(debtVo);
        Double debtall=0d;
        for (Debt debt:debtres){
            debtall+=debt.getMoney();
        }
        IncomeVo incomeVo=new IncomeVo();
        incomeVo.setHappenTimesStart(vo.getHappenTimesStart());
        incomeVo.setHappenTimesEnd(vo.getHappenTimesEnd());
        incomeVo.setUserid(vo.getUserid());
        List<Income> incomeres=incomeDao.queryAll(incomeVo);
        Double incomeall=0d;
        for (Consumption income:consumptionres){
            incomeall+=income.getMoney();
        }
        InvestmentVo investmentVo=new InvestmentVo();
        investmentVo.setHappenTimesStart(vo.getHappenTimesStart());
        investmentVo.setHappenTimesEnd(vo.getHappenTimesEnd());
        investmentVo.setUserid(vo.getUserid());
        List<Investment> investmentres=investmentDao.queryAll(investmentVo);
        Double investmentall=0d;
        for (Investment investment:investmentres){
            investmentall+=investment.getDayMoney();
        }
        JSONArray res=new JSONArray();
        JSONObject consumptionitem=new JSONObject();
        consumptionitem.put("name","支出");
        consumptionitem.put("value",consumptionall);
        res.add(consumptionitem);
        JSONObject debtitem=new JSONObject();
        debtitem.put("name","债务");
        debtitem.put("value",debtall);
        res.add(debtitem);
        JSONObject incomeitem=new JSONObject();
        incomeitem.put("name","收入");
        incomeitem.put("value",incomeall);
        res.add(incomeitem);
        JSONObject investmentitem=new JSONObject();
        investmentitem.put("name","理财");
        investmentitem.put("value",investmentall);
        res.add(investmentitem);
        return res;
    }
}
