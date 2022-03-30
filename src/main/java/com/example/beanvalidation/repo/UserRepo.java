package com.example.beanvalidation.repo;

import com.example.beanvalidation.model.Users;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepo {

    public static List<Users> allUser = new ArrayList<>();

    static {
        allUser.add(new Users(1,"peter"));
        allUser.add(new Users(2,"joulie"));
        allUser.add(new Users(3,"jack"));
        allUser.add(new Users(4,"panda"));
    }
}
