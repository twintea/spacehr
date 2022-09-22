package com.twintea.spacehr.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName mail_send_log
 */
@TableName(value ="mail_send_log")
@Data
public class MailSendLog implements Serializable {
    /**
     * 
     */
    private String msgid;

    /**
     * 
     */
    private Integer empid;

    /**
     * 0发送中，1发送成功，2发送失败
     */
    private Integer status;

    /**
     * 
     */
    private String routekey;

    /**
     * 
     */
    private String exchange;

    /**
     * 重试次数
     */
    private Integer count;

    /**
     * 第一次重试时间
     */
    private Date trytime;

    /**
     * 
     */
    private Date createtime;

    /**
     * 
     */
    private Date updatetime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}