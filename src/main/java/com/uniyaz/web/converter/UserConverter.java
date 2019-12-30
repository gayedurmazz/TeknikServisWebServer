package com.uniyaz.web.converter;

import com.uniyaz.domain.User;
import com.uniyaz.web.dto.UserDto;

public class UserConverter {
    public User convertToUser(UserDto userDto){
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto convertToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

}
