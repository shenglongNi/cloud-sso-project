package sso.cloud.service.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig {

	/**
	 * 配置默认的错误页面， 仅适用于默认的内嵌tomcat，打成war包在tomcat中部署后不会起作用
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomier() {
		
		return new EmbeddedServletContainerCustomizer() {

			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/errorpage/500"));
				container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/errorpage/404.html"));
			}
			
		};
		
	}
}
