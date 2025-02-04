package com.kevin.curso.springboot.springboot_web.controllers;

import com.kevin.curso.springboot.springboot_web.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")//ruta de primer nivel arriba del controlador /api/details
public class UserRestController {

    @GetMapping("/details")
    public Map<String, Object> details() {
        User user = new User("Kevin", "Vergel");
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Curso SpringBoot");
        body.put("user", user);
        return body;
    }

}
