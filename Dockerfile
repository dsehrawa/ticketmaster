FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ticketmaster.jar
ENV MYSQL_HOST=<MYSQL_HOST>
EXPOSE 9090
ENTRYPOINT ["java","-jar","/ticketmaster.jar"]