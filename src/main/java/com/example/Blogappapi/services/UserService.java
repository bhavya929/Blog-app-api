package com.example.Blogappapi.services;

import com.example.Blogappapi.payloads.Userdt;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserService {
    Userdt createUser(Userdt user);
    Userdt updateUser(Userdt user,Integer id);
    Userdt getUserById(Integer id);
    List<Userdt> getAllUsers();
    void deleteUser(Integer id);
}
