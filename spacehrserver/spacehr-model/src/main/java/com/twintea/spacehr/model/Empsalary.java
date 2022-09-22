package com.twintea.spacehr.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName empsalary
 */
@TableName(value ="empsalary")
@Data
public class Empsalary implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer eid;

    /**
     * 
     */
    private Integer sid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}