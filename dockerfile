FROM openjdk:23-rc-slim

WORKDIR /app
COPY . .

ENTRYPOINT ["java","Main.java"]