package com.springproject.springrestfulserviceexample.controller;


//import org.springframework.beans.factory.annotation.Value;
//import com.sun.org.apache.xpath.internal.operations.String;
import com.springproject.springrestfulserviceexample.model.Student;
import lombok.extern.slf4j.Slf4j;
        import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping(value="home")
//@ResponseBody
//@Controller
//Instead of writing response body and controller we can write rest controller which combines both.
@RestController
public class ReferenceOfAllController {

    //I have changed here the default port value to 8081

    //Different controller class

    //1.
    //the display message will run on localhost/home/hello
    @RequestMapping(value="hello")
    public String display(){
        return "Hello world!!";
    }
    //2
    //here two numbers will be added
    //localhost/home/add
    @RequestMapping(value="add",method = RequestMethod.GET)
    public int addTwoNumbers(){
        return 1000+1000;
    }

    //GetMapping Instead of Request mapping
    @GetMapping(value = "subtraction")
    public int subtraction(){
        int sub =50-30;
        return sub;
    }

    @RequestMapping(value = "stu",method = RequestMethod.POST)
    //@PostMapping(value ="stu")
    public String displayDetails(@RequestBody Student student){
        String s =student.getFirstname()+student.getLastname();
        return s;
    }

//    http://localhost:8081/home/subtract/num1/num2


    //3.
    //path variables

    @RequestMapping(value = "subtract/{num1}/{num2}",method = RequestMethod.GET)
    public int subtract(@PathVariable int num1,@PathVariable int num2){
        log.info("num1 {} num2 {}",num1,num2);
        int result =num1-num2;
        return result;
    }

    @RequestMapping(value = "addition/{num1}/{num2}",method = RequestMethod.GET)
    public int add(@PathVariable(name ="num1") int a,@PathVariable(name="num2") int b){
        log.info("num1 {} num2 {}",a,b);
        int result =a+b;
        return result;
    }

    //{BASEURL}/home/greet1?name=bikas
    @RequestMapping(value = "greet1",method = RequestMethod.GET)
    public String greet1(@RequestParam(name ="name")String name){
        return "welcome " +name;
    }
//{BASEURL}/home/greet1?name=bikas
    @RequestMapping(value = "greet2",method = RequestMethod.GET)
    public String greet2(@RequestParam(name ="name" ,defaultValue = "hari")String name){
        return "welcome " +name;
    }

    //returning object
    //http://localhost:8081/home/object
    @GetMapping(value = "object")
    public Student displayObject(){
        Student student= new Student();
        student.setFirstname("Bikash");
        student.setLastname("Shah");
        return student;
    }

    @GetMapping(value = "array")
    public List<Student> displayArrayObject(){
        Student student= new Student();
        student.setFirstname("Bikash");
        student.setLastname("Shah");

        List<Student> students= new ArrayList<>();
        students.add(student);
        return students;
    }
}
