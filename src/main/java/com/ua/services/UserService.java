package com.ua.services;

import com.ua.dto.UserDto;
import com.ua.entities.User;

import java.util.List;

public interface UserService {

    List<User> listAll();

    User getById(String id);

    User saveOrUpdate(User user);

    void delete(String id);

    User saveOrUpdateUserDto(UserDto userDto);
}
