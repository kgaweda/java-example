package com.example.javaexmaple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaexmaple.model.User;
import com.example.javaexmaple.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    // CREATE 
public User createUser(User emp) {
    return repository.save(emp);
}

// READ
public List<User> getUsers() {
    return repository.findAll();
}

// DELETE
public void deleteUser(int empId) {
    repository.deleteById(empId);
}
}
