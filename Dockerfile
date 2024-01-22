FROM amazoncorretto:17
LABEL authors="Фоменко Евгений"
COPY target/*.jar app.jar
CMD ["java","-jar","/app.jar"]