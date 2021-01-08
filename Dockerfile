FROM adoptopenjdk:11-jre-hotspot

COPY ./DTUPay-server/target/DTUPay-server-1.0.0-SNAPSHOT-runner.jar /usr/src

COPY ./DTUPay-server/target/lib /usr/src/lib

EXPOSE 1617

WORKDIR /usr/src

CMD java -Xmx64m \
      -jar DTUPay-server-1.0.0-SNAPSHOT-runner.jar

