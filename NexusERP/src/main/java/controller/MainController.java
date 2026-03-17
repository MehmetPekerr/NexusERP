package com.example.Mimari.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";  // Burada "index" döndürmek, templates/index.html dosyasını render eder.
    }
}
