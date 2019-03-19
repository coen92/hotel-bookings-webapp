package com.coen92.projects.web.hotelbookings.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ViewController {

    @RequestMapping(value = "/")
    public String index(Model model) {

        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Coen92");
        model.addAttribute("mode", "development");
//        model.addAttribute("mode", "production");

        return "index";
    }
}
