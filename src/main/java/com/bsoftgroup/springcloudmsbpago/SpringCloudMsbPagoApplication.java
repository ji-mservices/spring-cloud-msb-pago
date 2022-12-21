package com.bsoftgroup.springcloudmsbpago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;


@SpringBootApplication
@EnableFeignClients("com.bsoftgroup.springcloudmsbpago.interfaces")
@EnableDiscoveryClient
//@EnableHystrix
public class SpringCloudMsbPagoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudMsbPagoApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

//	@Bean
//	//Habilitar el CORS para poder utilizar utilizar JWT
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedMethods("POST", "GET", "PUT", "DELETE", "HEAD")
//						.allowedOrigins("*")
//						.allowCredentials(false);
//			}
//		};
//	}

}
