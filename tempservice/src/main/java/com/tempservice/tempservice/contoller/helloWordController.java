package com.tempservice.tempservice.contoller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tmp")
public class helloWordController {

    @GetMapping("hello")
    public String getHello(@RequestHeader Map<String, String> headers) {
    headers.forEach((key, value) -> {
        System.out.println(String.format("Header '%s' = %s", key, value));
    });
        return "Hello Word from temp service";
    }
    
}
