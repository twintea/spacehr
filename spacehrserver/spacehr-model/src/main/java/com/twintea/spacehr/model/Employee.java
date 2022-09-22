package com.twintea.spacehr.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName employee
 */
@TableName(value ="employee")
@Data
public class Employee implements Serializable {
    /**
     * 员工编号
     */
    @TableId(type = IdType.AUTO)
    @ExcelProperty(value = "id")
    private Integer id;

    /**
     * 员工姓名
     */
    @ExcelProperty(value = "姓名")
    private String name;

    /**
     * 性别
     */
    @ExcelProperty(value = "性别")
    private String gender;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @ExcelProperty(value = "出生日期")
    private Date birthday;

    /**
     * 身份证号
     */
    @ExcelProperty(value = "身份证号")
    private String idCard;

    /**
     * 婚姻状况
     */
    @ExcelProperty(value = "婚姻状况")
    private String wedlock;

    /**
     * 民族
     */
    @ExcelProperty(value = "民族")
    private Integer nationId;

    /**
     * 籍贯
     */
    @ExcelProperty(value = "籍贯")
    private String nativePlace;

    /**
     * 政治面貌
     */
    @ExcelProperty(value = "政治面貌")
    private Integer politicId;

    /**
     * 邮箱
     */
    @ExcelProperty(value = "邮箱")
    private String email;

    /**
     * 电话号码
     */
    @ExcelProperty(value = "电话号码")
    private String phone;

    /**
     * 联系地址
     */
    @ExcelProperty(value = "联系地址")
    private String address;

    /**
     * 所属部门
     */
    @ExcelProperty(value = "所属部门")
    private Integer departmentId;

    /**
     * 职称ID
     */
    @ExcelProperty(value = "职称id")
    private Integer jobLevelId;

    /**
     * 职位ID
     */
    @ExcelProperty(value = "职位id")
    private Integer posId;

    /**
     * 聘用形式
     */
    @ExcelProperty(value = "聘用形式")
    private String engageForm;

    /**
     * 最高学历
     */
    @ExcelProperty(value = "学历")
    private String tiptopDegree;

    /**
     * 所属专业
     */
    @ExcelProperty(value = "所属专业")
    private String specialty;

    /**
     * 毕业院校
     */
    @ExcelProperty(value = "毕业院校")
    private String school;

    /**
     * 入职日期
     */
    @ExcelProperty(value = "入职日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date beginDate;

    /**
     * 在职状态
     */
    @ExcelProperty(value = "在职状态")
    private String workState;

    /**
     * 工号
     */
    @ExcelProperty(value = "工号")
    private String workId;

    /**
     * 合同期限
     */
    @ExcelProperty(value = "合同期限")
    private Double contractTerm;

    /**
     * 转正日期
     */
    @ExcelProperty(value = "转正日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date conversionTime;

    /**
     * 离职日期
     */
    @ExcelProperty(value = "离职日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date notWorkDate;

    /**
     * 合同起始日期
     */
    @ExcelProperty(value = "合同起始日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date beginContract;

    /**
     * 合同终止日期
     */
    @ExcelProperty(value = "合同终止日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date endContract;

    /**
     * 工龄
     */
    @ExcelProperty(value = "工龄")
    private Integer workAge;

    /**
     *逻辑删除 1未删除；0删除
     */
    @TableLogic
    private Integer delFlag;

    @TableField(exist = false)
    private Nation nation;

    @TableField(exist = false)
    private Department department;

    @TableField(exist = false)
    private Politicsstatus politicsstatus;

    @TableField(exist = false)
    private Joblevel joblevel;

    @TableField(exist = false)
    private Position position;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}