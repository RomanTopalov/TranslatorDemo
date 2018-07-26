package com.ua.converters;

import com.ua.dto.UserDto;
import com.ua.entities.User;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {

        User user = new User();
        if(userDto.getId() != null && !StringUtils.isEmpty(userDto.getId())){
            userDto.setId(new ObjectId(userDto.getId()).toHexString());
        }
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setRate(userDto.getRate());
        return user;
    }
}
