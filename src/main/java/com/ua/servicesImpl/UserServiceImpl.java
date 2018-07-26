package com.ua.servicesImpl;

import com.ua.converters.UserDtoToUser;
import com.ua.dao.UserRepository;
import com.ua.dto.UserDto;
import com.ua.entities.User;
import com.ua.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserDtoToUser userDtoToUser;

    public UserServiceImpl(UserRepository userRepository, UserDtoToUser userDtoToUser) {
        this.userRepository = userRepository;
        this.userDtoToUser = userDtoToUser;
    }

    @Override
    public List<User> listAll() {
        List<User> users= new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveOrUpdate(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);

    }

    @Override
    public User saveOrUpdateUserDto(UserDto userDto) {
        User saveUser = saveOrUpdate(userDtoToUser.convert(userDto));
        return saveUser;
    }
}