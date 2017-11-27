
package com.ai.ai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ss")
public class MainController {

    @RequestMapping
    public String main(){
        return "static/index.html";
    }
}
