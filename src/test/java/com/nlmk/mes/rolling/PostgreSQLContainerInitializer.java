package com.nlmk.mes.rolling;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.Map;

public class PostgreSQLContainerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public static PostgreSQLContainer postgreSQLContainer;

    static {
        DockerImageName postgresContainerLocal = DockerImageName
                .parse("docker-registry.dp.nlmk.com/postgres:13.0")
                .asCompatibleSubstituteFor("postgres");
        postgreSQLContainer = new PostgreSQLContainer<>(postgresContainerLocal)
                .withTmpFs(Map.of("/var/lib/postgresql/data", "rw"))
                .withDatabaseName("task-tests-db")
                .withUsername("sa")
                .withPassword("sa");
        setMaxConnections(postgreSQLContainer);
        postgreSQLContainer.start();
    }

    private static void setMaxConnections(PostgreSQLContainer postgreSQLContainer2) {
        postgreSQLContainer2.setCommand("postgres", "-c", "max_connections=500");
    }

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        TestPropertyValues.of(
                "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                "spring.datasource.password=" + postgreSQLContainer.getPassword()
        ).applyTo(configurableApplicationContext.getEnvironment());
    }
}
