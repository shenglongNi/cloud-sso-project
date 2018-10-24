package sso.cloud.service.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import freemarker.template.TemplateException;


@Configuration
public class FreeMarkerConfig {

	@Bean
	public ViewResolver freeMarkerViewResolver() {
		FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
		
		freeMarkerViewResolver.setPrefix("/");
		freeMarkerViewResolver.setSuffix(".html");
		freeMarkerViewResolver.setCache(true);
		freeMarkerViewResolver.setRequestContextAttribute("request");
		freeMarkerViewResolver.setExposeRequestAttributes(true);
		freeMarkerViewResolver.setExposeSessionAttributes(true);
		freeMarkerViewResolver.setExposeSpringMacroHelpers(true);
		freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
		return freeMarkerViewResolver;
	}
	
	@Bean
	public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		FreeMarkerConfigurationFactory configurationFactory = new FreeMarkerConfigurationFactory();
		
		configurationFactory.setTemplateLoaderPath("classpath:/templates/views");
		configurationFactory.setDefaultEncoding("utf-8");
		freemarker.template.Configuration createConfiguration = configurationFactory.createConfiguration();
		configurer.setConfiguration(createConfiguration);
		
//		configurer.setFreemarkerSettings(settings);
//		configurer.setFreemarkerVariables(variables);
		return configurer;
	}
	
}
