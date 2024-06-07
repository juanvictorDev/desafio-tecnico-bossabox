FROM amazoncorretto:21-alpine
WORKDIR /java
COPY vuttr-api.jar .
ENTRYPOINT [ "java", "-jar", "vuttr-api.jar" ]
