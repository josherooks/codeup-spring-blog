package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDice {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll";
    }

    @GetMapping("/roll-dice/{n}")
        public String random(@PathVariable int n, Model model){
        int randomNum = (int) Math.floor(Math.random() * 6) + 1;
        String result = "You win!";
        model.addAttribute("n", n);
        model.addAttribute("randomNum", randomNum);
        if(randomNum == n){
            model.addAttribute("result", result);
        }
        return "roll";
        }
}
