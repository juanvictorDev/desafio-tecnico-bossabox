FROM amazoncorretto:21-alpine
RUN apk --no-cache add tzdata
ENV TZ=America/Sao_Paulo
WORKDIR /java
COPY vuttr-api.jar .
ENTRYPOINT [ "java", "-jar", "vuttr-api.jar" ]
