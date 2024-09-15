package com.ucb.FrankyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;

import org.springframework.stereotype.Component;
import java.util.Locale;

@Component
public class ConfigurationParam {
    @Autowired
    MessageSource messageSource;

    @Value("${messageGreeting}")
    String greetingMessage;

    public String getGreetingMessage(String language){
        Locale locale=new Locale(language);
        return messageSource.getMessage("greetingMessage",null,locale);}
}
