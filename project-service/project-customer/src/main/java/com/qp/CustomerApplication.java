package com.qp;

import com.qp.system.annotation.EnableRyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 玩家模块启动类
 *
 * @author Meixi
 * @version v1.0.0
 * @date 2020/3/16 9:35 35
 */
@SpringBootApplication
@EnableEurekaClient
@EnableRyFeignClients
@MapperScan("com.qp.*.mapper")
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
