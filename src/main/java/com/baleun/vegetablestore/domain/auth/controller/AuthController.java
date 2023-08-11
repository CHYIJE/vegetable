package com.baleun.vegetablestore.domain.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @GetMapping("auth/join")
public String join(){
    return "auth/join";
}
@GetMapping("auth/login")
public String login(HttpSession session){
    Object attribute = session.getAttribute("userIdx");
    Integer idx = (Integer) attribute;
    System.out.println("로그인페이지 idx : " + idx);
    return "auth/login";
}
}
