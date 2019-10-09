package com.stackroute.config;


import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WebConfig {

    @Bean
    public ServletRegistrationBean reg()
    {
        ServletRegistrationBean reg = new ServletRegistrationBean(new WebServlet());
        reg.addUrlMappings("/console/*");
        return reg;
    }
}
