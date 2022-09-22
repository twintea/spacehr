package com.twintea.spacehr.service;

import com.twintea.spacehr.model.MailSendLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Pixar
* @description 针对表【mail_send_log】的数据库操作Service
* @createDate 2022-06-22 00:42:40
*/
public interface MailSendLogService extends IService<MailSendLog> {

    void updateStatus(String msgId, Integer i);
}
