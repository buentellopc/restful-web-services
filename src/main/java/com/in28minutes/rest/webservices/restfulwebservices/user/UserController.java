package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    private UserDaoService usersDao;


    //    Retrieve all users
    @GetMapping(path = "/users")
    public List<User> getUsers() {
        return usersDao.findAll();
    }

    //    Retrieve a user
//    Casting automatically from string to id?
//    path variable is "1" or 1
//    parameter to getUser accepts an int
    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = usersDao.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }
        return user;
    }


    //
//    input - details of user
//
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        usersDao.save(user);

//        After CREATED, return URI based on current path
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
