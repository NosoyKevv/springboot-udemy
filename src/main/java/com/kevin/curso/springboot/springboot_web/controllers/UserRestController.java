package com.kevin.curso.springboot.springboot_web.controllers;

import com.kevin.curso.springboot.springboot_web.models.User;
import com.kevin.curso.springboot.springboot_web.models.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")//ruta de primer nivel arriba del controlador /api/details
public class UserRestController {

    @GetMapping("/details")
    public UserDto details() {
        User user = new User("Kevin", "Vergel","pepito@gmail.com");

        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Curso SpringBoot");

        return userDto;
    }

    @GetMapping("/details-map")
    public Map<String, Object> detailsMap() {
        User user = new User("Kevin", "Vergel","pepito@gmail.com");

        Map<String, Object> body = new HashMap<>();
        body.put("title", "Curso SpringBoot");
        body.put("user", user);

        return body;
    }

    @GetMapping("/list")
    public List<User> list() {
        User user = new User("Kevin", "Vergel","pepito@gmail.com");
        User user1 = new User("Santiago", "Vergel","pepapig@gmail.com");
        User user2 = new User("Santiago", "Lázaro","juanchito@gmail.com");

        List<User> users = Arrays.asList(user, user1, user2);

//        List<User> users = new ArrayList<>();
//        users.add(user);
//        users.add(user1);
//        users.add(user2);
        return users;
    }

}
