package com.financial_system.financial_system.debt.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * debt
 * @author 
 */
@Data
public class Debt implements Serializable {
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
     * 债务金额
     */
    private Double money;

    /**
     * 发生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date happenTime;

    /**
     * 还款日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date repaymentTime;

    /**
     * 还款类别
     */
    private String repaymentType;

    /**
     * 还款时长
     */
    private Integer repaymentDayNum;

    /**
     * 本期应还款金额
     */
    private Double currentPayMoney;

    /**
     * 账户ID
     */
    private String userid;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Debt other = (Debt) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getHappenTime() == null ? other.getHappenTime() == null : this.getHappenTime().equals(other.getHappenTime()))
            && (this.getRepaymentTime() == null ? other.getRepaymentTime() == null : this.getRepaymentTime().equals(other.getRepaymentTime()))
            && (this.getRepaymentType() == null ? other.getRepaymentType() == null : this.getRepaymentType().equals(other.getRepaymentType()))
            && (this.getRepaymentDayNum() == null ? other.getRepaymentDayNum() == null : this.getRepaymentDayNum().equals(other.getRepaymentDayNum()))
            && (this.getCurrentPayMoney() == null ? other.getCurrentPayMoney() == null : this.getCurrentPayMoney().equals(other.getCurrentPayMoney()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getHappenTime() == null) ? 0 : getHappenTime().hashCode());
        result = prime * result + ((getRepaymentTime() == null) ? 0 : getRepaymentTime().hashCode());
        result = prime * result + ((getRepaymentType() == null) ? 0 : getRepaymentType().hashCode());
        result = prime * result + ((getRepaymentDayNum() == null) ? 0 : getRepaymentDayNum().hashCode());
        result = prime * result + ((getCurrentPayMoney() == null) ? 0 : getCurrentPayMoney().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", money=").append(money);
        sb.append(", happenTime=").append(happenTime);
        sb.append(", repaymentTime=").append(repaymentTime);
        sb.append(", repaymentType=").append(repaymentType);
        sb.append(", repaymentDayNum=").append(repaymentDayNum);
        sb.append(", currentPayMoney=").append(currentPayMoney);
        sb.append(", userid=").append(userid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}