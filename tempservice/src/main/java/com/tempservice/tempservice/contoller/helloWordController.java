package com.tempservice.tempservice.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tmp")
public class helloWordController {

    @GetMapping("hello")
    public String getHello() {
        return "Hello Word from temp service";
    }
    
}
