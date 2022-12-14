package com.twintea.spacehr.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName menu_role
 */
@TableName(value ="menu_role")
@Data
public class MenuRole implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer mid;

    /**
     * 
     */
    private Integer rid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}