package com.hrd.thymeleaf.configuration;

import java.util.Locale;

import org.codehaus.groovy.tools.shell.util.MessageSource;
import org.springframework.boot.autoconfigure.web.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// Front End
		registry.addViewController("/about").setViewName("/about");
		registry.addViewController("/contact").setViewName("/contact");
		registry.addViewController("/home").setViewName("/home");
		registry.addViewController("/").setViewName("/home");
	
		// Back End
		registry.addViewController("/admin/").setViewName("/admin/dashboard");
		registry.addViewController("/admin/dashboard").setViewName("/admin/dashboard");
		registry.addViewController("/admin/user").setViewName("/admin/user");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/*
		 * Static Resources store in the project
		 */
		registry.addResourceHandler("/resources/**")
					.addResourceLocations("classpath:/static/");
		/*
		 * Static Resources store outside the project
		 */
		registry.addResourceHandler("/files/**")
					.addResourceLocations("file:/opt/FILES_MANAGEMENT/images/");
	}
	
	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("kh"));
		resolver.setCookieName("Spring_Locale");
		resolver.setCookieMaxAge(4800);
		return resolver;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/i18n/messages/message");
		messageSource.setCacheSeconds(0);
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

}
