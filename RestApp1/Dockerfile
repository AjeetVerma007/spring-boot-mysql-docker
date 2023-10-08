FROM eclipse-temurin:17

LABEL mentainer="ajeet57@gmail.com"

WORKDIR /app

COPY target/spring_boot_docker.jar /app/spring_boot_docker.jar

ENTRYPOINT ["java", "-jar", "spring_boot_docker.jar"]