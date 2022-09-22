package com.twintea.spacehr.mapper;

import com.twintea.spacehr.model.MailSendLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Pixar
* @description 针对表【mail_send_log】的数据库操作Mapper
* @createDate 2022-06-22 00:42:40
* @Entity com.twintea.spacehr.domain.MailSendLog
*/
public interface MailSendLogMapper extends BaseMapper<MailSendLog> {

    void updateStatus(@Param("msgId") String msgId, @Param("status") Integer status);
}




