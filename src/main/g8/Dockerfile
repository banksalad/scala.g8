FROM rainist/sbt:$sbt_version$-alpine AS build

LABEL maintainer="Rainist Engineering <engineering@rainist.com>"

WORKDIR /app

COPY ./project ./project
COPY ./build.sbt .

RUN sbt compile

COPY ./src /app/src

RUN sbt assembly

# Runtime
FROM openjdk:openjdk:8-jre-alpine

WORKDIR /app

COPY --from=build /app/target/scala-$scala_version_short$/app.jar /app/app.jar

ENTRYPOINT ["java"]
CMD ["-XX:+UnlockExperimentalVMOptions", \
  "-XX:+UseCGroupMemoryLimitForHeap", \
  "-XX:MaxRAMFraction=1", \
  "-jar", "app.jar"]
