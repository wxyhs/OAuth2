package com.authorserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @Author: Wxy
 * @Description:
 * @Date created in 15:34 2021/3/19
 */
@Configuration
public class AccessTokenConfig {

    /**
     * 提供了一个 Token  存入内存中
     * @return
     */
    @Bean
    TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }
}
