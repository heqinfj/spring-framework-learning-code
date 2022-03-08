package com.linkedbear.spring.boot.dao;

import com.linkedbear.spring.boot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(User user) {
        System.out.println("UserDao jdbcTemplate: " + jdbcTemplate);
        jdbcTemplate.update("insert into tbl_user_test (name, tel) values (?, ?)", user.getName(), user.getTel());
    }
}
