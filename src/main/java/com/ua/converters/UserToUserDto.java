package com.ua.converters;

import com.ua.dto.UserDto;
import com.ua.entities.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDto implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.get_id().toHexString());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        userDto.setRate(user.getRate());
        return userDto;
    }
}
