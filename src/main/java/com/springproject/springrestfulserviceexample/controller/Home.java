package com.springproject.springrestfulserviceexample.controller;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

    //exception example1
    @GetMapping("salary")
    public String getSalary(){
        String name =null;
        name.toUpperCase(); //produces null pointer exception
        return String.valueOf(50000);
    }

    //here we get null pointer exception
    // to handle the error
//  @ExceptionHandler(NullPointerException.class)
//    public String handleError(NullPointerException e){
//        return "Null pointer exception thrown";
//    }
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleError(NullPointerException e){
        ErrorResponse errorResponse= new ErrorResponse(false,"Internal server error");
        log.error("Error result: {}",errorResponse);
        return errorResponse;

    }
    //exception example 2
    @GetMapping(value = "name")
    public String getName(){
        String a ="Hari";
        a.charAt(5);
        return a;
    }
    @ExceptionHandler(StringIndexOutOfBoundsException.class)
    public ErrorResponse handleError2(StringIndexOutOfBoundsException e){
        ErrorResponse errorResponse = new ErrorResponse(false,"Short index");
        log.error("Error result: {} ",errorResponse);
        return errorResponse;
    }
}
