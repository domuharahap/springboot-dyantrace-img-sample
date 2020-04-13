From openjdk:8-jdk-alpine
copy ./target/users-0.0.1-SNAPSHOT.jar users-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","users-0.0.1-SNAPSHOT.jar"]
