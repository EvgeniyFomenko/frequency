FROM amazoncorretto:11
LABEL authors="Фоменко Евгений"
COPY target/*.jar app.jar
CMD ["java","-jar","/app.jar"]