package com.linkedbear.spring.withdao.controller;

import com.linkedbear.spring.withdao.entity.User;
import com.linkedbear.spring.withdao.service.DepartmentService;
import com.linkedbear.spring.withdao.service.UserService;
import com.linkedbear.spring.withdao.validation.UserPasswordGroup;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController76 implements ApplicationContextAware {
    
    @Autowired
    UserService userService;
    @Autowired
    DepartmentService departmentService;
    
    @GetMapping("/list")
    public String list(@ModelAttribute("username") String username, ModelMap map) {
        System.out.println(username);
        map.put("userList", userService.findAllUsers());
        return "user/userList";
    }
    
    @GetMapping("/edit")
    public String edit(HttpServletRequest request, @NotBlank String id) {
        request.setAttribute("user", userService.findById(id));
        request.setAttribute("deptList", departmentService.findDepartments(null));
        return "user/userInfo";
    }
    
    @PostMapping("/save")
    public String save(@Validated(UserPasswordGroup.class) User user, BindingResult bindingResult) {
        if (StringUtils.isEmpty(user.getName())) {
            throw new IllegalArgumentException("User的name为空");
        }
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors()
                    .forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
            throw new RuntimeException("数据格式不正确！");
        }
        System.out.println(user);
        return "redirect:/user/list";
    }
    
    @PostMapping("/batchDelete")
    @ResponseBody
    public String batchDelete(@RequestParam("ids[]") List<String> ids) {
//        System.out.println(Arrays.toString(ids));
        System.out.println(ids);
        return "success";
    }

    @PostMapping("/testReq1")
    @ResponseBody
    public String testReq1(@RequestParam("ids[]") List<String> ids) {
        System.out.println(ids);
        return "success";
    }

    @PostMapping("/testReq2")
    @ResponseBody
    public String testReq2(@RequestBody Map map) {
        System.out.println(map);
        return "success";
    }

    @PostMapping("/testReq3")
    @ResponseBody
    public String testReq3(Map map) {
        System.out.println("testReq3...");
        return "success";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("UserController76 applicationContext: " + applicationContext);
    }
}
