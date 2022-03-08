package com.linkedbear.spring.boot.controller;

import com.linkedbear.spring.boot.service.UserService;
import com.linkedbear.spring.boot.threaddemo.mainsub.MainSubThreadTransSyncTool;
import com.linkedbear.spring.boot.threaddemo.mainsub.OrderHandleTask;
import com.linkedbear.spring.boot.threaddemo.mainsub.TestService;
import com.linkedbear.spring.boot.util.SpringContextUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController implements ApplicationContextAware {

    @GetMapping("/test")
    public String test() {
        UserService userService = SpringContextUtils.getBean("userService");
        userService.testDependController();
        return "test";
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/findAll")
    public List<Map<String, Object>> findAll() {
        return jdbcTemplate.query("select * from tbl_dept", new ColumnMapRowMapper());
    }

    @PostMapping({"/mockMainSubThreadTransactionSync","/mockTestMainSubThread"})
    public void mockMainSubThreadTransactionSync() {
        TransactionManager transactionManager = SpringContextUtils.getBean(TransactionManager.class);
        //System.out.println(transactionManager);
        int subThreadCount = 5;
        MainSubThreadTransSyncTool mainSubThreadTransSyncTool = new MainSubThreadTransSyncTool();
        //TestService testService = new TestService();
        UserService userService = SpringContextUtils.getBean("userService");
        Map<String, Object> params = new HashMap<>();
        params.putIfAbsent("userService", userService);
        Class taskClazz = OrderHandleTask.class;
        if (transactionManager instanceof DataSourceTransactionManager) {
            mainSubThreadTransSyncTool.excuteTask(subThreadCount, params, (DataSourceTransactionManager) transactionManager, taskClazz);
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("DemoController: " + applicationContext);
    }
}
