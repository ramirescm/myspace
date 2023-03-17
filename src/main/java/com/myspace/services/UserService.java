package com.myspace.services;

import com.myspace.entities.User;
import com.myspace.repositories.UserRepository;
import com.myspace.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User user) {
        var updating = findById(user.getId());
        updateData(updating, user);
        return userRepository.save(updating);
    }

    private void updateData(User user, User obj) {
        user.setEmail(obj.getEmail());
        user.setName(obj.getName());
    }
}
