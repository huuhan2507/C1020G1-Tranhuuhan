package com.example.controller;

import com.example.model.Email;
import com.example.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SettingController {
    @Autowired
    private SettingService settingService;
    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute( "setting",new Email("English",25,false,"Thor King,Asgard") );
        model.addAttribute("language", settingService.language() );
        model.addAttribute( "page",settingService.page() );
        return "/form-setting";
    }
    @PostMapping("/setting")
    public String setting(@RequestParam String action ,  @ModelAttribute("setting")Email email , Model model){
        if (action.equals( "Cancel" )){
            return "redirect:/";
        }else {
            model.addAttribute( "language",settingService.language() );
            model.addAttribute( "page",settingService.page() );
          return "/form-setting";
        }
    }
}
