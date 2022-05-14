package com.example.ApiSpringBoot.services;

import java.util.*;

import com.example.ApiSpringBoot.models.UserModel;
import com.example.ApiSpringBoot.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//this is to indicate to spring-boot that is a Service
@Service
public class UserService {
    //Autowired is to inject dependencies
    @Autowired
    UserRepository userRepository;

    //method to get a list of all users that exists in database
    public ArrayList<UserModel> getUser(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    //method to add or modify the user, since it use "save" to check the id user
    public UserModel addUser(UserModel user){
        return userRepository.save(user);
    }

    //this method allows that there aren´t errors in the case if there isn´t id
    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    //method use the method abstract of the class repository
    public ArrayList<UserModel> getByPrioridad(Integer prioridad){
        return userRepository.findByPrioridad(prioridad);
    }

    public boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
