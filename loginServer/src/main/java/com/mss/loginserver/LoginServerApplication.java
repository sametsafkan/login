package com.mss.loginserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * 
 * @author sametsafkan
 *
 */
@EnableReactiveMongoRepositories
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients(basePackages = {"com.mss.loginserver.service"})
public class LoginServerApplication {

	final static String queueName = "OtpQueue";
	
	public static void main(String[] args) {
		SpringApplication.run(LoginServerApplication.class, args);
	}
}
