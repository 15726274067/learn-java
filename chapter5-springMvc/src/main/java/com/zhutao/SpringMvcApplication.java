package com.zhutao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zhutao")
public class SpringMvcApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringMvcApplication.class);
    }
}
