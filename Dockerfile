FROM openjdk:21
RUN java -version
VOLUME /tmp
EXPOSE 8081
ADD ./build/libs/task_app_api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]