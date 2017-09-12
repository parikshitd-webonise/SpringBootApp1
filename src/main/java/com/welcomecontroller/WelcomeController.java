package com.welcomecontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";
    private String info = "Showing info from getInfo Controller Method";

    /*
        welcome controller which shows welcome.html page for user
     */
    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        model.put("info","");
        return "welcome";
    }

    /*
       controller method for redirecting on same page with addition data
     */
    @RequestMapping(value="/getinfo", method = RequestMethod.GET)
    public String getInfo(Map<String, Object> model) {
       model.put("message", this.message);
       model.put("info", this.info);
       return "welcome";
    }
}