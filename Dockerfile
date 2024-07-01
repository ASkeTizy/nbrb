FROM openjdk:17.0.2-jdk
COPY . /app
WORKDIR /app
RUN ./mvn compile
EXPOSE 8080
WORKDIR /app
cmd