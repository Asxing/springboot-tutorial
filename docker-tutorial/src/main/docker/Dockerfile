FROM openjdk:8-jdk

ENV PORT 58080
EXPOSE 58080

COPY *.jar /opt/target/
WORKDIR /opt/target

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENV JAVA_OPTS="$JAVA_OPTS -Xms256m -Xmx512m"

CMD ["/bin/bash", "-c", "mkdir logs && java $JAVA_OPTS -jar *.jar 2>&1 | tee ./logs/app.log"]