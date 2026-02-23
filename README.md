# CI/CD 파이프라인 아키텍처

본 프로젝트는 GitHub Actions와 Google Cloud Platform(GCP)을 활용하여 자동화된 CI/CD 파이프라인을 구축했습니다. 코드가 푸시되면 빌드, 테스트, Docker 이미지 생성 및 배포 과정이 자동으로 수행됩니다.

## 아키텍처 다이어그램

추후 업데이트 예정

## 파이프라인 워크플로우

1.  **코드 푸시 (Code Push):** 개발자가 코드를 GitHub 레포지토리의 `main` 브랜치에 푸시합니다.
2.  **CI 트리거 (CI Trigger):** GitHub Actions가 이벤트를 감지하고 워크플로우를 시작합니다.
3.  **빌드 및 테스트 (Build & Test):** Java/Gradle 환경에서 프로젝트를 빌드하고 유닛 테스트를 수행합니다.
4.  **컨테이너화 (Dockerize):** 애플리케이션을 Docker 이미지로 빌드합니다.
5.  **이미지 푸시 (Push Image):** 빌드된 Docker 이미지를 GCP Artifact Registry에 안전하게 푸시합니다.
6.  **자동 배포 (Deploy):** Artifact Registry에 새 이미지가 업데이트되면, Google Cloud Run 서비스가 이를 감지하고 자동으로 새 버전으로 배포합니다.

## 기술 스택 (Tech Stack)

* **CI/CD:** GitHub Actions
* **Containerization:** Docker
* **Artifact Repository:** Google Cloud Artifact Registry
* **Serverless Deployment:** Google Cloud Run
* **Build Tool:** Gradle
* **Language:** Java 17
* **Framework:** Spring Boot 4.0.3
