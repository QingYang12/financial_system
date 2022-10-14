package com.financial_system.financial_system.consumption.vo;



import com.financial_system.financial_system.consumption.entity.Consumption;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 员工管理员表(User)实体类
 *
 * @author makejava
 * @since 2021-04-03 18:36:29
 */
@Data
public class ConsumptionVo extends Consumption implements Serializable {
    public List<String> happenTimes;
    public String happenTimesStart;
    public String happenTimesEnd;
}
