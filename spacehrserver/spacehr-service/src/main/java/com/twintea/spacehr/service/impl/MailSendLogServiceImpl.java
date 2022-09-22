package com.twintea.spacehr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twintea.spacehr.model.MailSendLog;
import com.twintea.spacehr.service.MailSendLogService;
import com.twintea.spacehr.mapper.MailSendLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Pixar
* @description 针对表【mail_send_log】的数据库操作Service实现
* @createDate 2022-06-22 00:42:40
*/
@Service
public class MailSendLogServiceImpl extends ServiceImpl<MailSendLogMapper, MailSendLog>
    implements MailSendLogService{

    @Autowired
    private MailSendLogMapper mailSendLogMapper;

    @Override
    public void updateStatus(String msgId, Integer i) {
        mailSendLogMapper.updateStatus(msgId,i);
    }
}




