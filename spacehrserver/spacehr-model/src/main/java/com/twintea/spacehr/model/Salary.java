package com.twintea.spacehr.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName salary
 */
@TableName(value ="salary")
@Data
public class Salary implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 基本工资
     */
    private Double basicSalary;

    /**
     * 奖金
     */
    private Double bonus;

    /**
     * 午餐补助
     */
    private Double lunchSalary;

    /**
     * 交通补助
     */
    private Double trafficSalary;

    /**
     * 应发工资
     */
    private Double allSalary;

    /**
     * 养老金基数
     */
    private Double pensionBase;

    /**
     * 养老金比率
     */
    private Double pensionper;

    /**
     * 启用时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /**
     * 医疗基数
     */
    private Double medicalBase;

    /**
     * 医疗保险比率
     */
    private Double medicalper;

    /**
     * 公积金基数
     */
    private Double accumulationFundBase;

    /**
     * 公积金比率
     */
    private Double accumulationFundper;

    /**
     * 
     */
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}