package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Specify the annotation to register a rest controller (instead of controller annotation)
@RestController
public class HelloWorldController {

//    GET
//    URI - /hello-world
//    method - "Hello World"
//    The get request needs to be mapped to the URI, use the proper annotation to accomplish that
//    RequestMapping annotation is a more general way of mapping HTTP verbs with URI's



    @GetMapping(path = "/hello-world")
    public String hello(){
        return "Hello World";
    }




    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloBean(){
        return new HelloWorldBean("hi!");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean HelloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hey, %s you are doing great!",name));
    }



}
