package com.kevin.curso.springboot.springboot_web.controllers;

import com.kevin.curso.springboot.springboot_web.models.User;
import com.kevin.curso.springboot.springboot_web.models.dto.ParamDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/pathvar")
public class PathVariableController {

    @Value("${config.code}")
    private String code;

    @Value("#{' ${config.listOfValue}'.split(',') }")
//cuando incluimos dos {{}} la del medio es la variable y luego con las '' ya seria un string y podemos usar el split para dividir ese string por comas
    private List<String> listOfValueString;

    @Value("#{'${config.listOfValue}'.toUpperCase()}")
    private String listString;


    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValue}")
    private List<String> listOfValue;


    @GetMapping("baz/{message}") //ENVIAR UN SOLO PARAMETRO /
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;

    }

    @GetMapping("mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        //ACA SE PONE LA LOGICA DE LO QUE SE QUIERE HACER CON LA DATA CUI CUI
        user.setName(user.getName().toUpperCase());
        user.setLastname(user.getLastname().toLowerCase());
        return user;
    }

    @GetMapping("/getvalues")
    public Map<String, Object> getValues() {
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("listString", listString);
        json.put("listOfValue", listOfValue);
        json.put("listOfValueString", listOfValueString);
        json.put("code", code);
        return json;
    }
}
