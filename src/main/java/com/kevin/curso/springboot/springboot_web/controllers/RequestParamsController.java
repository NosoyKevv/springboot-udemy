package com.kevin.curso.springboot.springboot_web.controllers;

import com.kevin.curso.springboot.springboot_web.models.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "DEFAULT MENSAJE") String message) { //espera recibir un parametro de la ruta url de tipo get con nombre message
        //REQUIRED lo ponemos por defecto en false sirve para controlar errores
        ParamDto param = new ParamDto();
        param.setMessage(message != null ? message : "MENSAJE");//SE PUEDE PONER UN CONDICINOAL PARA PONER UN MENSAJE POR DEFECTO CUANDO NO LLEGUE NADA TAMBIEN SE PUEDE CON UN DEFAULT VALUE
        return param;
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam String text, @RequestParam String data, @RequestParam Integer code) {

        ParamDto params = new ParamDto();
        params.setMessage(text);//NUESTRO MESSAGE ES EL TEXT PARA REUTILIZAR
        params.setData(data);
        params.setCode(code);
        return params;

    }

    @GetMapping("/request")
    public ParamDto request(HttpServletRequest request) {
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));

        } catch (NumberFormatException e) {

        }
        ParamDto params = new ParamDto();
        params.setCode(code);//OBTENEMOS EL PARAMETRO CODE DEL URL LO QUE CONTIENE CLARO code=123->PARAMETRO DE URL
        params.setMessage(request.getParameter("message"));
        params.setData(request.getParameter("data"));
        return params;

    }
}
