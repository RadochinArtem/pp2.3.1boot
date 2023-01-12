package com.pp23.boot.service;



import com.pp23.boot.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();
}
