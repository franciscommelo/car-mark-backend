package com.example.carmark.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service @RequiredArgsConstructor @Transactional @Slf4j @Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("Saving user: {}", user);
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving role: {}", role);
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        log.info("Adding role {} to user {}", role, username);
        User user = userRepository.findByUsername(username);
        Role role1 = roleRepository.findByName(role);
        user.getRoles().add(role1);
    }

    @Override
    public User getUser(String username) {
        log.info("Getting user: {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Getting all users");
        return userRepository.findAll();
    }
}

