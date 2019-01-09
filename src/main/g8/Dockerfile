FROM rainist/sbt:$sbt_version$-slim-stretch AS build

LABEL maintainer="Rainist Engineering <engineering@rainist.com>"

WORKDIR /app

COPY ./project ./project
COPY ./build.sbt .

RUN sbt compile

ADD ./src /app/src

RUN sbt assembly

# Runtime
FROM openjdk:8u181-jre-slim-stretch

WORKDIR /app

COPY --from=build /app/target/scala-$scala_version_short$/app.jar /app/app.jar

ENTRYPOINT ["java"]
CMD ["-XX:+UnlockExperimentalVMOptions", \
  "-XX:+UseCGroupMemoryLimitForHeap", \
  "-XX:MaxRAMFraction=1", \
  "-jar", "app.jar"]
