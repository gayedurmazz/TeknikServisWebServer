package com.uniyaz.web.rest;

import com.uniyaz.dao.UserDao;
import com.uniyaz.domain.User;
import com.uniyaz.web.converter.UserConverter;
import com.uniyaz.web.dto.UserDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserRestService {

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@FormParam("userName") String userName, @FormParam("password") String password) {

        UserDao userDao = new UserDao();
        User user = userDao.login(userName, password);

        UserConverter userConverter = new UserConverter();
        UserDto loggedUser = userConverter.convertToUserDto(user);

        return Response.ok().entity(loggedUser).build();
    }
}
