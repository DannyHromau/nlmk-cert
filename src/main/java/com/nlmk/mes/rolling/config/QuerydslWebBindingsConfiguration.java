package com.nlmk.mes.rolling.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.querydsl.SimpleEntityPathResolver;
import org.springframework.data.querydsl.binding.CustomQuerydslBindingParamsMapper;
import org.springframework.data.querydsl.binding.CustomQuerydslBindingsFactory;
import org.springframework.data.querydsl.binding.CustomQuerydslPredicateBuilder;
import org.springframework.data.querydsl.binding.impl.CustomQuerydslBindingParamsMapperImpl;

@Configuration
@RequiredArgsConstructor
public class QuerydslWebBindingsConfiguration {

    private final ApplicationContext appContext;
    private final ConversionService conversionService;

    @Bean
    CustomQuerydslBindingParamsMapper customQuerydslBindingParamsMapper() {
        return new CustomQuerydslBindingParamsMapperImpl();
    }

    @Bean
    CustomQuerydslBindingsFactory customQuerydslBindingsFactory() {
        CustomQuerydslBindingsFactory customQuerydslBindingsFactory = new CustomQuerydslBindingsFactory(
                SimpleEntityPathResolver.INSTANCE);
        customQuerydslBindingsFactory.setApplicationContext(appContext);
        return customQuerydslBindingsFactory;
    }

    @Bean
    CustomQuerydslPredicateBuilder customQuerydslPredicateBuilder(CustomQuerydslBindingsFactory customQuerydslBindingsFactory) {
        return new CustomQuerydslPredicateBuilder(conversionService, customQuerydslBindingsFactory.getEntityPathResolver());
    }
}
