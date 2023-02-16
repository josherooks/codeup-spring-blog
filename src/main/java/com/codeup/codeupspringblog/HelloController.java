package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

record Message(String message){}
@Controller
public class HelloController {
//Method will listen for GET request
    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld(){
        return "<h1>Hello from Spring!</h1>";
    }

    @GetMapping(path= "/json", produces = "application/json")
    @ResponseBody
    public Message returnMessage(){
        return new Message("Hello from Spring.");
    }

    @RequestMapping(path = "/color", method = RequestMethod.GET)
    @ResponseBody
    public String color(){
        return"Royal Blue!";
    }

    @GetMapping("/hello/{firstName}")
    @ResponseBody
    public String sayHello(@PathVariable String firstName) {
        return "<h1>Hello " + firstName + "!</h1>";
    }

}
