package com.example.controller;

import com.example.entity.login.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "/home/home";
    }

    @GetMapping("/login")
    public String login() {
        return "home/login";
    }

    @GetMapping("/error403")
    public String error403() {
        return "/home/error403";
    }

    @GetMapping("/changePassword")
    public String changePassword() {
        return "/home/changePassword";
    }

    @PostMapping("/saveChangePassword")
    public String saveChangePassword(Model model, Principal principal, @RequestParam String oldPassword,
                                     @RequestParam String newPassword, @RequestParam String confirmPassword) {
        BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = userService.findByUserName( principal.getName() );
        if (!cryptPasswordEncoder.matches( oldPassword, user.getPassWord() )) {
            model.addAttribute( "message", "Password incorrect! Please re-enter." );
            return "/home/changePassword";
        } else if (cryptPasswordEncoder.matches( newPassword, user.getPassWord() )) {
            model.addAttribute( "message1", "The new password must be different from the old password !" );
            return "/home/changePassword";
        } else if (!userService.checkNewPassword( newPassword, confirmPassword )) {
            model.addAttribute( "message2", "The new password you entered does not match !" );
            return "/home/changePassword";
        }
        user.setPassWord( new BCryptPasswordEncoder().encode( newPassword ) );
        userService.save( user );
        return "redirect:/";
    }
}
