package org.ragdoll.dubbo.demo;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("org.ragdoll.dubbo.demo.provider")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
