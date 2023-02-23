package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

record Message(String message){}
@Controller
public class HelloController {


//Method will listen for GET request
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
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

    @GetMapping("/hello/{firstName}/{lastName}")
    @ResponseBody
    public String sayHello(@PathVariable String firstName, @PathVariable String lastName) {
        return "<h1>Hello " + firstName + " " + lastName + "!</h1>";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }

    @GetMapping("/dogpark")
    public String dogPark(Model model) {
        List<String> dogs = new ArrayList<>();
        dogs.add("Bubbles");
        dogs.add("Spot");
        dogs.add("Ezekial");

        model.addAttribute("dogs", dogs);
        return "dogPark";
    }

}
