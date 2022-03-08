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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DemoController {
    
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
}
