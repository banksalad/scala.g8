FROM rainist/sbt:$sbt_version$-alpine AS builder

LABEL maintainer="Rainist Engineering <engineering@rainist.com>"

WORKDIR /app

COPY ./project ./project
COPY ./build.sbt .
COPY ./src ./src

RUN sbt 'set test in assembly := {}' clean assembly


# Runtime
FROM openjdk:8-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/app.jar ./app.jar

ENTRYPOINT ["java"]
CMD ["-XX:+UnlockExperimentalVMOptions", \
  "-XX:+UseCGroupMemoryLimitForHeap", \
  "-XX:MaxRAMFraction=1", \
  "-jar", "app.jar"]
