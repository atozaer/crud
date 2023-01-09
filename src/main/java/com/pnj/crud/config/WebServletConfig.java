package com.pnj.crud.config;

import com.pnj.crud.repository.MemberRepositoryCustom;
import com.pnj.crud.repository.MemberRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.persistence.EntityManager;

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
    @Autowired
    EntityManager entityManager;


}
