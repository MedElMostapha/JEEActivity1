package com.firstactiviy.mainactivty.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hellow")
    public String hellow() {
        return "hellow";
    }

}