package com.karalaitis.planner.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping
    public String showIndexPage(){
        return "index/index";
    }


}
