package com.ucb.FrankyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {
    @Autowired
    GreetingService greetingService;

    @GetMapping("/personalized")
    public String personalizedGreeting(@RequestParam String name, @RequestParam(defaultValue = "en" ) String language){
        return greetingService.getPersonalizedGreeting(name,language);
    }
}
