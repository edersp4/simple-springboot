package com.simple.simplespringboot.mapper;

import com.simple.simplespringboot.controller.UserResource;
import com.simple.simplespringboot.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = ConfigMapper.class)
public interface UserMapper {
    List<UserResource> toResources(List<User> users);

    UserResource toResource(User user);
}
