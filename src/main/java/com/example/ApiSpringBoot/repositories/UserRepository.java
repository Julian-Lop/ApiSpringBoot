package com.example.ApiSpringBoot.repositories;

import java.util.ArrayList;

import com.example.ApiSpringBoot.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//put label @Repository to indicate to spring-boot that is a repository 
@Repository
public interface UserRepository extends CrudRepository<UserModel,Long> {
    public abstract ArrayList<UserModel> findByPrioridad(Integer prioridad);
}
