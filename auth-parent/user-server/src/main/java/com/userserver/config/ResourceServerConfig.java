package com.userserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * @Author: Wxy
 * @Description:
 * @Date created in 11:03 2021/3/22
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * 配置RemoteTokenServices 的实例
     * @return
     */
    @Bean
    RemoteTokenServices tokenServices(){
        RemoteTokenServices services = new RemoteTokenServices();
        //授权端访问路径
        services.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
        //客户端Id
        services.setClientId("javaboy");
        //客户端密码
        services.setClientSecret("123");
        return services;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resource) throws Exception{
        resource.resourceId("res1").tokenServices(tokenServices());
    }

    @Override
    public void configure(HttpSecurity http) throws  Exception{
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .anyRequest().authenticated();
    }
}

