package com.twintea.spacehr.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName msgcontent
 */
@TableName(value ="msgcontent")
@Data
public class Msgcontent implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String message;

    /**
     * 
     */
    private Date createdate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}