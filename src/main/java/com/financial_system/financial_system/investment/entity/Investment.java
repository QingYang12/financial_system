package com.financial_system.financial_system.investment.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * investment
 * @author 
 */
@Data
public class Investment implements Serializable {
    private String id;

    /**
     * 类别
     */
    private String type;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 单日变化
     */
    private Double dayMoney;

    /**
     * 单日占比
     */
    private Double dayMoneyRatio;

    /**
     * 投入本金余额
     */
    private Double investmentMoney;

    /**
     * 账户ID
     */
    private String userid;

    private static final long serialVersionUID = 1L;
    /**
     * 发生时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date happenTime;

}