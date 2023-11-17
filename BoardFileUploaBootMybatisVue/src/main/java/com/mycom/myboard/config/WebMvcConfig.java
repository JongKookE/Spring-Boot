package com.mycom.myboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mycom.myboard.common.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Autowired
	LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) { // interceptorRegistry라는 저장소에 interceptor를 집어넣자.
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns(
						"/",
						"/login/**",
						"/users/**",
						"/codes/**",
						"/css/**",
						"/js/**",
						"/img/**",
						"/favicon.ico"
						
					); // 모든 요청에대해 인터셉터를 적용시키고, exclude로 되어있는건 다 적용X
		
	}
	
	// vue에서 withcredential = true로 오는걸 원래는 컨트롤러에 crossOrigin 어노테이션을 다 등록해야하는데 귀찮음. 그래서 webMvcConfig에서 http://localhost:5173 이거에대한걸 허용해준다.
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // get, post는 기본적으로 모든 웹서버에서 default로 구현했다고 가정한다.
                //근데 put,delete는 신뢰할 수 없는 메소드로 아직까지 지정이 되어있기때문에 put, delete 요청전에 options 메소로 먼저 put,delete를 받을 수 있는지 확인한다.
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3000);
    }
}
