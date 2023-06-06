package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@RequestMapping("")
public class HomeController {
    @Autowired
    MessageSource messageSource;
    @GetMapping
    public String home(@RequestParam(value = "lang",defaultValue = "en") String lang, Model model){
        Locale locale = Locale.forLanguageTag(lang);
        String title = messageSource.getMessage("message.title",null,locale);
        model.addAttribute("title",title);
        return "index";
    }
}
