package org.ragdoll.dubbo.demo;

import com.alibaba.dubbo.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private ApplicationConfig applicationConfig;

    @RequestMapping("/demo")
    public String getName() {
        return applicationConfig.getName();
    }

}
