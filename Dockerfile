From ubuntu
RUN apt-get update
RUN apt-get install wget openjdk-8-jdk unzip -y
copy ./target/users-0.0.1-SNAPSHOT.jar users-0.0.1-SNAPSHOT.jar

ARG DT_API_URL="https://xxx****.live.dynatrace.com/api"
ARG DT_API_TOKEN="xx***-xxxxo********"
ARG DT_ONEAGENT_OPTIONS="flavor=default&include=java"
ENV DT_HOME="/opt/dynatrace/oneagent"
RUN mkdir -p "$DT_HOME" && \
    wget -O "$DT_HOME/oneagent.zip" "$DT_API_URL/v1/deployment/installer/agent/unix/paas/latest?Api-Token=$DT_API_TOKEN&$DT_ONEAGENT_OPTIONS" && \
    unzip -d "$DT_HOME" "$DT_HOME/oneagent.zip" && \
    rm "$DT_HOME/oneagent.zip"
ENTRYPOINT [ "/opt/dynatrace/oneagent/dynatrace-agent64.sh" ]
#CMD [ "executable", "param1", "param2" ]

CMD ["java","-jar","users-0.0.1-SNAPSHOT.jar"]
