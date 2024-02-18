package com.growerportal.GrowerPortal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Set the URL pattern for which CORS should be enabled
                .allowedOrigins("http://localhost:3000", "https://cs.growerportal.supremerice.com", "grower-portal-412701.uc.r.appspot.com") // Replace with your React app's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/{spring:\\w+}")
//                .setViewName("forward:/");
//        registry.addViewController("/**/{spring:\\w+}")
//                .setViewName("forward:/");
//        registry.addViewController("/{spring:\\w+}/**{spring:?!(\\.js|\\.css)$}")
//                .setViewName("forward:/");
//    }
}
