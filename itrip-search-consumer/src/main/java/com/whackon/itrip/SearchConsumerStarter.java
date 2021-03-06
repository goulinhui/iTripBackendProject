package com.whackon.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>爱旅行-搜索业务模块消费者启动类</b>
 * @author 缑林辉
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SearchConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(SearchConsumerStarter.class, args);
	}
}
