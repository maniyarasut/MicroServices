package com.gateway.gatewayServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.google.common.collect.ImmutableList;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}
	
	@Bean
	public CorsFilter cotsRestrictedFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod(HttpMethod.DELETE);
		config.addAllowedMethod(HttpMethod.GET);
		config.addAllowedMethod(HttpMethod.HEAD);
		config.addAllowedMethod(HttpMethod.HEAD);
		config.addAllowedMethod(HttpMethod.PATCH);
		config.addAllowedMethod(HttpMethod.POST);
		config.addAllowedMethod(HttpMethod.PUT);
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("GET");
		config.addAllowedMethod(".HEAD");
		config.addAllowedMethod("HEAD");
		config.addAllowedMethod("PATCH");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		
		config.setExposedHeaders(ImmutableList.of("X-Auth-Token","Authorization",
				"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"));
		
		source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}

}
