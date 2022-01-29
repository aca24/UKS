FROM openjdk:11
EXPOSE 8080
ADD target/minigithub-docker.jar minigithub-docker.jar
ENTRYPOINT ["java","-jar","/minigithub-docker.jar"]