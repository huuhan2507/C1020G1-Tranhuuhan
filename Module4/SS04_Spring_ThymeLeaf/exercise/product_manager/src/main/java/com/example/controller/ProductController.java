package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute( "products",productService.showProduct() );
        return "/home";
    }
    @GetMapping("/product/create")
    public String createProduct(Model model){
        model.addAttribute( "product",new Product( ) );
        return "/create";
    }
    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute Product product, @RequestParam String action,Model model){
        switch (action){
            case "create":
                if (productService.checkId( product.getId() )){
                    model.addAttribute( "message","Successfully Create !" );
                    productService.saveProduct( product );
                    model.addAttribute( "products",productService.showProduct() );
                }else {
                    model.addAttribute( "error","Id already exists !" );
                    return "/create";
                }
                break;
            case "update":
                model.addAttribute( "message","Successfully fixed !" );
                productService.saveProduct( product );
                model.addAttribute( "products",productService.showProduct() );
                break;
            default:
        }
        return "/home";
    }
    @GetMapping ("/product/{id}/edit")
    public String updateProduct(@PathVariable int id , Model model){
        model.addAttribute( "product",productService.findById( id ) );
        return "/update";
    }
    @GetMapping("/product/{id}/delete")
    public String deleteProduct(@PathVariable int id,Model model){
        productService.removeProduct( id );
        model.addAttribute( "products", productService.showProduct() );
        model.addAttribute( "message","Successfully delete !" );
        return "/home";
    }
    @GetMapping("/product/{id}/view")
    public String viewProduct(@PathVariable int id,Model model){
        model.addAttribute( "product", productService.findById( id ) );
        return "/view";
    }
}
