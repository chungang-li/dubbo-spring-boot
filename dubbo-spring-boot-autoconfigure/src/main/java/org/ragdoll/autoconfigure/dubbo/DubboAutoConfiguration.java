package org.ragdoll.autoconfigure.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ApplicationConfig.class)
@EnableConfigurationProperties(DubboProperties.class)
public class DubboAutoConfiguration {


    private final DubboProperties dubboProperties;

    public DubboAutoConfiguration(DubboProperties dubboProperties) {
        this.dubboProperties = dubboProperties;
    }


    @Bean
    @ConditionalOnMissingBean(ApplicationConfig.class)
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = dubboProperties.getApplication().buildConfig();
        return applicationConfig;
    }


    @Bean
    @ConditionalOnMissingBean(RegistryConfig.class)
    public RegistryConfig registryConfig() {
        return dubboProperties.getRegistry().buildConfig();
    }

    @Bean
    @ConditionalOnProperty(name = "name", prefix = "spring.dubbo.protocol")
    public ProtocolConfig protocolConfig() {
        return dubboProperties.getProtocol().buildConfig();
    }

    @Bean
    @ConditionalOnProperty(name = "group", prefix = "spring.dubbo.provider")
    public ProviderConfig providerConfig(){
        return dubboProperties.getProvider().buildConfig();
    }
}
