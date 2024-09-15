package com.ucb.FrankyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    ConfigurationParam configurationParam;
@Autowired
    public GreetingService(ConfigurationParam configurationParam){
        this.configurationParam=configurationParam;
    }

    public String getGreeting(String language){
        return configurationParam.getGreetingMessage(language);
    }

    public String getPersonalizedGreeting(String name, String language){
        return name+": "+configurationParam.getGreetingMessage(language);
    }
}
