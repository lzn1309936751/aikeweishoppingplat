package com.config;

import com.interceptor.PrivilegeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author lzn
 */
@Configuration
@ComponentScan({"com.controller","com.interceptor"})
@Import(ServiceConfig.class)
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    private PrivilegeInterceptor privilegeInterceptor;

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp("/WEB-INF/views/", ".jsp");
//    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistry =
                registry.addInterceptor(privilegeInterceptor);
        interceptorRegistry.addPathPatterns("/admin/**");
        interceptorRegistry.excludePathPatterns("/static/**")
                .excludePathPatterns("/login/**") //显示视图(/login)与处理登录(/login/query)
                .excludePathPatterns("/unauthorized");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistration handlerRegistration=
                registry.addResourceHandler("/static/**");
        handlerRegistration.addResourceLocations("classpath:/static/");
    }
}
