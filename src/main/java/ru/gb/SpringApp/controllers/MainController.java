package ru.gb.SpringApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gb.SpringApp.model.Product;
import ru.gb.SpringApp.services.ProductService;

import java.util.List;

@Controller
@RequestMapping(value = "/home")
@RequiredArgsConstructor
public class MainController {

    private final ProductService productService;


//    @GetMapping
//    public String showAllProducts(Model model) {
//        List<Product> products = productService.getProductList();
//        model.addAttribute("products", products);
//        return "home";
//    }

    @GetMapping
    public String getById(@RequestParam(required = false, name = "id") Long id, Model model){
        model.addAttribute("products", productService.findById(id));
        return "home";
    }

}
