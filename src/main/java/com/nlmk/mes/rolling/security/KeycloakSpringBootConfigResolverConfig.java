package com.nlmk.mes.rolling.security;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakSpringBootConfigResolverConfig {

    /**
     * Бин для настройки keycloak.
     *
     * @return бин
     */
    @SuppressWarnings("checkstyle:MethodName")
    @Bean
    public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

}
