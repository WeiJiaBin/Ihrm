package com.ihrm.system;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.common.utils.JwtUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

//配置springboot的包扫描
@SpringBootApplication(scanBasePackages = "com.ihrm")
@EntityScan(value = "com.ihrm.domain.system") //配置jpa注解的扫描
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class);

    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

    @Bean
    public JwtUtils jwtUtils() {
        return new JwtUtils();
    }
}
