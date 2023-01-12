package com.pp23.boot.service;

import com.pp23.boot.entity.User;
import com.pp23.boot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }
    @Transactional
    @Override
    public void deleteUser(Long id) { userRepository.deleteById(id);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        User userDb = getUser(user.getId());
        userDb.setName(user.getName());
        userDb.setSurname(user.getSurname());
        userDb.setEmail(user.getEmail());
        userRepository.save(userDb);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
