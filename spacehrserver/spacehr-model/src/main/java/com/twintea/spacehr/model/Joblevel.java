package com.twintea.spacehr.model;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName joblevel
 */
@TableName(value ="joblevel")
@Data
@NoArgsConstructor
public class Joblevel implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 职称名称
     */
    private String name;

    /**
     * 
     */
    private Object titleLevel;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer enabled;

    @TableLogic
    private Integer delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Joblevel(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joblevel joblevel = (Joblevel) o;
        return Objects.equals(name, joblevel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}