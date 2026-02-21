# 1단계: Build (Gradle 8.x + JDK 17)
FROM gradle:8.5-jdk17 AS build
WORKDIR /home/gradle/src

# 빌드 캐시 활용을 위한 설정 파일 선복사
COPY --chown=gradle:gradle gradlew .
COPY --chown=gradle:gradle gradle gradle
COPY --chown=gradle:gradle build.gradle settings.gradle ./

# 소스 복사 및 빌드
COPY --chown=gradle:gradle . .
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon -x test

# 2단계: Run (경량 JRE)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar

# 컨테이너 실행 최적화 설정
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]