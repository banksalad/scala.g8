FROM rainist/sbt:$sbt_version$-alpine AS compile

LABEL maintainer="Rainist Engineering <engineering@rainist.com>"

WORKDIR /app

COPY ./project ./project
COPY ./build.sbt .

RUN sbt compile


# Builder
FROM rainist/sbt:$sbt_version$-alpine AS build

WORKDIR /app

COPY --from=compile /app .
COPY ./src ./src

RUN sbt assembly


# Runtime
FROM openjdk:8-jre-alpine

WORKDIR /app

COPY --from=build /app/target/app.jar ./app.jar

ENTRYPOINT ["java"]
CMD ["-XX:+UnlockExperimentalVMOptions", \
  "-XX:+UseCGroupMemoryLimitForHeap", \
  "-XX:MaxRAMFraction=1", \
  "-jar", "app.jar"]
