#change to alpine ?
FROM ubuntu:latest
USER root
RUN apt-get update
RUN apt-get install wget -y
RUN wget https://download.java.net/java/GA/jdk17.0.2/dfd4a8d0985749f896bed50d7138ee7f/8/GPL/openjdk-17.0.2_linux-x64_bin.tar.gz
RUN tar xvf openjdk-17.0.2_linux-x64_bin.tar.gz
RUN mv jdk-17.0.2/ /opt/jdk-17/
RUN echo 'export JAVA_HOME=/opt/jdk-17' | tee -a ~/.bashrc && \
    echo 'export PATH=$PATH:$JAVA_HOME/bin '|tee -a ~/.bashrc && \
    . ~/.bashrc
ENV GENERIC_APP_FILENAME /app/main/Contacts-0.0.1-SNAPSHOT.jar
ENV PATH=$PATH:/opt/jdk-17/bin
RUN java --version

COPY ./build/libs/ /app/main/
# search for the jar file. this will find all jarfiles that are not plain
RUN find -type f -name "Contacts*-SNAPSHOT.jar" | grep ${GENERIC_APP_FILENAME}

#ENTRYPOINT java -jar -Dspring.profiles.active=production /app/main/Contacts-0.0.1-SNAPSHOT.jar
ENTRYPOINT java -jar -Dspring.profiles.active=production ${GENERIC_APP_FILENAME}