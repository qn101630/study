package com.qn.controller;

import com.qn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class HelloController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/success")
    public String success(ModelMap model) {
        model.addAttribute("hello", "<h1>Hello World</h1>");
        model.addAttribute("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "test";
    }

    @RequestMapping("/account")
    @ResponseBody
    public String account() {
        accountService.getAll().forEach(account -> System.out.println(account.toString()));
        return "success";
    }
}
