package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService usersDao;


//    Retrieve all users
    @GetMapping(path = "/users")
    public List<User> getUsers(){
        return usersDao.findAll();
    }

//    Retrieve a user
//    Casting automatically from string to id?
//    path variable is "1" or 1
//    parameter to getUser accepts an int
    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id){
        return usersDao.findOne(id);
    }




}
