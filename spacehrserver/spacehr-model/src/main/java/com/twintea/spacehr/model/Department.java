package com.twintea.spacehr.model;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName department
 */
@TableName(value = "department")
@Data
@NoArgsConstructor
public class Department implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     *
     */
    private Integer parentid;

    @TableField(exist = false)
    private List<Department> children;

    /**
     *
     */
    private String depPath;

    /**
     *
     */
    private Integer enabled;

    /**
     *
     */
    private Integer isParent;

    /**
     * 1未删除
     * 0删除
     */
    @TableLogic
    private Integer delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


    public Department(String name) {
        this.name = name;
    }

    //重写equals和hashcode，名字相同则对象相同
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}