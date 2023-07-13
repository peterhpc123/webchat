package com.example.webchat.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: pehong
 * @date: 2023-07-10 21:56
 */
@RestController
public class LoginController {
    private static final String PASSWORD = "123456";
    @RequestMapping("/login")
    public Map login(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Map resultMap = new HashMap();
        if(PASSWORD.equals(password)){
            resultMap.put("success",true);
            resultMap.put("message","登录成功");
            request.getSession().setAttribute("username",username);
        }else {
            resultMap.put("success",false);
            resultMap.put("message","用户名或密码错误");
        }
        return resultMap;
    }
}
