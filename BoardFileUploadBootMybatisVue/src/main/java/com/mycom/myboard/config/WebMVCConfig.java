package com.mycom.myboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mycom.myboard.common.LoginInterceptor;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer{
	
	@Autowired
	LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(  "/",
																																			"/login/**",
																																			"/users/**",
																																			"/codes/**",
																																			"/css/**",
																																			"/js/**",
																																			"/img/**",
																																			"/favicon.ico"); // 템플릿에 적용시킬경우 assets안에 있을 가능성이 높으니 assets에도 적용시켜줘야한다.
	}
	
	// vue에서 withCredential = true로 하면 스프링에서 보안때문에 Origins을 * 로 표시를 못하게 해놨음
	// 그래서 딱 하나만 정확히 명시를 해야함 -> 만일 vue 프로젝트를 여러개 켜놨다면 ip 주소가 1씩 늘어나기 때문에 (5174, 5175)  이를 기억하고 있어야 됌
	// GET, POST는 웹 브라우저에서 신뢰하는 방식임, PUT, DELETE는 아직까지 신뢰할 수 없는 메소드로 지정해놨기 때문에 OPTIONS 요청을 해줘야 CORS 오류가 되지 않음
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3000);
    }
    
}
