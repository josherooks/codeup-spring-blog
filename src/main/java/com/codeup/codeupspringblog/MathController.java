package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable Integer num1, @PathVariable Integer num2 ) {
            return num1 + "+" + num2 + "=" + (num1 + num2);
        }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String sub(@PathVariable Integer num1, @PathVariable Integer num2 ) {
        return num1 + "-" + num2 + "=" + (num2 - num1);
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable Long num1, @PathVariable Long num2 ) {
        return num1 + "x" + num2 + "=" + (num1 * num2);
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable Double num1, @PathVariable Double num2 ) {
        return num1 + "/" + num2 + "=" + (num1 / num2);
    }



}
