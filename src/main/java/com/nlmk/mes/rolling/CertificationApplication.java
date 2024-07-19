package com.nlmk.mes.rolling;

import com.nlmk.mes.rolling.config.CustomJpaRepositoryFactoryBean;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

@OpenAPIDefinition(info = @Info(title = "Сервис \"Сертификация\"", version = "1.0"),
        security = @SecurityRequirement(name = "bearerToken")
)
@SecurityScheme(
        name = "bearerToken",
        type = SecuritySchemeType.OAUTH2,
        scheme = "bearer",
        bearerFormat = "JWT",
        flows = @OAuthFlows(authorizationCode = @OAuthFlow(
                authorizationUrl = "https://sso-test.dp.nlmk.com/auth/realms/${keycloak.realm}/protocol/openid-connect/auth",
                tokenUrl = "https://sso-test.dp.nlmk.com/auth/realms/${keycloak.realm}/protocol/openid-connect/token"))
)
@SpringBootApplication(scanBasePackages = "com")
@EnableScheduling
@EnableCaching
@EnableRetry
@ConfigurationPropertiesScan
@EnableJpaRepositories(
        basePackages = "com.nlmk.mes.rolling",
        repositoryFactoryBeanClass = CustomJpaRepositoryFactoryBean.class
)
@SuppressWarnings({"checkstyle:UncommentedMain", "checkstyle:HideUtilityClassConstructor"})
public class CertificationApplication {

    /**
     * Метод - точка входа.
     *
     * @param args параметры командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(CertificationApplication.class, args);
    }
}
