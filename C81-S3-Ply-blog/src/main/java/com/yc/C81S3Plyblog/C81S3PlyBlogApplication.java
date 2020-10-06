package com.yc.C81S3Plyblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yc.C81S3Plyblog.web.LoginInterceptor;

@SpringBootApplication
@MapperScan("com.yc.C81S3Plyblog.dao")
// SpringMVC 配置拦截器( SpringBoot 工程)
public class C81S3PlyBlogApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(C81S3PlyBlogApplication.class, args);
	}

	/**
	 * 注册拦截器的方法,  WebMvcConfigurer提供
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器地址要以 / 开头
		 */
		registry.addInterceptor(new LoginInterceptor())
				.addPathPatterns("/toAddArticle","/addArticle","/reply.do");
	}

	/**
	 * 实现静态资源映射配置
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**") // 设置 web 的路径
			.addResourceLocations("classpath:/static/");	 // 设置本地目录路径
		registry.addResourceHandler("/imgs/**") // 设置 web 的路径
			.addResourceLocations("file:///d:/cr_img/");	 // 设置本地目录路径
	}

	
	
}
