package com.twintea.spacehr.controller.system;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.config.AccessLimit;
import com.twintea.spacehr.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/init/spacehrsql")
@AccessLimit(seconds = 120,maxCount = 1)
public class ResumeDatabaseController {

private Logger logger = LoggerFactory.getLogger(ResumeDatabaseController.class);

    @Autowired
    private DataService dataService;

    @GetMapping("/")
    //定时任务 每天8点和14点重置数据库
    @Scheduled(cron = "0 0 8,14 * * ? ")
    public RespBean resetDatabase(){
        logger.info("【开始】重置数据库spacehr的数据");
        long start = System.currentTimeMillis();
        if (!dataService.resetDataBase("spacehrbck.sql")){
            return RespBean.error("重置数据库失败！");
        }

        long end = System.currentTimeMillis();

        String cost = "用时：" + (end - start) / 1000.0 + "秒";
        logger.info("【结束】重置成功：" + cost);
        return RespBean.ok("重置数据库成功!", cost);
    }
}
