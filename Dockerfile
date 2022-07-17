FROM openjdk:13-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY /elastic-apm-agent-1.33.0.jar apm-agent.jar
ENTRYPOINT ["java","-javaagent:/apm-agent.jar","-Delastic.apm.service_name=my-application","-Delastic.apm.server_url=http://apm-server:8200","-Delastic.apm.secret_token=","-Delastic.apm.application_packages=org.example","-jar","/app.jar"]