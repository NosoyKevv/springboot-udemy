package com.kevin.curso.springboot.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySources({
        @PropertySource("classpath:values.properties")//creo q la nueva actu no hay que ver nada de caracteres especiales iso 8859-1 gosu
        //@PropertySource(value = "classpath:values.properties", encoding = "UTF-8"),//Podemos usar el utf8 para los valores que entran para no mosotrar errores tambien se puede usar cui cui la iso 8859-1
})//revisar esquina inferior derecha UTF-8 O ISO 8859-1
public class ValuesConfig {

}
