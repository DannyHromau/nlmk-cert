package com.nlmk.mes.rolling.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddedTomcatConfiguration {

    /**
     * Инициализация дополнительного порта для приложения.
     *
     * @param innerApiPort дополнительный порт.
     * @return ServletWebServerFactory
     */
    @Bean
    @ConditionalOnProperty(
            value = "server.innerApiPort")
    public ServletWebServerFactory servletContainer(@Value("${server.innerApiPort}") Integer innerApiPort) {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(redirectConnector(innerApiPort));
        return tomcat;
    }

    private Connector redirectConnector(Integer innerApiPort) {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(innerApiPort);
        connector.setSecure(false);
        return connector;
    }
}
