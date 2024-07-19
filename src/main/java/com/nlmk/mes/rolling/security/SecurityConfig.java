package com.nlmk.mes.rolling.security;

import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    /**
     * Документация.
     */
    private static final String[] SWAGGER_ENDPOINTS = {"/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**"};

    /**
     * Актуатор.
     */
    private static final String ACTUATOR_ENDPOINTS = "/actuator/**";

    /**
     * Адреса не модифицирующих методов с типами POST PUT...
     */
    private static final String[] MODIFICATION_ENDPOINTS_FOR_VIEWER = {"/report/by-name/**", "/report/print-warehouse"};

    /**
     * Роль пользователя приложения.
     */
    @Value("${application.authRoles}")
    private String editorAuthRole;

    @Value("${application.authRolesViewer}")
    private String viewerAuthRole;

    @Value("${application.cors.allowed-origins}")
    private List<String> allowedOrigins;

    @Value("${server.innerApiPort:0}")
    private Integer innerApiPort;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    // Submits the KeycloakAuthenticationProvider to the AuthenticationManager
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    // Specifies the session authentication strategy
    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic().disable()
                .formLogin().disable()
                .logout().disable()
                .authorizeRequests()
                .requestMatchers(request -> request.getContextPath().startsWith(contextPath) &&
                        innerApiPort != null &&
                        request.getLocalPort() == innerApiPort)
                .permitAll()
                .antMatchers(SWAGGER_ENDPOINTS).permitAll()
                .antMatchers(ACTUATOR_ENDPOINTS).permitAll()
                .antMatchers(HttpMethod.GET).hasAnyRole(viewerAuthRole, editorAuthRole)
                .antMatchers(HttpMethod.POST, MODIFICATION_ENDPOINTS_FOR_VIEWER).hasAnyRole(viewerAuthRole, editorAuthRole)
                .antMatchers(HttpMethod.POST).hasRole(editorAuthRole)
                .antMatchers(HttpMethod.PUT).hasRole(editorAuthRole)
                .antMatchers(HttpMethod.PATCH).hasRole(editorAuthRole)
                .antMatchers(HttpMethod.DELETE).hasRole(editorAuthRole)
                .anyRequest().authenticated()
                .and().cors().configurationSource(request -> getCorsConfiguration());

    }

    private CorsConfiguration getCorsConfiguration() {
        var cors = new CorsConfiguration();
        var allowedAllValues = List.of("*");

        cors.setAllowedOrigins(allowedOrigins);
        cors.setAllowedMethods(allowedAllValues);
        cors.setExposedHeaders(allowedAllValues);
        cors.setAllowedHeaders(allowedAllValues);
        return cors;
    }
}
