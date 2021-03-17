package kz.webProgram.controller;

import kz.webProgram.model.Basket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @GetMapping("/")
    public String greeting(Model model) {
        return "index";
    }
    @GetMapping("/index")
    public String about(Model model) {
        return "list";
    }
}