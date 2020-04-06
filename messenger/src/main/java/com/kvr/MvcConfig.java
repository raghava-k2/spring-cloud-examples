package com.kvr;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@SuppressWarnings("deprecation")
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false).
				favorParameter(true).
				parameterName("format").
				ignoreAcceptHeader(true).
				useJaf(false).defaultContentType(MediaType.APPLICATION_JSON).mediaType("xml", MediaType.APPLICATION_XML)
				.mediaType("json", MediaType.APPLICATION_JSON);
	}
}
