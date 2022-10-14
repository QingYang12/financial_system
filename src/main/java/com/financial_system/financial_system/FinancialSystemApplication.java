package com.financial_system.financial_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.financial_system.*")
public class FinancialSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancialSystemApplication.class, args);
    }

}
