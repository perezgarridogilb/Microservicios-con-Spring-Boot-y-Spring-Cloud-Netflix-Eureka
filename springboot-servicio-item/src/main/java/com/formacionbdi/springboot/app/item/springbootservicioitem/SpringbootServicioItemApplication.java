package com.formacionbdi.springboot.app.item.springbootservicioitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
/** 
 * Necesario debido a que necesitamos feign como cliente para conectar a las API rest 
 * Ribbon ya viene ímplicito en eureka
*/
@EnableFeignClients

@SpringBootApplication
public class SpringbootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemApplication.class, args);
	}

}
