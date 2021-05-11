package com.example.controller;

import com.example.entity.GiaoDich;
import com.example.service.GiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class GiaoDichController {
    @Autowired
    private GiaoDichService giaoDichService;

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @GetMapping("/listGiaoDich")
    public String trangGiaoDich(Model model) {
        model.addAttribute( "giaoDichs", giaoDichService.findAll() );
        return "/list";
    }

    @GetMapping("/taoGiaoDich")
    public String taoGiaoDich(Model model) {
        model.addAttribute( "giaoDich", new GiaoDich() );
        model.addAttribute( "loaiDichVu", giaoDichService.findLoaiDichVuAll() );
        model.addAttribute( "khachHang", giaoDichService.findKhachHangAll() );
        return "/create";
    }

    @PostMapping("/giaoDich/save")
    public String save(@Validated @ModelAttribute GiaoDich giaoDich, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute( "giaoDich", giaoDich );
            model.addAttribute( "loaiDichVu", giaoDichService.findLoaiDichVuAll() );
            model.addAttribute( "khachHang", giaoDichService.findKhachHangAll() );
            return "/create";
        }
        giaoDichService.save( giaoDich );
        return "redirect:/listGiaoDich";
    }

    @GetMapping("/giaoDich/view/{code}")
    public String view(@PathVariable String code, Model model) {
        model.addAttribute( "giaoDich", giaoDichService.findByCode( code ) );
        return "/view";
    }
}
