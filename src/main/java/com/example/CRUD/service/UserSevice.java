package com.example.CRUD.service;

import com.example.CRUD.model.User;
import com.example.CRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


// бизнес логика
// некий запрос который мы будем принимать из внешнего мира
@Service//

public class UserSevice {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deletedById(Long id) {
        userRepository.deleteById(id);
    }
}
