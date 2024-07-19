FROM openjdk:17.0.1-slim as builder

COPY target/nlmk-mes-certification-*.jar /opt/app.jar

RUN java -Djarmode=layertools -jar /opt/app.jar extract

FROM openjdk:17.0.1-slim

COPY --from=builder dependencies/ /opt/
COPY --from=builder spring-boot-loader/ /opt/
COPY --from=builder internal-dependencies/ /opt/
COPY --from=builder snapshot-dependencies/ /opt/
COPY --from=builder application/ /opt/

WORKDIR /opt/

ENTRYPOINT java $JAVA_ARGS -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS org.springframework.boot.loader.JarLauncher --spring.profiles.active=container
