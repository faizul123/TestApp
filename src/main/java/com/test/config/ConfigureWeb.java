package com.test.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureWeb implements ServletContextInitializer, EmbeddedServletContainerCustomizer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
      registerServlet(servletContext);
  }

  private void registerServlet(ServletContext servletContext) {
      
      ServletRegistration.Dynamic serviceServlet = servletContext.addServlet("Hello", new HelloServlet());

      serviceServlet.addMapping("/api/hello");
      serviceServlet.setAsyncSupported(false);
      serviceServlet.setLoadOnStartup(2);
  }

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		
	}
}