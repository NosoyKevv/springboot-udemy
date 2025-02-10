package com.kevin.curso.springboot.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySources({
        @PropertySource("classpath:values.properties"),
})
public class ValuesConfig {

}
