package com.example.eureka.server_dame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerDameApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerDameApplication.class, args);
	}

}
