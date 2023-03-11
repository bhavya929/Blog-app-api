package com.example.Blogappapi.services.impl;

import com.example.Blogappapi.entities.User;
import com.example.Blogappapi.exceptions.ResourseNotFoundException;
import com.example.Blogappapi.payloads.Userdt;
import com.example.Blogappapi.repositories.UserRepo;
import com.example.Blogappapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Userdt createUser(Userdt userdt) {
        User ent = userdttouser(userdt);
        User saveEnt = userRepo.save(ent);
        Userdt usertouserdt = userToUserdto(saveEnt);
        return usertouserdt;
    }

    @Override
    public Userdt updateUser(Userdt userdtToUpdate, Integer id) {
        Optional<User> byId = userRepo.findById(id);
        if(byId.isPresent()){
            User save = userRepo.save(userdttouser(userdtToUpdate));
            Userdt usertouserdt = userToUserdto(save);
            return usertouserdt;
        }
        return null;
    }

    @Override
    public Userdt getUserById(Integer id) {
        Optional<User> byId = userRepo.findById(id);
        if(byId.isPresent()){
            Userdt usertouserdt = userToUserdto(byId.get());
            return usertouserdt;
        }
        throw new ResourseNotFoundException(String.format("User not found for id %s",id));
    }

    @Override
    public List<Userdt> getAllUsers() {
        List<User> all = userRepo.findAll();
        List<Userdt> collect = all.stream().map(user -> userToUserdto(user)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepo.deleteById(id);


    }

    private User userdttouser(Userdt userdt){
          User user=modelMapper.map(userdt,User.class);

//        user.setId(userdt.getId());
//        user.setName(userdt.getName());
//        user.setPassword(userdt.getPassword());
//        user.setEmail(userdt.getEmail());
//        user.setAbout(userdt.getAbout());
        return user;

    }

    private Userdt userToUserdto(User user){
        Userdt userdt=modelMapper.map(user,Userdt.class);
//        userdt.setId(user.getId());
//        userdt.setName(user.getName());
//        userdt.setPassword(user.getPassword());
//        userdt.setEmail(user.getEmail());
//        userdt.setAbout(user.getAbout());
        return userdt;

    }
}
