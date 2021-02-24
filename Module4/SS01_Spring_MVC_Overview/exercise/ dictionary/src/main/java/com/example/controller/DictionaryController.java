package com.example.controller;

import com.example.service.DictionaryService;
import com.example.service.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller

public class DictionaryController {

    @GetMapping("/home")
    public String goHome(){
        return "/home";
    }

    @Autowired
    private DictionaryService dictionaryService;
    @PostMapping("/search")
    public String search(@RequestParam String search, Model model){
        String result = dictionaryService.search( search );
        model.addAttribute( "search", search );
        model.addAttribute( "result",result );
        return "/home";
    }
}
