package com.springproject.springrestfulserviceexample.controller;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j //for printing logs
@RequestMapping(value = "pc") //localhost/pc
@RestController
public class Home {
    @RequestMapping(value = "hello")
    public String first(){
        log.info("called");
        return "Hello";
    }

    @GetMapping(value = "area")
    public int calculateArea(){
        int l=23,b=50;
        return l*b;
    }

    @GetMapping(value = "open/{username}/{password}")
    public String checkAccount(@PathVariable String username,@PathVariable String password){
        String s;
        log.info("Username: {} Password: {}",username,password);
        if ((username.equalsIgnoreCase("bikas")) && (password.equalsIgnoreCase("123")) ){
             s= "Welcome";
        }else{
             s= "incorrect password";
        }
        return s;
    }


    //Request Param
//    [base_url]/pc/convert?nepalicurrency=100
    @GetMapping(value = "convert")
    public String convert(@RequestParam(name = "nepalicurrency",defaultValue = "1")Integer nc){
        String s ="The equivalent nepali currency is "+nc*119;
        return s;
    }

}
