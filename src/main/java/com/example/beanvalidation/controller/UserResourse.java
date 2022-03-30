package com.example.beanvalidation.controller;

import com.example.beanvalidation.model.Users;
import com.example.beanvalidation.myexceptions.UserNotFoundException;
import com.example.beanvalidation.repo.UserRepo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserResourse {

    @GetMapping
    public List<Users> getAllUser(){
        return UserRepo.allUser;
    }

    @GetMapping("/{id}")
    public Users getUser(@PathVariable int id){
        return UserRepo.allUser.stream()
                .filter(u->u.getId() == id)
                .findFirst()
                .orElseThrow(()-> new UserNotFoundException(String.format("User with id %d not found",id )));

    }


    @PostMapping()
    public void getUser(@Valid  @RequestBody Users users){
        System.out.println(users);
    }

}
