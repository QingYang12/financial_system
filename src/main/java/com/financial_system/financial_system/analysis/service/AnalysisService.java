package com.financial_system.financial_system.analysis.service;

import com.alibaba.fastjson.JSONArray;
import com.financial_system.financial_system.analysis.entity.Analysis;
import com.financial_system.financial_system.analysis.vo.AnalysisVo;
import com.financial_system.financial_system.common.PageParam;

import java.util.List;

/**
 * 员工管理员表(User)表服务接口
 *
 * @author makejava
 * @since 2021-04-03 18:36:29
 */

public interface AnalysisService {

    public JSONArray query( AnalysisVo vo);

}
