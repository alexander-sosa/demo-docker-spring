FROM debian:10.11

# Installing the objects needed
RUN apt update
RUN apt install -y curl
RUN curl -O https://cdn.azul.com/zulu/bin/zulu11.54.25-ca-jdk11.0.14.1-linux_x64.tar.gz
RUN tar xvfz zulu11.54.25-ca-jdk11.0.14.1-linux_x64.tar.gz

# Common env vars setting in Linux
# RUN export set JAVA_HOME=/zulu11.54.25-ca-jdk11.0.14.1-linux_x64
# RUN export set PATH=$JAVA_HOME/bin:$PATH

# Env vars setting in Docker
ENV JAVA_HOME /zulu11.54.25-ca-jdk11.0.14.1-linux_x64
ENV PATH $JAVA_HOME/bin:$PATH

WORKDIR /app
COPY . .
RUN /app/mvnw clean package

ENTRYPOINT ["/app/mvnw", "spring-boot:run"]
