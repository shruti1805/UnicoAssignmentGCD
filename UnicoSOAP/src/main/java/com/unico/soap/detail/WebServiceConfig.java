package com.unico.soap.detail;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * /**
 * WebServiceConfig provides funcationalities of WsConfigurerAdapter to
 * create Dispatcher Servlet, default Wsdl Definition and xsdScema
 * 
 * @author Shruti Mahapatra
 *
 */

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	
	public Logger logger =  LogManager.getLogger(WebServiceConfig.class); 
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		logger.debug("Inside ServletRegistrationBean");
		return new ServletRegistrationBean(servlet, "/unico/ws/*");
	}

	@Bean(name = "gcd")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema gcdSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("gcdPort");
		wsdl11Definition.setLocationUri("/unico/ws");
		wsdl11Definition.setTargetNamespace("http://unico/assignment/soap/webservice");
		wsdl11Definition.setSchema(gcdSchema);
		
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema gcdSchema() {
		return new SimpleXsdSchema(new ClassPathResource("gcd.xsd"));
	}
}