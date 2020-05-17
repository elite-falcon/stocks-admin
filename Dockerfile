# Dockerfile
FROM openjdk:8-jdk
ADD target/*.jar stocks-market-admin.jar
CMD java $JAVA_OPTS -jar /stocks-market-admin.jar
