FROM openjdk:17.0.2-jdk
COPY build/libs/*-all.jar app.jar
EXPOSE 8080 8081
CMD java ${JAVA_OPTS} -jar app.jar
