package com.amzc.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//前后端完全分离不能使用后端拦截器，会出现CORS问题
//@Configuration
//public class MyWebConfigure implements WebMvcConfigurer {
//    @Bean
//    public LoginHandlerInterceptor getLoginHandlerInterceptor(){
//        return new LoginHandlerInterceptor();
//    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(getLoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
//    }
//}
