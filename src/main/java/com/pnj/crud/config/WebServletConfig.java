package com.pnj.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan({"com.pnj.crud.controller"})
public class WebServletConfig {
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**");
    }*/

//    @Bean
//    public CommonsMultipartResolver multipartResolver() throws Exception {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("utf-8");
//        resolver.setMaxInMemorySize(2097152);
//
//        return resolver;
//    }

}
