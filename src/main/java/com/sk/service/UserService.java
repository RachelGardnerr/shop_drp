package com.sk.service;

import com.sk.domain.User;

import java.util.List;

public interface UserService {

    List<User> queryUser(User user);

    List<User> queryAllUser();

    List<User> queryUserByUsername(String username);

    List<User> queryUserByLoginAccount(String account);

    int addUser(User user);

    int deleteUserById(Integer id);

    int updateUser(User user);
}
