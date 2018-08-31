package com.github.bluven.demo;

import com.github.bluven.demo.properties.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@ServletComponentScan
@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
@EnableConfigurationProperties({JwtProperties.class})
@MapperScan(basePackages = "com.github.bluven.mapper")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}