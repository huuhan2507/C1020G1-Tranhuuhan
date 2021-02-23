package com.example.controller;

import com.example.service.DictionaryService;
import com.example.service.DictionaryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    DictionaryService dictionaryService = new DictionaryServiceImpl();
    @GetMapping("/home")
    public String goHome(){
        return "/home";
    }

    @PostMapping("/home")
    public String search(@RequestParam String search, Model model){
        String result;
        if (dictionaryService.dictionary().get( search ) != null){
            result = dictionaryService.dictionary().get( search );
        }else {
            result = "Khong Tim Thay";
        }
        model.addAttribute( "search", search );
        model.addAttribute( "result",result );
        return "/home";
    }
}
