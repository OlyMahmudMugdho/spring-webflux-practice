package com.mahmud.spring_webflux_practice.controllers;

import com.mahmud.spring_webflux_practice.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping()
    public String login(Authentication authentication) {
        if (authentication != null) {
            User user = (User) authentication.getPrincipal();
            // System.out.println(user.getEmail());
            System.out.println(authentication.getAuthorities());
            return "redirect:/";
        }
//        if (principal != null) {
//            System.out.println(principal);
//            return "redirect:/";
//        }
        return "login";
    }
}
