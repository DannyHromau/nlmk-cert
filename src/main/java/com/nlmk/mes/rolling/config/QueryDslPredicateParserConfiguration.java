package com.nlmk.mes.rolling.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.querydsl.SimpleEntityPathResolver;
import org.springframework.data.querydsl.binding.CustomQuerydslBindingsFactory;
import org.springframework.data.querydsl.binding.CustomQuerydslPredicateArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class QueryDslPredicateParserConfiguration implements WebMvcConfigurer, ApplicationContextAware {

    private ConversionService conversionService;
    private ApplicationContext appContext;

    @Autowired
    @Lazy
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        CustomQuerydslBindingsFactory customQuerydslBindingsFactory = new CustomQuerydslBindingsFactory(
                SimpleEntityPathResolver.INSTANCE);
        customQuerydslBindingsFactory.setApplicationContext(appContext);
        CustomQuerydslPredicateArgumentResolver resolver =
                new CustomQuerydslPredicateArgumentResolver(customQuerydslBindingsFactory, conversionService);
        resolvers.add(resolver);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.appContext = applicationContext;
    }
}
