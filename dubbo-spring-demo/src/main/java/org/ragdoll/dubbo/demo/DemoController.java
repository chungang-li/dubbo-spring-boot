package org.ragdoll.dubbo.demo;

import org.ragdoll.dubbo.demo.provider.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/demo")
    public String getName(String name) {
        return demoService.sayHello(name);
    }

}
