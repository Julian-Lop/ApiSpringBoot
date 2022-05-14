package com.example.ApiSpringBoot.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.ApiSpringBoot.models.UserModel;
import com.example.ApiSpringBoot.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// this is to indicate to spring-boot that is a controller
// mapping is to indicate the rute in the which to access to the data
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    //this shows the all users when make a request get
    @GetMapping()
    public ArrayList<UserModel> getUsers(){
        return userService.getUser();
    }

    //this cans send by body the json data to add or modify in database
    @PostMapping
    public UserModel addUser(@RequestBody UserModel user){
        return this.userService.addUser(user);
    }

    //this cans get one user by id
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.getById(id);
    }

    //this cans get users by prioridad
    @GetMapping("/query")
    public ArrayList<UserModel> getUserByPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.userService.getByPrioridad(prioridad);
    }

    //method to delete user vy id
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if(ok)
            return "user deleted successfully";
        else
            return "couldn´t delete user";
    }
}
